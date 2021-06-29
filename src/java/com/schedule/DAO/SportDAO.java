package com.schedule.DAO;

import com.schedule.Models.Sport;
import java.util.ArrayList;
import java.util.TreeMap;

public class SportDAO implements DAO<Sport> {

    private static TreeMap<Integer, Sport> sports;
    
    public SportDAO() {
        if (sports != null) {
            return;
        }
        sports = new TreeMap<>();
        Sport sport;
        sport = new Sport("Football");
        sports.put(sport.getId(), sport);
        sport = new Sport("Volleyball");
        sports.put(sport.getId(), sport);
        sport = new Sport("Tennis");
        sports.put(sport.getId(), sport);
        sport = new Sport("Quidditch");
        sports.put(sport.getId(), sport);
    }
    
    @Override
    public void add(Sport sport) {
        sports.put(sport.getId(), sport);
    }

    @Override
    public Sport get(int id) {
        return sports.get(id);
    }

    @Override
    public ArrayList<Sport> getAll() {
        return new ArrayList<>(sports.values());
    }

    @Override
    public void delete(int id) {
        sports.remove(id);
    }

    @Override
    public void update(int id, Sport changed) {
        sports.replace(id, changed);
    }
        
}
