package com.netcracker.edu.inventory.model.impl;

import com.netcracker.edu.inventory.model.Connection;
import com.netcracker.edu.inventory.model.ConnectorType;

import java.util.*;
import java.util.logging.Level;

public class Switch extends Router {
    protected int numberOfPorts;
    protected ConnectorType portsType;
    protected List<Connection> allPortConnections;

    public Switch(){
        setPortsType(ConnectorType.need_init);
    }
    private void setPortsType(ConnectorType portsType){
        this.portsType = portsType;
    }

    public ConnectorType getPortsType(){
        return portsType;
    }

    private void setAllPortConnections(List<Connection> connections){
        allPortConnections=connections;
    }

    public List<Connection> getAllPortConnections(){
        return allPortConnections;
    }

    public Connection getPortConnection(int portNumber){
        try {
            return allPortConnections.get(portNumber);
        }
        catch (IndexOutOfBoundsException e){
            logger.log(Level.SEVERE,e.getMessage(),e);
            throw e;
        }
    }

    public void setPortConnection(int portNumber, Connection connection){
        try {
            allPortConnections.add(portNumber, connection);
        }
        catch (IndexOutOfBoundsException exception){
            logger.log(Level.SEVERE,exception.getMessage(),exception);
            throw exception;
        }
    }

    public void setNumberOfPorts(int numberOfPorts) {
        this.numberOfPorts = numberOfPorts;
        allPortConnections = new ArrayList<>(numberOfPorts);
    }

    public int getNumberOfPorts() {
        return numberOfPorts;
    }

    @Override
    public void fillAllFields(Queue<Field> fields){
        try{
            super.fillAllFields(fields);
            setNumberOfPorts((Integer)fields.remove().getValue());
            fields.remove();
            if(getPortsType()==ConnectorType.need_init)
            setPortsType((ConnectorType)fields.peek().getValue());
            setAllPortConnections((List<Connection>)fields.remove().getValue());
        }
        catch (NoSuchElementException exception){
            logger.log(Level.SEVERE,exception.getMessage(),exception);
            throw exception;
        }
    }

    @Override
    public Queue<Field> getAllFields() {
        Queue<Field> fields=super.getAllFields();
        fields.add(new Field(Integer.class,getNumberOfPorts()));
        fields.add(new Field(ConnectorType.class,getPortsType()));
        fields.add(new Field(Connection[].class,getAllPortConnections()));
        return fields;
    }
}
