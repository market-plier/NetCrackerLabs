package com.netcracker.edu.inventory.model.connection.entity.impl;

import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.device.Device;

import java.util.*;
import java.util.logging.Level;


public class Wireless<A extends Device,B extends Device> extends AbstractOneToManyConnection<A,B> implements com.netcracker.edu.inventory.model.connection.entity.Wireless<A,B> {

    private String technology;
    private String protocol;
    private int version=0;

    public Wireless(){
        setAPointConnectorType(ConnectorType.Wireless);
        setBPointConnectorType(ConnectorType.Wireless);
        bPoints = (List<B>)Arrays.asList(new Device[0]);
    }

    public Wireless(int size, String technology){
        this();
        this.technology = technology;
        bPoints = (List<B>)Arrays.asList(new Device[size]);
    }
    public String getTechnology(){
        return technology;
    }

    private void setTechnology(String technology){
        if (this.technology==null)
        this.technology=technology;
    }

    public String getProtocol(){
        return  protocol;
    }

    public void setProtocol(String protocol){
        this.protocol=protocol;
    }

    public int getVersion(){
        return version;
    }

    public void setVersion(int version){
        this.version=version;
    }

    @Override
    public void fillAllFields(Queue<Field> fields) {
        try {
            super.fillAllFields(fields);
            setProtocol((String) fields.remove().getValue());
            setVersion((Integer) fields.remove().getValue());
            setTechnology((String) fields.remove().getValue());
        }
        catch (NoSuchElementException exception){
            logger.log(Level.SEVERE,exception.getMessage(),exception);
            throw exception;
        }
    }

    @Override
    public Queue<Field> getAllFields() {
        Queue<Field> fields = super.getAllFields();
        fields.add(new Field(String.class,getProtocol()));
        fields.add(new Field(Integer.class,getVersion()));
        fields.add(new Field(String.class,getTechnology()));
        return fields;
    }
}
