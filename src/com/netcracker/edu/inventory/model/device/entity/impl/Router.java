package com.netcracker.edu.inventory.model.device.entity.impl;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.logging.Level;

public class Router extends AbstractDevice implements com.netcracker.edu.inventory.model.device.entity.Router {
    protected int dataRate;

    public void setDataRate(int dataRate) {
        this.dataRate = dataRate;
    }

    public int getDataRate() {
        return dataRate;
    }

    @Override
    public void fillAllFields(Queue<Field> fields){
    try {
        super.fillAllFields(fields);
        setDataRate((Integer)fields.remove().getValue());
    }
    catch (NoSuchElementException exception){
        logger.log(Level.SEVERE,exception.getMessage(),exception);
        throw exception;
        }
    }

    @Override
    public Queue<Field> getAllFields() {
        Queue<Field> fields=super.getAllFields();
        fields.add(new Field(Integer.class,getDataRate()));
        return fields;
    }
}
