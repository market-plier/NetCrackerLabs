package com.netcracker.edu.inventory.model.impl;

import com.netcracker.edu.inventory.model.Connection;
import com.netcracker.edu.inventory.model.ConnectorType;
import com.netcracker.edu.inventory.model.Device;
import com.netcracker.edu.inventory.model.OneToOneConnection;
import com.netcracker.edu.location.Trunk;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        private String fullName;
        Type(String fullName) {
            this.fullName = fullName;
        }
        String getFullName() {
            return fullName;
        }
    }
    public TwistedPair(){
        setLength(0);
        setType(Type.need_init);
        setAPointConnectorType(ConnectorType.RJ45);
        setBPointConnectorType(ConnectorType.RJ45);
    }

    public TwistedPair(Type type, int length){
        setType(type);
        setLength(length);
    }

    @Override
    public void fillAllFields(Queue<Field> fields) {
        try {
            setLength((Integer) fields.remove().getValue());
            fields.remove();
            if (getType() == Type.need_init)
                setType((Type) fields.peek().getValue());
        }
        catch (IndexOutOfBoundsException e){
            logger.log(Level.SEVERE,e.getMessage(),e);
            throw e;
        }
    }

    @Override
    public Queue<Field> getAllFields() {
        Queue<Field> fields = new LinkedList<>();
        fields.add(new Field(Integer.class,getLength()));
        fields.add(new Field(Type.class,getType()));
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
