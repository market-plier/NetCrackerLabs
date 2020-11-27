package com.netcracker.edu.inventory.model.connection.entity.wrapper.publish;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.connection.entity.OpticFiber;
import com.netcracker.edu.inventory.model.device.Device;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class OpticFiberPublishWrapper<A extends Device,B extends Device> extends ConnectionPublishWrapper<A,B,OpticFiber<A,B>> implements OpticFiber<A,B> {

    public OpticFiberPublishWrapper(OpticFiber<A,B> wrappee, PropertyChangeListener listener) {
        super(wrappee, listener);
        opticFiberWrapee=wrappee;
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
        for (PropertyChangeListener listener: listeners) {
            listener.propertyChange(new PropertyChangeEvent(this, "length", opticFiberWrapee.getLength(), length));
        }
        opticFiberWrapee.setLength(length);
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
        for (PropertyChangeListener listener: listeners) {
            listener.propertyChange(new PropertyChangeEvent(this, "aPoint", opticFiberWrapee.getAPoint(), device));
        }
        opticFiberWrapee.setAPoint(device);
    }

    @Override
    public B getBPoint() {
        return opticFiberWrapee.getBPoint();
    }

    @Override
    public void setBPoint(B device) {
        for (PropertyChangeListener listener: listeners) {
            listener.propertyChange(new PropertyChangeEvent(this, "bPoint", opticFiberWrapee.getBPoint(), device));
        }
        opticFiberWrapee.setBPoint(device);
    }
}
