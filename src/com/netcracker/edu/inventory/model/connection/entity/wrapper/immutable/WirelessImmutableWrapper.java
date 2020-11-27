package com.netcracker.edu.inventory.model.connection.entity.wrapper.immutable;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.connection.entity.Wireless;
import com.netcracker.edu.inventory.model.connection.entity.wrapper.WirelessWrapper;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.location.Trunk;

import java.util.List;
import java.util.Queue;
import java.util.logging.Level;

public class WirelessImmutableWrapper<A extends Device,B extends Device> extends ConnectionImmutableWrapper<A,B,Wireless<A,B>>
implements Wireless<A,B>
{

    public WirelessImmutableWrapper(Wireless<A,B> wrappe) {
        super(wrappe);
        wirelessWrapee=wrappe;
    }

    @Override
    public String getTechnology() {
        return wirelessWrapee.getTechnology();
    }

    @Override
    public String getProtocol() {
        return wirelessWrapee.getProtocol();
    }

    @Override
    public void setProtocol(String protocol) {
        logger.log(Level.WARNING,"Can't change immutable connection");

    }

    @Override
    public int getVersion() {
        return wirelessWrapee.getVersion();
    }

    @Override
    public void setVersion(int version) {
        logger.log(Level.WARNING,"Can't change immutable connection");

    }

    @Override
    public ConnectorType getAPointConnectorType() {
        return wirelessWrapee.getAPointConnectorType();
    }

    @Override
    public ConnectorType getBPointConnectorType() {
        return wirelessWrapee.getBPointConnectorType();
    }

    @Override
    public A getAPoint() {
        return wirelessWrapee.getAPoint();
    }

    @Override
    public void setAPoint(A device) {
        logger.log(Level.WARNING,"Can't change immutable connection");

    }

    @Override
    public List<B> getBPoints() {
        return wirelessWrapee.getBPoints();
    }

    @Override
    public void setBPoints(List<B> devices) {
        logger.log(Level.WARNING,"Can't change immutable connection");

    }

    @Override
    public int getBCapacity() {
        return wirelessWrapee.getBCapacity();
    }

    @Override
    public B getBPoint(int deviceNumber) {
        return wirelessWrapee.getBPoint(deviceNumber);
    }

    @Override
    public void setBPoint(B device, int deviceNumber) {
        logger.log(Level.WARNING,"Can't change immutable connection");

    }
}
