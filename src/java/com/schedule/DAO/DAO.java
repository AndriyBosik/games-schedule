package com.schedule.DAO;


import java.util.ArrayList;

public interface DAO<DataType> {
    
    void add(DataType x);
    
    DataType get(int id);
    
    ArrayList<DataType> getAll();
    
    void delete(int id);
    
    void update(int id, DataType updated);
    
}
