package com.schedule.validators;

import com.schedule.Models.Team;

public class TeamValidator implements Validator<Team> {
    
    @Override
    public boolean isValid(Team model) {
        model.setName(model.getName().trim());
        if (model.getName().length() < 3) {
            return false;
        }
        return true;
    }
    
}
