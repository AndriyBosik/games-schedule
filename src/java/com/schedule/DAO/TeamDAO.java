package com.schedule.DAO;

import com.schedule.Models.Team;
import java.util.ArrayList;
import java.util.TreeMap;

public class TeamDAO implements DAO<Team> {
    
    private static TreeMap<Integer, Team> teams;
    
    public TeamDAO () {
        if (teams != null) {
            return;
        }
        teams = new TreeMap<>();
        Team team;
        team = new Team("Gryffindor");
        teams.put(team.getId(), team);
        team = new Team("Hufflepuff");
        teams.put(team.getId(), team);
        team = new Team("Ravenclaw");
        teams.put(team.getId(), team);
        team = new Team("Slytherin");
        teams.put(team.getId(), team);
        team = new Team("Tigers");
        teams.put(team.getId(), team);
        // Adding some objects
    }

    @Override
    public void add(Team team) {
        teams.put(team.getId(), team);
    }

    @Override
    public Team get(int id) {
        return teams.get(id);
    }

    @Override
    public ArrayList<Team> getAll() {
        return new ArrayList<>(teams.values());
    }

    @Override
    public void delete(int id) {
        teams.remove(id);
    }

    @Override
    public void update(int id, Team changed) {
        teams.replace(id, changed);
    }
    
}
