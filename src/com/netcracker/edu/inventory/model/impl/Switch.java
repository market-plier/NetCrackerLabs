package com.netcracker.edu.inventory.model.impl;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.logging.Level;

public class Switch extends Router {
    protected int numberOfPorts;

    public void setNumberOfPorts(int numberOfPorts) {
        this.numberOfPorts = numberOfPorts;
    }

    public int getNumberOfPorts() {
        return numberOfPorts;
    }

    @Override
    public void fillAllFields(Queue<Field> fields){
        try{
            super.fillAllFields(fields);
            setNumberOfPorts((int)fields.remove().getValue());
        }
        catch (NoSuchElementException exception){
            logger.log(Level.SEVERE,exception.getMessage(),exception);
            throw exception;
        }
    }

    @Override
    public Queue<Field> getAllFields() {
        Queue<Field> fields=super.getAllFields();
        fields.add(new Field(int.class,getNumberOfPorts()));
        return fields;
    }
}
