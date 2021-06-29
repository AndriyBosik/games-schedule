package com.schedule.dataprocessors;

import com.schedule.DAO.GameDAO;
import com.schedule.Models.Game;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameProcessor implements IGameProcessor {

    private GameDAO dao;
    
    public GameProcessor() {
        this.dao = new GameDAO();
    }
    
    @Override
    public ArrayList<Game> getByFirstTeam(String text) {
        List<Game> result = dao.getAll()
                .stream()
                .filter(x -> x.getFirstTeam().getName().toLowerCase().contains(text.toLowerCase()))
                .sorted(Game::compareTo)
                .collect(Collectors.toList());
        return new ArrayList<>(result);
    }

    @Override
    public ArrayList<Game> getBySecondTeam(String text) {
        List<Game> result = dao.getAll()
                .stream()
                .filter(x -> x.getSecondTeam().getName().toLowerCase().contains(text.toLowerCase()))
                .sorted(Game::compareTo)
                .collect(Collectors.toList());
        return new ArrayList<>(result);
    }

    @Override
    public ArrayList<Game> getBySport(String text) {
        List<Game> result = dao.getAll()
                .stream()
                .filter(x -> x.getSport().getName().toLowerCase().contains(text.toLowerCase()))
                .sorted(Game::compareTo)
                .collect(Collectors.toList());
        return new ArrayList<>(result);
    }
    
    public ArrayList<Game> getAll() {
        List<Game> result = this.dao.getAll()
                .stream()
                .sorted(Game::compareTo)
                .collect(Collectors.toList());
        return new ArrayList<>(result);
    }
    
}
