package com.schedule.services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Service {
    
    void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    
    void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    
    void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    
    int delete(HttpServletRequest request) throws ServletException, IOException;
    
}
