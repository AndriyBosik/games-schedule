package com.schedule.controllers;

import com.schedule.config.Config;
import com.schedule.config.User;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.schedule.services.MainService;

public class AdminController extends HttpServlet {
    
    private MainService service;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        service = (MainService)config.getServletContext().getAttribute("service");
    }
    
    private boolean checkAuthority(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (!User.isAuthorized(request)) {
            response.sendError(401);
            return false;
        }
        return true;
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!checkAuthority(request, response)) {
            return;
        }
        
        String path = request.getPathInfo();
        path = path == null ? "/" : path;
        
        int errorCode;
        
        switch (path) {
            case "/":
                service.getGameService().read(request, response);
                break;
            case "/game-update":
                service.getGameService().update(request, response);
                break;
            case "/game-delete":
                errorCode = service.getGameService().delete(request);
                makeResponse(errorCode, "", response);
                break;
            case "/teams":
                service.getTeamService().read(request, response);
                break;
            case "/team-update":
                service.getTeamService().update(request, response);
                break;
            case "/team-delete":
                errorCode = service.getTeamService().delete(request);
                makeResponse(errorCode, "teams", response);
                break;
            case "/sports":
                service.getSportService().read(request, response);
                break;
            case "/sport-update":
                service.getSportService().update(request, response);
                break;
            case "/sport-delete":
                errorCode = service.getSportService().delete(request);
                makeResponse(errorCode, "sports", response);
                break;
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!checkAuthority(request, response)) {
            return;
        }
        
        String path = request.getPathInfo();
        path = path == null ? "/" : path;
        
        switch (path) {
            case "/":
                service.getGameService().create(request, response);
                break;
            case "/game-update":
                service.getGameService().update(request, response);
                break;
            case "/teams":
                service.getTeamService().create(request, response);
                break;
            case "/team-update":
                service.getTeamService().update(request, response);
                break;
            case "/sports":
                service.getSportService().create(request, response);
                break;
            case "/sport-update":
                service.getSportService().update(request, response);
                break;
            case "/exit":
                exit(request, response);
        }
    }
    
    private void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!User.isAuthorized(request)) {
            response.sendError(401);
        }
        User.exit(request);
        response.sendRedirect(Config.HOME);
    }
    
    private void makeResponse(int errorCode, String address, HttpServletResponse response) throws IOException {
        if (errorCode == Config.BAD_REQUEST) {
            response.sendError(errorCode);
        } else {
            response.sendRedirect(address);
        }
    }
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
