package com.schedule.validators;

public interface Validator<TModel> {
    
    public boolean isValid(TModel model);
    
}
