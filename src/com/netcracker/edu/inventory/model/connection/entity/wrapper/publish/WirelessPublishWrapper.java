package com.netcracker.edu.inventory.model.connection.entity.wrapper.publish;

import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.connection.entity.Wireless;
import com.netcracker.edu.inventory.model.device.Device;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class WirelessPublishWrapper<A extends Device,B extends Device> extends ConnectionPublishWrapper<A,B, Wireless<A,B>> implements com.netcracker.edu.inventory.model.connection.entity.Wireless<A,B> {
    public WirelessPublishWrapper(Wireless<A, B> wrappee, PropertyChangeListener listener) {
        super(wrappee, listener);
        wirelessWrapee=wrappee;
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
        for (PropertyChangeListener listener: listeners) {
            listener.propertyChange(new PropertyChangeEvent(this, "protocol", wirelessWrapee.getProtocol(), protocol));
        }
        wirelessWrapee.setProtocol(protocol);
    }

    @Override
    public int getVersion() {
        return wirelessWrapee.getVersion();
    }

    @Override
    public void setVersion(int version) {
        for (PropertyChangeListener listener: listeners) {
            listener.propertyChange(new PropertyChangeEvent(this, "version", wirelessWrapee.getVersion(), version));
        }
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
        for (PropertyChangeListener listener: listeners) {
            listener.propertyChange(new PropertyChangeEvent(this, "aPoint", wirelessWrapee.getAPoint(), device));
        }
        wirelessWrapee.setAPoint(device);
    }

    @Override
    public List<B> getBPoints() {
        return wirelessWrapee.getBPoints();
    }

    @Override
    public void setBPoints(List<B> devices) {
        for (PropertyChangeListener listener: listeners) {
            listener.propertyChange(new PropertyChangeEvent(this, "bPoints", wirelessWrapee.getBPoints(), devices));
        }
        wirelessWrapee.setBPoints(devices);
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
        for (PropertyChangeListener listener: listeners) {
            listener.propertyChange(new PropertyChangeEvent(this, "bPoints", wirelessWrapee.getBPoint(deviceNumber), device));
        }
        wirelessWrapee.setBPoint(device,deviceNumber);
    }
}
