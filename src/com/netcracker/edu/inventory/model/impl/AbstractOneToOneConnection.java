package com.netcracker.edu.inventory.model.impl;

import com.netcracker.edu.inventory.model.Connection;
import com.netcracker.edu.inventory.model.ConnectorType;
import com.netcracker.edu.inventory.model.Device;
import com.netcracker.edu.inventory.model.OneToOneConnection;
import com.netcracker.edu.location.Trunk;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class AbstractOneToOneConnection<A extends Device,B extends Device> implements OneToOneConnection<A,B> {

    protected String status=PLANED;
    protected Trunk trunk;
    protected int serialNumber;
    protected ConnectorType aPointConnectorType;
    protected ConnectorType bPointConnectorType;
    protected Logger logger = Logger.getLogger(AbstractOneToOneConnection.class.getName());
    protected A aPoint;
    protected B bPoint;

    @Override
    public Trunk getTrunk() {
        return trunk;
    }

    @Override
    public void setTrunk(Trunk trunk) {
        this.trunk =trunk;
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

    protected void setAPointConnectorType(ConnectorType connectorType){
        aPointConnectorType = connectorType;
    }
    protected void setBPointConnectorType(ConnectorType connectorType){
        bPointConnectorType=connectorType;
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
    public int compareTo(Connection o) {
        return getSerialNumber() - o.getSerialNumber();
    }

    @Override
    public void fillAllFields(Queue<Field> fields) {
        try {
           setStatus((String)fields.remove().getValue());
           setTrunk((Trunk)fields.remove().getValue() );
           setSerialNumber((Integer)fields.remove().getValue());
           setAPointConnectorType(ConnectorType.valueOf((String)fields.remove().getValue()));
           setBPointConnectorType(ConnectorType.valueOf((String)fields.remove().getValue()));
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
        Queue<Field> fields = new LinkedList<>();
        fields.add(new Field(String.class,getStatus()));
        fields.add(new Field(Trunk.class,getTrunk()));
        fields.add(new Field(Integer.class,getSerialNumber()));
        fields.add(new Field(String.class,getAPointConnectorType().toString()));
        fields.add(new Field(String.class,getBPointConnectorType().toString()));
        fields.add(new Field(Device.class,getAPoint()));
        fields.add(new Field(Device.class,getBPoint()));
        return fields;
    }
}
