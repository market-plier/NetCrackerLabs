package com.netcracker.edu.inventory.model.device.entity.wrapper.implementations;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.device.Device;

import java.util.Date;
import java.util.List;
import java.util.Queue;

public class DeviceSynchronizedWrapper extends AbstractDeviceWrapper {
    public DeviceSynchronizedWrapper(Device device) {
        super(device);
    }

    @Override
    public synchronized int getChargeVolume() {
        return super.getChargeVolume();
    }

    @Override
    public synchronized void setChargeVolume(int chargeVolume) {
        super.setChargeVolume(chargeVolume);
    }

    @Override
    public synchronized int getNumberOfPorts() {
        return super.getNumberOfPorts();
    }

    @Override
    public synchronized void setNumberOfPorts(int numberOfPorts) {
        super.setNumberOfPorts(numberOfPorts);
    }

    @Override
    public synchronized ConnectorType getPortsType() {
        return super.getPortsType();
    }

    @Override
    public synchronized Connection getPortConnection(int portNumber) {
        return super.getPortConnection(portNumber);
    }

    @Override
    public synchronized void setPortConnection(Connection connection, int portNumber) {
        super.setPortConnection(connection, portNumber);
    }

    @Override
    public synchronized List<Connection> getAllPortConnections() {
        return super.getAllPortConnections();
    }

    @Override
    public synchronized String getTechnologyVersion() {
        return super.getTechnologyVersion();
    }

    @Override
    public synchronized String getSecurityProtocol() {
        return super.getSecurityProtocol();
    }

    @Override
    public synchronized void setSecurityProtocol(String securityProtocol) {
        super.setSecurityProtocol(securityProtocol);
    }

    @Override
    public synchronized Connection getWirelessConnection() {
        return super.getWirelessConnection();
    }

    @Override
    public synchronized void setWirelessConnection(Connection wirelessConnection) {
        super.setWirelessConnection(wirelessConnection);
    }

    @Override
    public synchronized ConnectorType getWirePortType() {
        return super.getWirePortType();
    }

    @Override
    public synchronized Connection getWireConnection() {
        return super.getWireConnection();
    }

    @Override
    public synchronized void setWireConnection(Connection wireConnection) {
        super.setWireConnection(wireConnection);
    }

    @Override
    public synchronized int getDataRate() {
        return super.getDataRate();
    }

    @Override
    public synchronized void setDataRate(int dataRate) {
        super.setDataRate(dataRate);
    }

    @Override
    public synchronized int getIn() {
        return super.getIn();
    }

    @Override
    public synchronized void setIn(int in) {
        super.setIn(in);
    }

    @Override
    public synchronized String getType() {
        return super.getType();
    }

    @Override
    public synchronized void setType(String type) {
        super.setType(type);
    }

    @Override
    public synchronized String getManufacturer() {
        return super.getManufacturer();
    }

    @Override
    public synchronized void setManufacturer(String manufacturer) {
        super.setManufacturer(manufacturer);
    }

    @Override
    public synchronized String getModel() {
        return super.getModel();
    }

    @Override
    public synchronized void setModel(String model) {
        super.setModel(model);
    }

    @Override
    public synchronized Date getProductionDate() {
        return super.getProductionDate();
    }

    @Override
    public synchronized void setProductionDate(Date productionDate) {
        super.setProductionDate(productionDate);
    }

    @Override
    public synchronized void fillAllFields(Queue<Field> fields) {
        super.fillAllFields(fields);
    }

    @Override
    public synchronized Queue<Field> getAllFields() {
        return super.getAllFields();
    }

    @Override
    public synchronized int compareTo(Device o) {
        return super.compareTo(o);
    }
}
