package com.netcracker.edu.inventory.model.connection.entity.wrapper;

import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.connection.entity.TwistedPair;
import com.netcracker.edu.inventory.model.connection.entity.wrapper.ConnectionImmutableWrapper;
import com.netcracker.edu.inventory.model.device.Device;

import java.util.logging.Level;

public class TwistedPairWrapper<A extends Device,B extends Device> extends ConnectionWrapper<A,B> implements TwistedPair<A,B> {

    public TwistedPairWrapper(AbstractConnectionWrapper<A, B> wrapper) {
        super(wrapper);
    }
    @Override
    public Type getType() {
        return wrapper.getType();
    }

    @Override
    public int getLength() {
        return wrapper.getLength();
    }

    @Override
    public void setLength(int length) {
        wrapper.setLength(length);
    }


    @Override
    public ConnectorType getAPointConnectorType() {
        return wrapper.getAPointConnectorType();
    }

    @Override
    public ConnectorType getBPointConnectorType() {
        return wrapper.getBPointConnectorType();
    }

    @Override
    public A getAPoint() {
        return wrapper.getAPoint();
    }

    @Override
    public void setAPoint(A device) {
        wrapper.setAPoint(device);
    }
    @Override
    public B getBPoint() {
        return  wrapper.getBPoint();
    }

    @Override
    public void setBPoint(B device) {
        wrapper.setBPoint(device);
    }
}
