package com.netcracker.edu.inventory.model.connection.entity.wrapper.immutable;

import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.connection.entity.OpticFiber;
import com.netcracker.edu.inventory.model.device.Device;

import java.util.logging.Level;

public class OpticFiberImmutableWrapper<A extends Device,B extends Device> extends ConnectionImmutableWrapper<A,B,OpticFiber<A,B>> implements OpticFiber<A,B> {

    public OpticFiberImmutableWrapper(OpticFiber<A,B> opticFiberWrapee) {
        super(opticFiberWrapee);
        this.opticFiberWrapee = opticFiberWrapee;
    }

    @Override
    public Mode getMode() {
        return opticFiberWrapee.getMode();
    }

    @Override
    public int getLength() {
        return opticFiberWrapee.getLength();
    }

    @Override
    public void setLength(int length) {
        logger.log(Level.WARNING, "Can't change immutable connection");
    }


    @Override
    public ConnectorType getAPointConnectorType() {
        return opticFiberWrapee.getAPointConnectorType();
    }

    @Override
    public ConnectorType getBPointConnectorType() {
        return opticFiberWrapee.getBPointConnectorType();
    }

    @Override
    public A getAPoint() {
        return opticFiberWrapee.getAPoint();
    }

    @Override
    public void setAPoint(A device) {
        logger.log(Level.WARNING, "Can't change immutable connection");
    }

    @Override
    public B getBPoint() {
        return opticFiberWrapee.getBPoint();
    }

    @Override
    public void setBPoint(B device) {
        logger.log(Level.WARNING, "Can't change immutable connection");
    }
}
