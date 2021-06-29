package com.schedule.Models;

import java.util.Date;
import javafx.util.Pair;

public class Game {
    
    private static int counter = 0;
    
    private int id;
    private Sport sport;
    private Pair<Integer, Integer> score;
    private Date date;
    private Team firstTeam;
    private Team secondTeam;
    
    public Game(Team firstTeam, Team secondTeam, Sport sport, Date date, Pair<Integer, Integer> score) {
        counter++;
        this.id = counter;
        this.sport = sport;
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
        this.date = date;
        this.score = score;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public Pair<Integer, Integer> getScore() {
        return score;
    }
    
    public void setScore(Pair<Integer, Integer> score) {
        this.score = score;
    }
    
    public Team getFirstTeam() {
        return this.firstTeam;
    }
    
    public void setFirstTeam(Team team) {
        this.firstTeam = team;
    }
    
    public Team getSecondTeam() {
        return this.secondTeam;
    }
    
    public void setSecondTeam(Team team) {
        this.secondTeam = team;
    }
    
    public Sport getSport() {
        return this.sport;
    }
    
    public void setSport(Sport sport) {
        this.sport = sport;
    }
    
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public int compareTo(Object other) {
        if (!(other instanceof Game)) {
            return -1;
        }
        Game game = (Game)other;
        return game.date.compareTo(date);
    }
    
}
