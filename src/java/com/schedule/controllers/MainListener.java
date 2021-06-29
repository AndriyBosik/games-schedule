package com.schedule.controllers;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import com.schedule.services.MainService;

public class MainListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        MainService service = new MainService();
        
        sce.getServletContext().setAttribute("service", service);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
    
}
