package com.netcracker.edu.inventory.model.impl;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.logging.Level;

public class WifiRouter extends Router {
    protected String securityProtocol;

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
        return fields;
    }
}

