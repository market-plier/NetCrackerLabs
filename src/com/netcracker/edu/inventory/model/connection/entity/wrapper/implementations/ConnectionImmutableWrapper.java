package com.netcracker.edu.inventory.model.connection.entity.wrapper.implementations;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.location.Trunk;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionImmutableWrapper<A extends Device,B extends Device> extends AbstractConnectionWrapper<A,B> {

    Logger logger = Logger.getLogger(ConnectionImmutableWrapper.class.getName());

    public ConnectionImmutableWrapper(Connection<A, B> connection) {
        super(connection);
    }



    @Override
    public void setTrunk(Trunk trunk) {
        logger.log(Level.WARNING,"Can't change immutable connection");
    }



    @Override
    public void setSerialNumber(int serialNumber) {
        logger.log(Level.WARNING,"Can't change immutable connection");

    }

    @Override
    public void setStatus(String status) {
        logger.log(Level.WARNING,"Can't change immutable connection");

    }

    @Override
    public boolean addDevice(A device) {
        logger.log(Level.WARNING,"Can't change immutable connection");
        return false;
    }

    @Override
    public boolean removeDevice(A device) {
        logger.log(Level.WARNING,"Can't change immutable connection");
        return false;
    }


    @Override
    public void setBPoints(List<B> devices) {
        logger.log(Level.WARNING,"Can't change immutable connection");
    }

    @Override
    public void setBPoint(B device, int deviceNumber) {
        logger.log(Level.WARNING,"Can't change immutable connection");
    }

    @Override
    public void setLength(int length) {
        logger.log(Level.WARNING,"Can't change immutable connection");
    }

    @Override
    public void setProtocol(String protocol) {
        logger.log(Level.WARNING,"Can't change immutable connection");
    }

    @Override
    public void setVersion(int version) {
        logger.log(Level.WARNING,"Can't change immutable connection");
    }

    @Override
    public void setAPoint(A device) {
        logger.log(Level.WARNING,"Can't change immutable connection");
    }
    @Override
    public void setBPoint(B device) {
        logger.log(Level.WARNING,"Can't change immutable connection");
    }
}
