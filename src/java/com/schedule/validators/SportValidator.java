package com.schedule.validators;

import com.schedule.Models.Sport;

public class SportValidator implements Validator<Sport> {

    @Override
    public boolean isValid(Sport model) {
        model.setName(model.getName().trim());
        if (model.getName().length() < 3) {
            return false;
        }
        return true;
    }
    
}
