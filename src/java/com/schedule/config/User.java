package com.schedule.config;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class User {
    public static String GUEST = "Guest";
    public static String ADMIN = "Admin";
    
    public static String getRole(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String role = (String)session.getAttribute("role");
        return role == null ? GUEST : role;
    }
    
    public static void exit(HttpServletRequest request) {
        if (User.getRole(request).equals(User.ADMIN)) {
            User.changeRole(request);
        }
    }
    
    public static void changeRole(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String role = User.getRole(request);
        String newRole = role.equals(User.GUEST) ? User.ADMIN : User.GUEST;
        session.setAttribute("role", newRole);
    }
    
    public static boolean isAuthorized(HttpServletRequest request) {
        return User.getRole(request).equals(User.ADMIN);
    }
    
    public static void enter(HttpServletRequest request) {
        if (User.getRole(request).equals(User.GUEST)) {
            User.changeRole(request);
        }
    }
    
}
