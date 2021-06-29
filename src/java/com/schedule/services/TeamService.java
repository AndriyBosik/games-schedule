package com.schedule.services;

import com.schedule.DAO.TeamDAO;
import com.schedule.Models.Team;
import com.schedule.config.Config;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.schedule.validators.TeamValidator;

public class TeamService implements Service {
    
    private static final String GET = "GET";
    private static final String POST = "POST";
    private static final String MAIN = "teams";
    
    private TeamValidator teamValidator;
    private TeamDAO teamDAO;
    
    public TeamService() {
        teamValidator = new TeamValidator();
        
        teamDAO = new TeamDAO();
    }
    
    @Override
    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String name = request.getParameter("team-name");
        
            Team team = new Team(name);

            String message = "";

            if (teamValidator.isValid(team)) {
                teamDAO.add(team);
            } else {
                message = "You've entered wrong data. Try again!";
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
        if (request.getMethod().equals(GET)) {
            forwardToUpdate(request, response, "");
        } else {
            String name = request.getParameter("team-name");
            int id = -1;
            try {
                id = Integer.parseInt(request.getParameter("id"));
            } catch (Exception e) {
                response.sendError(400);
            }
            
            Team team = new Team(name);
            
            if (teamValidator.isValid(team)) {
                update(id, team);
                response.sendRedirect(MAIN);
            } else {
                forwardToUpdate(request, response, "You've entered wrong data. Try again!");
            }
        }
    }
    
    private void update(int id, Team team) {
        team.setId(id);
        
        teamDAO.update(id, team);
    }
    
    private void forwardToUpdate(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        String filepath = "/WEB-INF/pages/team-update.jsp";
        
        int id = -1;
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (Exception e) {
            response.sendError(400);
        }
            
        Team team = teamDAO.get(id);

        request.setAttribute("team", team);
        request.setAttribute("message", message);
        
        request.getRequestDispatcher(filepath).forward(request, response);
    }
    
    @Override
    public int delete(HttpServletRequest request) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            teamDAO.delete(id);
        } catch (Exception e) {
            return Config.BAD_REQUEST;
        }
        return Config.SUCCESS;
    }
    
    private void showAll(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        String filepath = "/WEB-INF/pages/teams.jsp";
        
        ArrayList<Team> teams = teamDAO.getAll();
        
        request.setAttribute("message", message);
        request.setAttribute("teams", teams);
        
        request.getRequestDispatcher(filepath).forward(request, response);
    }
    
}
