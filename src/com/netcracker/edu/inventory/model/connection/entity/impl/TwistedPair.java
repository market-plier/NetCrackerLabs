package com.netcracker.edu.inventory.model.connection.entity.impl;

import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.device.Device;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.logging.Level;

public class TwistedPair<A extends Device,B extends Device> extends AbstractOneToOneConnection<A,B> implements com.netcracker.edu.inventory.model.connection.entity.TwistedPair<A,B> {

    private Type type;
    private int length;

    public TwistedPair(){
        this(Type.need_init,0);
    }

    public TwistedPair(Type type, int length){
        this.type=type;
        setLength(length);
        setAPointConnectorType(ConnectorType.RJ45);
        setBPointConnectorType(ConnectorType.RJ45);
    }

    @Override
    public void fillAllFields(Queue<Field> fields) {
        try {
            super.fillAllFields(fields);
            setLength((Integer) fields.remove().getValue());
            setType(Type.valueOf((String) fields.remove().getValue()));
        }
        catch (NoSuchElementException e){
            logger.log(Level.SEVERE,e.getMessage(),e);
            throw e;
        }
    }

    @Override
    public Queue<Field> getAllFields() {
        Queue<Field> fields = super.getAllFields();
        fields.add(new Field(Integer.class,getLength()));
        fields.add(new Field(String.class,getType().toString()));
        return fields;
    }

    protected void setType(Type type){
        if (this.getType()==Type.need_init)
        this.type = type;
    }

    public Type getType(){
        return type;
    }
    public int getLength(){
        return length;
    }

    public void setLength(int length){
        this.length = length;
    }

}
