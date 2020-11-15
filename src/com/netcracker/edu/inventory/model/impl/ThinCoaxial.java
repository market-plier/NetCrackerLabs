package com.netcracker.edu.inventory.model.impl;

import com.netcracker.edu.inventory.model.AllToAllConnection;
import com.netcracker.edu.inventory.model.Connection;
import com.netcracker.edu.inventory.model.ConnectorType;
import com.netcracker.edu.inventory.model.Device;
import com.netcracker.edu.location.Trunk;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThinCoaxial<T extends Device> implements AllToAllConnection<T> {

    private ConnectorType connectorType;
    private Set<T> allDevices;
    private int maxSize;
    private Trunk trunk;
    private String status;
    private int serialNumber;
    protected Logger logger = Logger.getLogger(ThinCoaxial.class.getName());

    public ThinCoaxial() {
        setConnectorType(ConnectorType.TConnector);
    }

    public ThinCoaxial(int maxSize){
        this.maxSize = maxSize;
    }
    private void setConnectorType(ConnectorType connectorType){
        this.connectorType = connectorType;
    }
    @Override
    public ConnectorType getConnectorType() {
        return connectorType;
    }

    @Override
    public boolean addDevice(T device) {
        return allDevices.add(device);
    }

    @Override
    public boolean removeDevice(T device) {
        return allDevices.remove(device);
    }

    @Override
    public boolean containDevice(T device) {
        return allDevices.contains(device);
    }

    @Override
    public Set<T> getAllDevices() {
        return allDevices;
    }

    @Override
    public int getCurSize() {
        return allDevices.size();
    }

    @Override
    public int getMaxSize() {
        return maxSize;
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
    this.serialNumber = serialNumber;
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
    public void fillAllFields(Queue<Field> fields) {
        try{
        setConnectorType((ConnectorType)fields.remove().getValue());
        setSerialNumber((Integer)fields.remove().getValue());
        setStatus((String)fields.remove().getValue());
        setTrunk((Trunk)fields.remove().getValue());
        }
        catch (NoSuchElementException exception){
            logger.log(Level.SEVERE,exception.getMessage(),exception);
            throw exception;
        }
    }

    @Override
    public Queue<Field> getAllFields() {
        Queue<Field> fields = new LinkedList<>();
        fields.add(new Field(ConnectorType.class,getConnectorType()));
        fields.add(new Field(Integer.class,getSerialNumber()));
        fields.add(new Field(String.class,getStatus()));
        fields.add(new Field(Trunk.class,getTrunk()));
        return fields;
    }

    @Override
    public int compareTo(Connection o) {
        return getSerialNumber() - o.getSerialNumber();
    }
}