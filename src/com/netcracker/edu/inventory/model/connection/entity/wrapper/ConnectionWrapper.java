package com.netcracker.edu.inventory.model.connection.entity.wrapper;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectionPrimaryKey;
import com.netcracker.edu.inventory.model.connection.entity.wrapper.implementations.AbstractConnectionWrapper;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.location.Trunk;

import java.util.Queue;

public class ConnectionWrapper<A extends Device,B extends Device> implements Connection<A,B> {

    protected AbstractConnectionWrapper<A,B> wrapper;

    public ConnectionWrapper(AbstractConnectionWrapper<A, B> wrapper) {
        this.wrapper = wrapper;
    }

    public AbstractConnectionWrapper<A,B> getWrapper() {
        return wrapper;
    }
    @Override
    public Trunk getTrunk() {
        return wrapper.getTrunk();
    }

    @Override
    public void setTrunk(Trunk trunk) {
        wrapper.setTrunk(trunk);
    }

    @Override
    public int getSerialNumber() {
        return wrapper.getSerialNumber();
    }

    @Override
    public void setSerialNumber(int serialNumber) {
        wrapper.setSerialNumber(serialNumber);
    }

    @Override
    public String getStatus() {
        return wrapper.getStatus();
    }

    @Override
    public void setStatus(String status) {
        wrapper.setStatus(status);
    }

    @Override
    public void fillAllFields(Queue<Field> fields) {
        wrapper.fillAllFields(fields);
    }

    @Override
    public Queue<Field> getAllFields() {
        return wrapper.getAllFields();
    }

    @Override
    public int compareTo(Connection o) {
        return wrapper.compareTo(o);
    }

    @Override
    public boolean isLazy() {
        return false;
    }

    @Override
    public ConnectionPrimaryKey getPrimaryKey() {
        return null;
    }
}
