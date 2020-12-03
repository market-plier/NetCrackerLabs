package com.netcracker.edu.inventory.model.connection.entity.wrapper;

import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.connection.entity.Wireless;
import com.netcracker.edu.inventory.model.connection.entity.wrapper.ConnectionImmutableWrapper;
import com.netcracker.edu.inventory.model.device.Device;

import java.util.List;
import java.util.logging.Level;

public class WirelessWrapper<A extends Device,B extends Device> extends ConnectionWrapper<A,B>
implements Wireless<A,B>
{


    public WirelessWrapper(AbstractConnectionWrapper<A, B> wrapper) {
        super(wrapper);
    }

    @Override
    public String getTechnology() {
        return wrapper.getTechnology();
    }

    @Override
    public String getProtocol() {
        return wrapper.getProtocol();
    }

    @Override
    public void setProtocol(String protocol) {
        wrapper.setProtocol(protocol);
    }

    @Override
    public int getVersion() {
        return wrapper.getVersion();
    }

    @Override
    public void setVersion(int version) {
        wrapper.setVersion(version);
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
    public List<B> getBPoints() {
        return wrapper.getBPoints();
    }

    @Override
    public void setBPoints(List<B> devices) {
        wrapper.setBPoints(devices);
    }

    @Override
    public int getBCapacity() {
        return wrapper.getBCapacity();
    }

    @Override
    public B getBPoint(int deviceNumber) {
        return wrapper.getBPoint(deviceNumber);
    }

    @Override
    public void setBPoint(B device, int deviceNumber) {
        wrapper.setBPoint(device, deviceNumber);

    }
}
