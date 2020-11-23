package com.netcracker.edu.inventory.model.device.entity.impl;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.logging.Level;

public class Battery extends AbstractDevice implements com.netcracker.edu.inventory.model.device.entity.Battery {
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
            setChargeVolume((Integer) fields.remove().getValue());
        }
        catch (NoSuchElementException exception){
            logger.log(Level.SEVERE,exception.getMessage(),exception);
            throw exception;
        }
    }

    @Override
    public Queue<Field> getAllFields() {
        Queue<Field> fields=super.getAllFields();
        fields.add(new Field(Integer.class,getChargeVolume()));
        return fields;
    }
}
