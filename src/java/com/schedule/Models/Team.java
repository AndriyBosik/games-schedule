package com.schedule.Models;

public class Team {
    
    private static int counter = 0;
    
    private int id;
    private String name;
    
    public Team(String name) {
        counter++;
        this.id = counter;
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
}
