package com.netcracker.edu.inventory.model.connection.entity.wrapper.immutable;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.entity.OpticFiber;
import com.netcracker.edu.inventory.model.connection.entity.ThinCoaxial;
import com.netcracker.edu.inventory.model.connection.entity.TwistedPair;
import com.netcracker.edu.inventory.model.connection.entity.Wireless;
import com.netcracker.edu.inventory.model.connection.entity.wrapper.ConnectionWrapper;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.location.Trunk;

import java.util.Queue;
import java.util.logging.Level;

public class ConnectionImmutableWrapper<A extends Device,B extends Device,T extends Connection> extends ConnectionWrapper<A,B> {

    public ConnectionImmutableWrapper(T wrappee) {
        this.wrappee=wrappee;
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
