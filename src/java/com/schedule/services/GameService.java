package com.schedule.services;

import com.schedule.DAO.GameDAO;
import com.schedule.DAO.SportDAO;
import com.schedule.DAO.TeamDAO;
import com.schedule.Models.Game;
import com.schedule.Models.Sport;
import com.schedule.Models.Team;
import com.schedule.config.Config;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.schedule.validators.GameValidator;

public class GameService implements Service {

    private static final String GET = "GET";
    private static final String POST = "POST";
    private static final String MAIN = "";
    
    private GameValidator gameValidator;
    private GameDAO gameDAO;
    private TeamDAO teamDAO;
    private SportDAO sportDAO;
    
    public GameService() {
        gameValidator = new GameValidator();
        
        gameDAO = new GameDAO();
        teamDAO = new TeamDAO();
        sportDAO = new SportDAO();
    }
    
    @Override
    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int firstTeamId = Integer.parseInt(request.getParameter("first-team"));
            int secondTeamId = Integer.parseInt(request.getParameter("second-team"));
            int sportId = Integer.parseInt(request.getParameter("sport"));
            int first = Integer.parseInt(request.getParameter("first"));
            int second = Integer.parseInt(request.getParameter("second"));
            Date date = getDate(request, response);
        
            Team firstTeam = teamDAO.get(firstTeamId);
            Team secondTeam = teamDAO.get(secondTeamId);
            Sport sport = sportDAO.get(sportId);

            Game game = new Game(firstTeam, secondTeam, sport, date, new Pair<>(first, second));

            String message = "";

            if (gameValidator.isValid(game)) {
                gameDAO.add(game);
            } else {
                message = "You've entered wrong date. Try again!";
            }

            showAll(request, response, message);
        } catch (Exception e) {
            response.sendError(400);
        }
    }
    
    @Override
    public void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showAll(request, response, "");
    }
    
    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = -1;
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (Exception e) {
            response.sendError(400);
        }
        
        if (request.getMethod().equals(GET)) {
            forwardToUpdate(request, response, "");
        } else {
            int firstTeamId = -1, secondTeamId = -1, sportId = -1, first= -1, second = -1;
            try {
                firstTeamId = Integer.parseInt(request.getParameter("first-team"));
                secondTeamId = Integer.parseInt(request.getParameter("second-team"));
                sportId = Integer.parseInt(request.getParameter("sport"));
                first = Integer.parseInt(request.getParameter("first"));
                second = Integer.parseInt(request.getParameter("second"));
            } catch (Exception e) {
                response.sendError(400);
            }
            
            Date date = getDate(request, response);
            
            Team firstTeam = teamDAO.get(firstTeamId);
            Team secondTeam = teamDAO.get(secondTeamId);
            
            Sport sport = sportDAO.get(sportId);
            
            Game game = new Game(firstTeam, secondTeam, sport, date, new Pair<>(first, second));
            
            if (gameValidator.isValid(game)) {
                update(id, game);
                response.sendRedirect(MAIN);
            } else {
                forwardToUpdate(request, response, "You've entered wrong data. Try again!");
            }
        }
    }
    
    private void update(int id, Game game) {
        game.setId(id);
        
        gameDAO.update(id, game);
    }
    
    private void forwardToUpdate(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        String filepath = "/WEB-INF/pages/game-update.jsp";
        int gameId = -1;
        try {
            gameId = Integer.parseInt(request.getParameter("id"));
        } catch (Exception e) {
            response.sendError(400);
        }

        Game game = gameDAO.get(gameId);

        ArrayList<Team> teams = teamDAO.getAll();
        ArrayList<Sport> sports = sportDAO.getAll();

        request.setAttribute("teams", teams);
        request.setAttribute("sports", sports);
        request.setAttribute("game", game);
        request.setAttribute("message", message);
        
        request.getRequestDispatcher(filepath).forward(request, response);
    }
    
    @Override
    public int delete(HttpServletRequest request) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            gameDAO.delete(id);
        } catch (Exception e) {
            return Config.BAD_REQUEST;
        }
        return Config.SUCCESS;
    }
    
    private void showAll(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        String filepath = "/WEB-INF/pages/admin.jsp";
        
        ArrayList<Game> games = gameDAO.getAll();
        ArrayList<Team> teams = teamDAO.getAll();
        ArrayList<Sport> sports = sportDAO.getAll();
                
        request.setAttribute("games", games);
        request.setAttribute("teams", teams);
        request.setAttribute("sports", sports);
        request.setAttribute("message", message);
        
        request.getRequestDispatcher(filepath).forward(request, response);
    }
    
    private Date getDate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String sDate = null;
        try {
            sDate = request.getParameter("date");
        } catch (Exception e) {
            response.sendError(400);
        }
        sDate = sDate.replace("T", " ");
        
        Date date = new Date();
        try {
            date = (new SimpleDateFormat(Config.DATE_FORMAT)).parse(sDate);
        } catch (ParseException ex) {
            Logger.getLogger(GameService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }
    
}
