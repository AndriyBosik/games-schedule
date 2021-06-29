package com.schedule.services;

import com.schedule.DAO.SportDAO;
import com.schedule.Models.Sport;
import com.schedule.config.Config;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.schedule.validators.SportValidator;

public class SportService implements Service {

    private static final String GET = "GET";
    private static final String POST = "POST";
    private static final String MAIN = "sports";
    
    private SportValidator sportValidator;
    private SportDAO sportDAO;
    
    public SportService() {
        sportValidator = new SportValidator();
        
        sportDAO = new SportDAO();
    }
    
    @Override
    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String name = request.getParameter("sport-name");
        
            Sport sport = new Sport(name);

            String message = "";

            if (sportValidator.isValid(sport)) {
                sportDAO.add(sport);
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
        if (request.getMethod().equals(GET)) {
            forwardToUpdate(request, response, "");
        } else {
            String name = request.getParameter("sport-name");
            int id = -1;
            try {
                id = Integer.parseInt(request.getParameter("id"));
            } catch (Exception e) {
                response.sendError(400);
            }
            
            Sport sport = new Sport(name);
            
            if (sportValidator.isValid(sport)) {
                update(id, sport);
                response.sendRedirect(MAIN);
            } else {
                forwardToUpdate(request, response, "You've entered wrong data. Try again!");
            }
        }
    }
    
    private void update(int id, Sport sport) {
        sport.setId(id);
        
        sportDAO.update(id, sport);
    }
    
    private void forwardToUpdate(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        String filepath = "/WEB-INF/pages/sport-update.jsp";
        int id = -1;
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (Exception e) {
            response.sendError(400);
        }

        Sport sport = sportDAO.get(id);

        request.setAttribute("sport", sport);
        request.setAttribute("message", message);
        
        request.getRequestDispatcher(filepath).forward(request, response);
    }
    
    @Override
    public int delete(HttpServletRequest request) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            sportDAO.delete(id);
        } catch (Exception e) {
            return Config.BAD_REQUEST;
        }
        //response.sendRedirect(MAIN);
        return Config.SUCCESS;
    }
    
    private void showAll(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        String filepath = "/WEB-INF/pages/sports.jsp";
        
        ArrayList<Sport> sports = sportDAO.getAll();
        
        request.setAttribute("sports", sports);
        request.setAttribute("message", message);
        
        request.getRequestDispatcher(filepath).forward(request, response);
    }
    
}
