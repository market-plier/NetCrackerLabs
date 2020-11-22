package com.netcracker.edu.inventory.model.connection.entity.impl;

import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.connection.OneToOneConnection;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.logging.Level;

abstract class AbstractOneToOneConnection<A extends Device,B extends Device>extends AbstractConnection<A,B> implements OneToOneConnection<A,B> {

    protected A aPoint;
    protected B bPoint;

    @Override
    public A getAPoint() {
        return aPoint;
    }

    @Override
    public void setAPoint(A device) {
        this.aPoint = device;
    }

    @Override
    public B getBPoint() {
        return bPoint;
    }

    @Override
    public void setBPoint(B device) {
        this.bPoint = device;
    }

    @Override
    public void fillAllFields(Queue<Field> fields) {
        try {
            super.fillAllFields(fields);
            setAPoint((A)fields.remove().getValue());
            setBPoint((B)fields.remove().getValue());
        }
        catch (NoSuchElementException e){
            logger.log(Level.SEVERE,e.getMessage(),e);
            throw e;
        }
    }

    @Override
    public Queue<Field> getAllFields() {
        Queue<Field> fields = super.getAllFields();
        fields.add(new Field(Device.class,getAPoint()));
        fields.add(new Field(Device.class,getBPoint()));
        return fields;
    }
}
