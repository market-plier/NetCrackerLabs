package com.netcracker.edu.inventory.model.connection.entity.wrapper.immutable;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.connection.entity.impl.Wireless;
import com.netcracker.edu.inventory.model.connection.entity.wrapper.WirelessWrapper;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.location.Trunk;

import java.util.List;
import java.util.Queue;
import java.util.logging.Level;

public class WirelessImmutableWrapper<A extends Device,B extends Device> extends WirelessWrapper<A,B> {

    public WirelessImmutableWrapper(Wireless wrappee) {
        this.wrappee=wrappee;
    }

    @Override
    public String getTechnology() {
        logger.log(Level.WARNING,"Can't change immutable connection");
        return null;
    }

    @Override
    public String getProtocol() {
        return wrappee.getProtocol();
    }

    @Override
    public void setProtocol(String protocol) {
        logger.log(Level.WARNING,"Can't change immutable connection");

    }

    @Override
    public int getVersion() {
        return wrappee.getVersion();
    }

    @Override
    public void setVersion(int version) {
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
        return (A)wrappee.getAPoint();
    }

    @Override
    public void setAPoint(A device) {
        logger.log(Level.WARNING,"Can't change immutable connection");

    }

    @Override
    public List<B> getBPoints() {
        return wrappee.getBPoints();
    }

    @Override
    public void setBPoints(List<B> devices) {
        logger.log(Level.WARNING,"Can't change immutable connection");

    }

    @Override
    public int getBCapacity() {
        return wrappee.getBCapacity();
    }

    @Override
    public B getBPoint(int deviceNumber) {
        return (B)wrappee.getBPoint(deviceNumber);
    }

    @Override
    public void setBPoint(B device, int deviceNumber) {
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
