package com.schedule.DAO;

public class AdminDAO {
    
    private static String login = "admin";
    private static String password = "admin";
    
    public static String getLogin() {
        return login;
    }
    
    public static String getPassword() {
        return password;
    }
    
    public static void setLogin(String newLogin) {
        login = newLogin;
    }
    
    public static void setPassword(String newPassword) {
        password = newPassword;
    }
    
}
