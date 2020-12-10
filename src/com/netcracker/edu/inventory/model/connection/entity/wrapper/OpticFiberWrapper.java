package com.netcracker.edu.inventory.model.connection.entity.wrapper;

import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.connection.entity.OpticFiber;
import com.netcracker.edu.inventory.model.connection.entity.wrapper.implementations.AbstractConnectionWrapper;
import com.netcracker.edu.inventory.model.device.Device;

public class OpticFiberWrapper<A extends Device,B extends Device> extends ConnectionWrapper<A,B> implements OpticFiber<A,B> {

    public OpticFiberWrapper(AbstractConnectionWrapper<A,B> abAbstractConnectionWrapper) {
        super(abAbstractConnectionWrapper);
    }

    @Override
    public Mode getMode() {
        return wrapper.getMode();
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
        return wrapper.getBPoint();
    }

    @Override
    public void setBPoint(B device) {
        wrapper.setBPoint(device);
    }
}
