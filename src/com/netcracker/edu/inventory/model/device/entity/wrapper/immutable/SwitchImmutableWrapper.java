package com.netcracker.edu.inventory.model.device.entity.wrapper.immutable;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.device.entity.Switch;

import java.util.List;
import java.util.logging.Level;

public class SwitchImmutableWrapper extends DeviceImmutableWrapper<Switch> implements Switch {

    public SwitchImmutableWrapper(Switch wrappee) {
        super(wrappee);
        aSwitchWrappee=wrappee;
    }

    @Override
    public int getNumberOfPorts() {
        return aSwitchWrappee.getNumberOfPorts();
    }

    @Override
    public void setNumberOfPorts(int numberOfPorts) {
        logger.log(Level.WARNING, "Can't change immutable connection");

    }

    @Override
    public ConnectorType getPortsType() {
        return aSwitchWrappee.getPortsType();
    }

    @Override
    public Connection getPortConnection(int portNumber) {
        return aSwitchWrappee.getPortConnection(portNumber);
    }

    @Override
    public void setPortConnection(Connection connection, int portNumber) {
        logger.log(Level.WARNING, "Can't change immutable connection");

    }

    @Override
    public List<Connection> getAllPortConnections() {
        return aSwitchWrappee.getAllPortConnections();
    }

    @Override
    public int getDataRate() {
        return aSwitchWrappee.getDataRate();
    }

    @Override
    public void setDataRate(int dataRate) {
        logger.log(Level.WARNING,"Can't change immutable connection");

    }
}

