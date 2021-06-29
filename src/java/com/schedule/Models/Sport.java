package com.schedule.Models;

public class Sport {
    
    private String name;
    private static int counter = 0;
    private int id;
    
    public Sport(String name) {
        this.name = name;
        counter++;
        this.id = counter;
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
