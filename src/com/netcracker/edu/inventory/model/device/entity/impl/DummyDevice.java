package com.netcracker.edu.inventory.model.device.entity.impl;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.device.DevicePrimaryKey;
import com.netcracker.edu.inventory.model.device.entity.AllDevices;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class DummyDevice implements AllDevices {
    private final DevicePrimaryKey primaryKey;

    public DummyDevice(DevicePrimaryKey primaryKey) {
        this.primaryKey = primaryKey;
    }

    @Override
    public int getIn() {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public void setIn(int in) {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public String getType() {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public void setType(String type) {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public String getManufacturer() {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public void setManufacturer(String manufacturer) {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public String getModel() {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public void setModel(String model) {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public Date getProductionDate() {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public void setProductionDate(Date productionDate) {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public void fillAllFields(Queue<Field> fields) {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public Queue<Field> getAllFields() {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public boolean isLazy() {
        return true;
    }

    @Override
    public DevicePrimaryKey getPrimaryKey() {
        return primaryKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DummyDevice that = (DummyDevice) o;
        return Objects.equals(primaryKey, that.primaryKey);
    }

    @Override
    public int compareTo(Device o) {
        return primaryKey.compareTo(o.getPrimaryKey());
    }

    @Override
    public int hashCode() {
        return Objects.hash(primaryKey);
    }

    @Override
    public int getChargeVolume() {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public void setChargeVolume(int chargeVolume) {
        throw new UnsupportedOperationException("Connection is Dummy");

    }

    @Override
    public int getNumberOfPorts() {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public void setNumberOfPorts(int numberOfPorts) {
        throw new UnsupportedOperationException("Connection is Dummy");

    }

    @Override
    public ConnectorType getPortsType() {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public Connection getPortConnection(int portNumber) {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public void setPortConnection(Connection connection, int portNumber) {
        throw new UnsupportedOperationException("Connection is Dummy");

    }

    @Override
    public List<Connection> getAllPortConnections() {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public String getTechnologyVersion() {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public String getSecurityProtocol() {
        throw new UnsupportedOperationException("Connection is Dummy");

    }

    @Override
    public void setSecurityProtocol(String securityProtocol) {
        throw new UnsupportedOperationException("Connection is Dummy");

    }

    @Override
    public Connection getWirelessConnection() {
        throw new UnsupportedOperationException("Connection is Dummy");

    }

    @Override
    public void setWirelessConnection(Connection wirelessConnection) {
        throw new UnsupportedOperationException("Connection is Dummy");

    }

    @Override
    public ConnectorType getWirePortType() {
        throw new UnsupportedOperationException("Connection is Dummy");

    }

    @Override
    public Connection getWireConnection() {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public void setWireConnection(Connection wireConnection) {
        throw new UnsupportedOperationException("Connection is Dummy");

    }

    @Override
    public int getDataRate() {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public void setDataRate(int dataRate) {
        throw new UnsupportedOperationException("Connection is Dummy");

    }
}
