package com.netcracker.edu.inventory.model.connection.entity.wrapper.immutable;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.connection.entity.ThinCoaxial;
import com.netcracker.edu.inventory.model.connection.entity.wrapper.ThinCoaxialWrapper;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.location.Trunk;

import java.util.Queue;
import java.util.Set;
import java.util.logging.Level;

public class ThinCoaxialImmutableWrapper<T extends Device> extends ThinCoaxialWrapper<T> {

    public ThinCoaxialImmutableWrapper(ThinCoaxial wrappee) {
        this.wrappee=wrappee;
    }

    @Override
    public ConnectorType getConnectorType() {
        return wrappee.getConnectorType();
    }

    @Override
    public boolean addDevice(T device) {
        logger.log(Level.WARNING,"Can't change immutable connection");
        return false;
    }

    @Override
    public boolean removeDevice(T device) {
        logger.log(Level.WARNING,"Can't change immutable connection");
        return false;
    }

    @Override
    public boolean containDevice(T device) {
        return wrappee.containDevice(device);
    }

    @Override
    public Set<T> getAllDevices() {
        return wrappee.getAllDevices();
    }

    @Override
    public int getCurSize() {
        return wrappee.getCurSize();
    }

    @Override
    public int getMaxSize() {
        return wrappee.getMaxSize();
    }

    @Override
    public Trunk getTrunk() {
        return wrappee.getTrunk();
    }

    @Override
    public void setTrunk(Trunk trunk) {
        logger.log(Level.WARNING,"Can't change immutable connection");
    }

    @Override
    public int getSerialNumber() {
        return wrappee.getSerialNumber();
    }

    @Override
    public void setSerialNumber(int serialNumber) {
        logger.log(Level.WARNING,"Can't change immutable connection");

    }

    @Override
    public String getStatus() {
        return wrappee.getStatus();
    }

    @Override
    public void setStatus(String status) {
        logger.log(Level.WARNING,"Can't change immutable connection");

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
}
