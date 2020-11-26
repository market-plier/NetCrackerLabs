package com.netcracker.edu.inventory.model.connection.entity.wrapper.immutable;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.connection.entity.TwistedPair;
import com.netcracker.edu.inventory.model.connection.entity.wrapper.TwistedPairWrapper;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.location.Trunk;

import java.util.Queue;
import java.util.logging.Level;

public class TwistedPairImmutableWrapper<A extends Device,B extends Device> extends TwistedPairWrapper<A,B> {

    public TwistedPairImmutableWrapper(TwistedPair wrap) {
        wrappee=wrap;
    }

    @Override
    public Type getType() {
        return wrappee.getType();
    }

    @Override
    public int getLength() {
        return wrappee.getLength();
    }

    @Override
    public void setLength(int length) {
        logger.log(Level.WARNING,"Can't change immutable connection");
    }

    @Override
    public Trunk getTrunk() {
        return wrappee.getTrunk();
    }

    @Override
    public void setTrunk(Trunk trunk) {
        logger.log(Level.WARNING,"Can't change immutable connection");

    }

    @Override
    public int getSerialNumber() {
        return wrappee.getSerialNumber();
    }

    @Override
    public void setSerialNumber(int serialNumber) {
        logger.log(Level.WARNING,"Can't change immutable connection");

    }

    @Override
    public String getStatus() {
        return wrappee.getStatus();
    }

    @Override
    public void setStatus(String status) {
        logger.log(Level.WARNING,"Can't change immutable connection");

    }

    @Override
    public ConnectorType getAPointConnectorType() {
        return wrappee.getAPointConnectorType();
    }

    @Override
    public ConnectorType getBPointConnectorType() {
        return wrappee.getBPointConnectorType();
    }

    @Override
    public A getAPoint() {
        return (A) wrappee.getAPoint();
    }

    @Override
    public void setAPoint(A device) {
        logger.log(Level.WARNING,"Can't change immutable connection");

    }

    @Override
    public B getBPoint() {
        return (B) wrappee.getBPoint();
    }

    @Override
    public void setBPoint(B device) {
        logger.log(Level.WARNING,"Can't change immutable connection");

    }

    @Override
    public void fillAllFields(Queue<Field> fields) {
        wrappee.fillAllFields(fields);
    }

    @Override
    public Queue<Field> getAllFields() {
        return wrappee.getAllFields();
    }

    @Override
    public int compareTo(Connection o) {
        return wrappee.compareTo(o);
    }
}
