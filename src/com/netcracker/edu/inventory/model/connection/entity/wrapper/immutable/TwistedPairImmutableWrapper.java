package com.netcracker.edu.inventory.model.connection.entity.wrapper.immutable;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.connection.entity.TwistedPair;
import com.netcracker.edu.inventory.model.connection.entity.wrapper.TwistedPairWrapper;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.location.Trunk;

import java.util.Queue;
import java.util.logging.Level;

public class TwistedPairImmutableWrapper<A extends Device,B extends Device> extends ConnectionImmutableWrapper<A,B,TwistedPair> implements TwistedPair<A,B> {

    public TwistedPairImmutableWrapper(TwistedPair wrap) {
        super(wrap);
        twistedPairWrapee=wrap;
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
        logger.log(Level.WARNING,"Can't change immutable connection");
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
        return (A) twistedPairWrapee.getAPoint();
    }

    @Override
    public void setAPoint(A device) {
        logger.log(Level.WARNING,"Can't change immutable connection");

    }
    @Override
    public B getBPoint() {
        return (B) twistedPairWrapee.getBPoint();
    }

    @Override
    public void setBPoint(B device) {
        logger.log(Level.WARNING,"Can't change immutable connection");

    }
}
