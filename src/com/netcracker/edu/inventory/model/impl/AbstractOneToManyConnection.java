package com.netcracker.edu.inventory.model.impl;

import com.netcracker.edu.inventory.model.Connection;
import com.netcracker.edu.inventory.model.ConnectorType;
import com.netcracker.edu.inventory.model.Device;
import com.netcracker.edu.inventory.model.OneToManyConnection;
import com.netcracker.edu.location.Trunk;

import javax.swing.text.PlainDocument;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class AbstractOneToManyConnection<A extends Device,B extends Device> implements OneToManyConnection<A,B> {

    protected Trunk trunk;
    protected int serialNumber;
    protected String status= PLANED;
    protected ConnectorType aPointConnectorType;
    protected ConnectorType bPointConnectorType;
    protected A aPoint;
    protected List<B> bPoints;
    protected Logger logger = Logger.getLogger(AbstractOneToManyConnection.class.getName());

    protected void setAPointConnectorType(ConnectorType connectorType){
        aPointConnectorType = connectorType;
    }

    protected void setBPointConnectorType(ConnectorType connectorType){
        bPointConnectorType=connectorType;
    }

    @Override
    public Trunk getTrunk() {
        return trunk;
    }

    @Override
    public void setTrunk(Trunk trunk) {
    this.trunk = trunk;
    }

    @Override
    public int getSerialNumber() {
        return serialNumber;
    }

    @Override
    public void setSerialNumber(int serialNumber) {
        if (this.serialNumber == 0 && serialNumber > 0) {
            this.serialNumber = serialNumber;
        } else if (serialNumber < 0) {
            IllegalArgumentException ex = new IllegalArgumentException("serialNumber can not be negative");
            logger.log(Level.SEVERE, ex.getMessage(), ex);
            throw ex;
        } else if (this.serialNumber != 0) {
            logger.log(Level.WARNING, "serialNumber number can not be reset");
        }
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void setStatus(String status) {
    this.status = status;
    }

    @Override
    public ConnectorType getAPointConnectorType() {
        return aPointConnectorType;
    }

    @Override
    public ConnectorType getBPointConnectorType() {
        return bPointConnectorType;
    }

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
    public int compareTo(Connection o) {
        return getSerialNumber() - o.getSerialNumber();
    }

    @Override
    public void fillAllFields(Queue<Field> fields) {
        try {
            setTrunk((Trunk)fields.remove().getValue());
            setSerialNumber((Integer)fields.remove().getValue());
            setStatus((String)fields.remove().getValue());
            setAPointConnectorType(ConnectorType.valueOf((String)fields.remove().getValue()));
            setBPointConnectorType(ConnectorType.valueOf((String)fields.remove().getValue()));
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
        Queue<Field> fields = new LinkedList<>();
        fields.add(new Field(Trunk.class,getTrunk()));
        fields.add(new Field(Integer.class,getSerialNumber()));
        fields.add(new Field(String.class,getStatus()));
        fields.add(new Field(String.class,getAPointConnectorType().toString()));
        fields.add(new Field(String.class,getBPointConnectorType().toString()));
        fields.add(new Field(Device.class,getAPoint()));
        Device[] bPointsArr = new Device[getBCapacity()];
        bPointsArr = getBPoints().toArray(bPointsArr);
        fields.add(new Field(Device[].class,bPointsArr));
        return fields;
    }

}
