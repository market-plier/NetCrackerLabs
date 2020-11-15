package com.netcracker.edu.inventory.model.impl;

import com.netcracker.edu.inventory.model.ConnectorType;
import com.netcracker.edu.inventory.model.Device;

import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.logging.Level;


public class Wireless<A extends Device,B extends Device> extends AbstractOneToManyConnection<A,B> {

    private String technology;
    private String protocol;
    private int version;

    public Wireless(){
        setAPointConnectorType(ConnectorType.Wireless);
        setBPointConnectorType(ConnectorType.Wireless);
    }

    public Wireless(int size, String technology){
        this.technology = technology;
        bPoints = Arrays.asList((B[]) new Device[size]);
    }
    public String getTechnology(){
        return technology;
    }

    private void setTechnology(String technology){
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
            setProtocol((String) fields.remove().getValue());
            setVersion((Integer) fields.remove().getValue());
            fields.remove();
            if (getTechnology() == null)
                setTechnology((String) fields.peek().getValue());
        }
        catch (NoSuchElementException exception){
            logger.log(Level.SEVERE,exception.getMessage(),exception);
            throw exception;
        }
    }

    @Override
    public Queue<Field> getAllFields() {
        Queue<Field> fields = new LinkedList<>();
        fields.add(new Field(String.class,getProtocol()));
        fields.add(new Field(Integer.class,getVersion()));
        fields.add(new Field(String.class,getTechnology()));
        return fields;
    }
}
