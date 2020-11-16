package com.netcracker.edu.inventory.model.impl;

import com.netcracker.edu.inventory.model.ConnectorType;
import com.netcracker.edu.inventory.model.Device;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.logging.Level;

public class TwistedPair<A extends Device,B extends Device> extends AbstractOneToOneConnection<A,B> {

    private Type type;
    private int length;
    public enum Type {
        need_init("<need_init>"),
        UTP("UTP"),
        FTP("FTP"),
        STP("STP"),
        SFTP("S/FTP"),
        SFTP2("SFTP");
        private final String fullName;
        Type(String fullName) {
            this.fullName = fullName;
        }
        String getFullName() {
            return fullName;
        }
    }
    public TwistedPair(){
        this(Type.need_init,0);
    }

    public TwistedPair(Type type, int length){
        setType(type);
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
