package com.netcracker.edu.inventory.model.connection.entity.wrapper.publish;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.entity.wrapper.ConnectionWrapper;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.location.Trunk;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ConnectionPublishWrapper<A extends Device,B extends Device,T extends Connection<A,B>> extends ConnectionWrapper<A,B> {

    protected List<PropertyChangeListener> listeners;

    public ConnectionPublishWrapper(T wrappee, PropertyChangeListener listener) {
        listeners = new ArrayList<>();
        listeners.add(listener);
        this.wrappee = wrappee;
    }

    @Override
    public Trunk getTrunk() {
        return wrappee.getTrunk();
    }

    @Override
    public void setTrunk(Trunk trunk) {
        for (PropertyChangeListener listener: listeners) {
            listener.propertyChange(new PropertyChangeEvent(this, "trunk", wrappee.getTrunk(), trunk));
        }
        wrappee.setTrunk(trunk);
    }

    @Override
    public int getSerialNumber() {
        return wrappee.getSerialNumber();
    }

    @Override
    public void setSerialNumber(int serialNumber) {
        for (PropertyChangeListener listener: listeners) {
            listener.propertyChange(new PropertyChangeEvent(this, "serialNumber", wrappee.getSerialNumber(), serialNumber));
        }
        wrappee.setSerialNumber(serialNumber);
    }

    @Override
    public String getStatus() {
        return wrappee.getStatus();
    }

    @Override
    public void setStatus(String status) {
        for (PropertyChangeListener listener: listeners) {
            listener.propertyChange(new PropertyChangeEvent(this, "status", wrappee.getStatus(), status));
        }
        wrappee.setStatus(status);
    }

    @Override
    public void fillAllFields(Queue<Field> fields) {
        wrappee.fillAllFields(fields);
    }

    @Override
    public Queue<Field> getAllFields() {
        return wrappee.getAllFields();
    }

    @Override
    public int compareTo(Connection o) {
        return wrappee.compareTo(o);
    }


    public void subscribe(PropertyChangeListener listener) {
        listeners.add(listener);
    }

    public boolean unsubscribe(PropertyChangeListener listener) {
        return listeners.remove(listener);
    }
}
