package com.schedule.DAO;

import com.schedule.Models.Game;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;
import javafx.util.Pair;

public class GameDAO implements DAO<Game> {

    private static TreeMap<Integer, Game> games;
    
    public GameDAO() {
        if (games != null) {
            return;
        }
        games = new TreeMap<>();
        TeamDAO teamDAO = new TeamDAO();
        SportDAO sportDAO = new SportDAO();
        Game game;
        game = new Game(teamDAO.get(1), teamDAO.get(2), sportDAO.get(1), new Date(120, 0, 12), new Pair<>(0, 0));
        games.put(game.getId(), game);
        game = new Game(teamDAO.get(3), teamDAO.get(4), sportDAO.get(1), new Date(120, 1, 12), new Pair<>(1, 0));
        games.put(game.getId(), game);
        game = new Game(teamDAO.get(5), teamDAO.get(4), sportDAO.get(2), new Date(120, 2, 12), new Pair<>(2, 1));
        games.put(game.getId(), game);
        game = new Game(teamDAO.get(3), teamDAO.get(2), sportDAO.get(3), new Date(120, 3, 12), new Pair<>(1, 3));
        games.put(game.getId(), game);
        game = new Game(teamDAO.get(5), teamDAO.get(1), sportDAO.get(2), new Date(120, 4, 12), new Pair<>(2, 2));
        games.put(game.getId(), game);
    }
    
    @Override
    public void add(Game game) {
        games.put(game.getId(), game);
    }

    @Override
    public Game get(int id) {
        return games.get(id);
    }

    @Override
    public ArrayList<Game> getAll() {
        return new ArrayList<>(games.values());
    }

    @Override
    public void delete(int id) {
        games.remove(id);
    }

    @Override
    public void update(int id, Game changed) {
        games.replace(id, changed);
    }
    
}
