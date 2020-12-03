package com.netcracker.edu.inventory.model.connection.entity.wrapper;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.entity.AllConnections;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.location.Trunk;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPublishWrapper<A extends Device,B extends Device> extends AbstractConnectionWrapper<A,B> implements AllConnections<A,B> {

    protected List<PropertyChangeListener> listeners;

    public ConnectionPublishWrapper(Connection<A, B> connection) {
        super(connection);
        listeners = new ArrayList<>();
    }

    public void addListeners(PropertyChangeListener listener) {
        this.listeners.add(listener);
    }

    public boolean removeListeners(PropertyChangeListener listener) {
        return this.listeners.remove(listener);
    }

    private void notifyListeners(Object source,String propertyName,Object oldValue,Object newValue ){
        for (PropertyChangeListener listener: listeners) {
            listener.propertyChange(new PropertyChangeEvent(source, propertyName, oldValue, newValue));
        }
    }

    @Override
    public boolean addDevice(A device) {
        notifyListeners(this,"devices",null,device);
        return super.addDevice(device);
    }

    @Override
    public boolean removeDevice(A device) {
        notifyListeners(this,"devices",device,null);
        return super.removeDevice(device);
    }


    @Override
    public void setTrunk(Trunk trunk) {
        notifyListeners(this,"devices",super.getTrunk(),trunk);
        super.setTrunk(trunk);
    }

    @Override
    public void setSerialNumber(int serialNumber) {
        notifyListeners(this,"serialNumber",super.getSerialNumber(),serialNumber);
        super.setSerialNumber(serialNumber);
    }

    @Override
    public void setStatus(String status) {
        notifyListeners(this,"status",super.getStatus(),status);
        super.setStatus(status);
    }

    @Override
    public void setBPoints(List<B> devices) {
        notifyListeners(this,"bPoints",super.getBPoints(),devices);
        super.setBPoints(devices);
    }


    @Override
    public void setBPoint(B device, int deviceNumber) {
        notifyListeners(this,"bPoints",super.getBPoint(deviceNumber),device);
        super.setBPoint(device, deviceNumber);
    }

    @Override
    public void setLength(int length) {
        notifyListeners(this,"length",super.getLength(),length);
        super.setLength(length);
    }

    @Override
    public void setProtocol(String protocol) {
        notifyListeners(this,"protocol",super.getProtocol(),protocol);
        super.setProtocol(protocol);
    }


    @Override
    public void setVersion(int version) {
        notifyListeners(this,"version",super.getVersion(),version);
        super.setVersion(version);
    }

    @Override
    public void setAPoint(A device) {
        notifyListeners(this,"aPoint",super.getAPoint(),device);
        super.setAPoint(device);
    }

    @Override
    public void setBPoint(B device) {
        notifyListeners(this,"bPoint",super.getBPoint(),device);
        super.setBPoint(device);
    }
}
