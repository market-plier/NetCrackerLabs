package com.netcracker.edu.inventory.model.connection.entity.impl;

import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.connection.OneToManyConnection;

import java.util.*;
import java.util.logging.Level;

abstract class AbstractOneToManyConnection<A extends Device,B extends Device> extends AbstractConnection<A,B> implements OneToManyConnection<A,B> {

    protected A aPoint;
    protected List<B> bPoints;

    @Override
    public A getAPoint() {
        return aPoint;
    }

    @Override
    public void setAPoint(A device) {
    aPoint = device;
    }

    @Override
    public List<B> getBPoints() {
        return bPoints;
    }

    @Override
    public void setBPoints(List<B> devices) {
    bPoints = devices;
    }

    @Override
    public int getBCapacity() {
        return bPoints.size();
    }

    @Override
    public B getBPoint(int deviceNumber) {
        return bPoints.get(deviceNumber);
    }

    @Override
    public void setBPoint(B device, int deviceNumber) {
        bPoints = new ArrayList<>(bPoints);
        bPoints.set(deviceNumber, device);
    }

    @Override
    public void fillAllFields(Queue<Field> fields) {
        try {
            super.fillAllFields(fields);
            setAPoint((A)fields.remove().getValue());
            setBPoints(Arrays.asList((B[])fields.remove().getValue()));
        }
        catch (NoSuchElementException exception){
            logger.log(Level.SEVERE,exception.getMessage(),exception);
            throw exception;
        }
    }

    @Override
    public Queue<Field> getAllFields() {
        Queue<Field> fields = super.getAllFields();
        fields.add(new Field(Device.class,getAPoint()));
        Device[] bPointsArr = new Device[getBCapacity()];
        bPointsArr = getBPoints().toArray(bPointsArr);
        fields.add(new Field(Device[].class,bPointsArr));
        return fields;
    }

}
