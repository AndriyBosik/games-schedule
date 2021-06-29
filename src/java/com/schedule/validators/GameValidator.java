package com.schedule.validators;

import com.schedule.Models.Game;
import java.util.Date;
import javafx.util.Pair;

public class GameValidator implements Validator<Game> {

    @Override
    public boolean isValid(Game model) {
        Date now = new Date();
        Date date = model.getDate();
        Pair<Integer, Integer> score = model.getScore();
        return !(now.compareTo(date) < 0 && notZero(score)) && (model.getFirstTeam() != model.getSecondTeam());
    }
    
    private boolean notZero(Pair<Integer, Integer> score) {
        return (score.getKey() != 0 || score.getValue() != 0);
    }
    
}
