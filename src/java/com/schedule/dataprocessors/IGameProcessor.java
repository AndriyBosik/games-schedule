package com.schedule.dataprocessors;

import com.schedule.Models.Game;
import java.util.ArrayList;

public interface IGameProcessor {
    
    ArrayList<Game> getByFirstTeam(String text);
    
    ArrayList<Game> getBySecondTeam(String text);
    
    ArrayList<Game> getBySport(String text);
    
}
