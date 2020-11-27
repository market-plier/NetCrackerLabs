package com.netcracker.edu.inventory.model.connection.entity.wrapper.publish;

import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.connection.entity.TwistedPair;
import com.netcracker.edu.inventory.model.device.Device;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TwistedPairPublishWrapper<A extends Device,B extends Device> extends ConnectionPublishWrapper<A,B, TwistedPair<A,B>> implements TwistedPair<A,B> {
    public TwistedPairPublishWrapper(TwistedPair<A, B> wrappee, PropertyChangeListener listener) {
        super(wrappee, listener);
        twistedPairWrapee = wrappee;
    }

    @Override
    public Type getType() {
        return twistedPairWrapee.getType();
    }

    @Override
    public int getLength() {
        return twistedPairWrapee.getLength();
    }

    @Override
    public void setLength(int length) {
        for (PropertyChangeListener listener: listeners) {
            listener.propertyChange(new PropertyChangeEvent(this, "length", twistedPairWrapee.getLength(), length));
        }
        twistedPairWrapee.setLength(length);
    }

    @Override
    public ConnectorType getAPointConnectorType() {
        return twistedPairWrapee.getAPointConnectorType();
    }

    @Override
    public ConnectorType getBPointConnectorType() {
        return twistedPairWrapee.getBPointConnectorType();
    }

    @Override
    public A getAPoint() {
        return twistedPairWrapee.getAPoint();
    }

    @Override
    public void setAPoint(A device) {

        for (PropertyChangeListener listener: listeners) {
            listener.propertyChange(new PropertyChangeEvent(this, "aPoint", twistedPairWrapee.getAPoint(), device));
        }
        twistedPairWrapee.setAPoint(device);
    }

    @Override
    public B getBPoint() {
        return twistedPairWrapee.getBPoint();
    }

    @Override
    public void setBPoint(B device) {

        for (PropertyChangeListener listener: listeners) {
            listener.propertyChange(new PropertyChangeEvent(this, "bPoint", twistedPairWrapee.getBPoint(), device));
        }
        twistedPairWrapee.setBPoint(device);
    }
}
