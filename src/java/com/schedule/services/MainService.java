package com.schedule.services;

public class MainService {
    
    private TeamService teamService;
    private GameService gameService;
    private SportService sportService;
    
    public MainService() {
        teamService = new TeamService();
        gameService = new GameService();
        sportService = new SportService();
    }
    
    public TeamService getTeamService() {
        return this.teamService;
    }
    
    public GameService getGameService() {
        return this.gameService;
    }
    
    public SportService getSportService() {
        return this.sportService;
    }
    
}
