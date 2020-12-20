package com.netcracker.edu.inventory.model.connection.entity.impl;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.location.Trunk;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThinCoaxial<T extends Device> extends AbstractConnection<T,T> implements com.netcracker.edu.inventory.model.connection.entity.ThinCoaxial<T> {

    private ConnectorType connectorType;
    private Set<T> allDevices;
    private int maxSize;
    protected Logger logger = Logger.getLogger(ThinCoaxial.class.getName());

    public ThinCoaxial() {
        setConnectorType(ConnectorType.TConnector);
        allDevices=new ConcurrentSkipListSet<>();
    }

    public ThinCoaxial(int maxSize){
        this();
        this.maxSize = maxSize;
        allDevices=new ConcurrentSkipListSet<>();
    }
    private void setConnectorType(ConnectorType connectorType){
        this.connectorType = connectorType;
    }
    @Override
    public ConnectorType getConnectorType() {
        return connectorType;
    }

    @Override
    public  boolean addDevice(T device) {
        return allDevices.add(device);
    }

    @Override
    public  boolean removeDevice(T device) {
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

    private void setAllDevices(Set<T> allDevices) {
        this.allDevices = allDevices;
    }

    @Override
    public int getCurSize() {
        return allDevices.size();
    }

    @Override
    public int getMaxSize() {
        return maxSize;
    }

    private void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public void fillAllFields(Queue<Field> fields) {
        try{
        setConnectorType(ConnectorType.valueOf((String)fields.remove().getValue()));
        setSerialNumber((Integer)fields.remove().getValue());
        setStatus((String)fields.remove().getValue());
        setTrunk((Trunk)fields.remove().getValue());
        setAllDevices(new HashSet<>(Arrays.asList((T[])fields.remove().getValue())));
        setMaxSize((Integer)fields.remove().getValue());
        }
        catch (NoSuchElementException exception){
            logger.log(Level.SEVERE,exception.getMessage(),exception);
            throw exception;
        }
    }

    @Override
    public Queue<Field> getAllFields() {
        Queue<Field> fields = new LinkedList<>();
        fields.add(new Field(String.class,getConnectorType().toString()));
        fields.add(new Field(Integer.class,getSerialNumber()));
        fields.add(new Field(String.class,getStatus()));
        fields.add(new Field(Trunk.class,getTrunk()));
        Device[] devices = new Device[getCurSize()];
        devices = getAllDevices().toArray(devices);
        fields.add(new Field(Device[].class,devices));
        fields.add(new Field(Integer.class,getMaxSize()));
        return fields;
    }

    @Override
    public int compareTo(Connection o) {
        return getSerialNumber() - o.getSerialNumber();
    }
}
