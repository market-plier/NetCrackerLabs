package com.netcracker.edu.inventory.model.device.entity.wrapper.publish;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.device.entity.Battery;
import com.netcracker.edu.inventory.model.device.entity.Switch;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class SwitchPublishWrapper extends DevicePublishWrapper<Switch> implements Switch {

    public SwitchPublishWrapper(Switch wrappee, PropertyChangeListener listener) {
        super(wrappee,listener);
        aSwitchWrappee=wrappee;
    }

    @Override
    public int getNumberOfPorts() {
        return aSwitchWrappee.getNumberOfPorts();
    }

    @Override
    public void setNumberOfPorts(int numberOfPorts) {
        for (PropertyChangeListener listener: listeners) {
            listener.propertyChange(new PropertyChangeEvent(this, "numberOfPorts", aSwitchWrappee.getNumberOfPorts(), numberOfPorts));
        }
        aSwitchWrappee.setNumberOfPorts(numberOfPorts);
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
        for (PropertyChangeListener listener: listeners) {
            listener.propertyChange(new PropertyChangeEvent(this,
                    "portConnection", aSwitchWrappee.getPortConnection(portNumber), connection));
        }
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
        for (PropertyChangeListener listener: listeners) {
            listener.propertyChange(new PropertyChangeEvent(this, "dataRate", aSwitchWrappee.getDataRate(), dataRate));
        }
        aSwitchWrappee.setDataRate(dataRate);
    }
}
