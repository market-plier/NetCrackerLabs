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
        allPortConnections = Arrays.asList(new Connection[0]);
    }
    public Switch(ConnectorType connectorType){
        this();
        setPortsType(connectorType);
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

    public void setPortConnection(Connection connection, int portNumber){
        try {

            if (allPortConnections.get(portNumber)==null){
                allPortConnections = new ArrayList<>(allPortConnections);
                allPortConnections.set(portNumber, connection);
            }

        }
        catch (IndexOutOfBoundsException exception){
            logger.log(Level.SEVERE,exception.getMessage(),exception);
            throw exception;
        }
    }

    public void setNumberOfPorts(int numberOfPorts) {
        this.numberOfPorts = numberOfPorts;
        allPortConnections = Arrays.asList(new Connection[numberOfPorts]);
    }

    public int getNumberOfPorts() {
        return numberOfPorts;
    }

    @Override
    public void fillAllFields(Queue<Field> fields){
        try{
            super.fillAllFields(fields);
            setNumberOfPorts((Integer)fields.remove().getValue());
            setPortsType(ConnectorType.valueOf((String)fields.remove().getValue()));
            setAllPortConnections(Arrays.asList((Connection[])fields.remove().getValue()));
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
        fields.add(new Field(String.class,getPortsType().toString()));
        Connection[] connections = new Connection[getNumberOfPorts()];
        connections=getAllPortConnections().toArray(connections);
        fields.add(new Field(Connection[].class,connections));
        return fields;
    }
}
