package com.netcracker.edu.inventory.model.impl;

import com.netcracker.edu.inventory.model.Connection;
import com.netcracker.edu.inventory.model.ConnectorType;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.logging.Level;

public class WifiRouter extends Router {

    protected String securityProtocol;
    protected String technologyVersion;
    protected Connection wirelessConnection;
    protected ConnectorType wirePortType;
    protected Connection wireConnection;

    public WifiRouter(){
        setWirePortType(ConnectorType.need_init);
    }

    public Connection getWireConnection() {
        return wireConnection;
    }

    public void setWireConnection(Connection wireConnection) {
        this.wireConnection = wireConnection;
    }

    public ConnectorType getWirePortType() {
        return wirePortType;
    }

    private void setWirePortType(ConnectorType connectorType){
        wirePortType=connectorType;
    }

    public Connection getWirelessConnection() {
        return wirelessConnection;
    }

    public void setWirelessConnection(Connection wirelessConnection) {
        this.wirelessConnection = wirelessConnection;
    }

    protected void setTechnologyVersion(String technologyVersion){
        this.technologyVersion = technologyVersion;
    }

    public String getTechnologyVersion(){
        return technologyVersion;
    }

    public void setSecurityProtocol(String securityProtocol) {
        this.securityProtocol = securityProtocol;
    }

    public String getSecurityProtocol() {
        return securityProtocol;
    }

    @Override
    public void fillAllFields(Queue<Field> fields){
        try{
            super.fillAllFields(fields);
            setSecurityProtocol((String)fields.remove().getValue());
            fields.remove();
            if (getTechnologyVersion()==null)
            setTechnologyVersion((String)fields.peek().getValue());
            fields.remove();
            if (getWirePortType()==ConnectorType.need_init)
            setWirePortType((ConnectorType)fields.peek().getValue());
            setWirelessConnection((Connection)fields.remove().getValue());
            setWireConnection((Connection)fields.remove().getValue());
        }
        catch (NoSuchElementException exception){
            logger.log(Level.SEVERE,exception.getMessage(),exception);
            throw exception;
        }
    }

    @Override
    public Queue<Field> getAllFields() {
        Queue<Field> fields=super.getAllFields();
        fields.add(new Field(String.class,getSecurityProtocol()));
        fields.add(new Field(String.class,getTechnologyVersion()));
        fields.add(new Field(ConnectorType.class,getWirePortType()));
        fields.add(new Field(Connection.class,getWirelessConnection()));
        fields.add(new Field(Connection.class,getWireConnection()));
        return fields;
    }
}

