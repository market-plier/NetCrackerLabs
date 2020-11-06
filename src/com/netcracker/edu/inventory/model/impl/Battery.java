package com.netcracker.edu.inventory.model.impl;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.logging.Level;

public class Battery extends AbstractDevice {
    protected int chargeVolume;

    public int getChargeVolume() {
        return chargeVolume;
    }

    public void setChargeVolume(int chargeVolume) {
        this.chargeVolume = chargeVolume;
    }

    @Override
    public void fillAllFields(Queue<Field> fields){
        try {
            super.fillAllFields(fields);
            setChargeVolume((int) fields.remove().getValue());
        }
        catch (NoSuchElementException exception){
            logger.log(Level.SEVERE,exception.getMessage(),exception);
            throw exception;
        }
    }

    @Override
    public Queue<Field> getAllFields() {
        Queue<Field> fields=super.getAllFields();
        fields.add(new Field(int.class,getChargeVolume()));
        return fields;
    }
}
