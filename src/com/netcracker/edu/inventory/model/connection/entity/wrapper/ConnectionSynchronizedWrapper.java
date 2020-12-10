package com.netcracker.edu.inventory.model.connection.entity.wrapper;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.connection.entity.AllConnections;
import com.netcracker.edu.inventory.model.connection.entity.ThinCoaxial;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.location.Trunk;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class ConnectionSynchronizedWrapper <A extends Device,B extends Device> extends AbstractConnectionWrapper<A,B>{
    public ConnectionSynchronizedWrapper(Connection<A, B> connection) {
        super(connection);
    }

    @Override
    public synchronized ConnectorType getConnectorType() {
        return super.getConnectorType();
    }

    @Override
    public synchronized boolean addDevice(A device) {
        return super.addDevice(device);
    }

    @Override
    public synchronized boolean removeDevice(A device) {
        return super.removeDevice(device);
    }

    @Override
    public synchronized boolean containDevice(A device) {
        return super.containDevice(device);
    }

    @Override
    public synchronized Set<A> getAllDevices() {
        return super.getAllDevices();
    }

    @Override
    public synchronized int getCurSize() {
        return  super.getCurSize();
    }

    @Override
    public synchronized int getMaxSize() {
        return  super.getMaxSize();
    }

    @Override
    public synchronized Trunk getTrunk() {
        return super.getTrunk();
    }

    @Override
    public synchronized void setTrunk(Trunk trunk) {
        super.setTrunk(trunk);
    }

    @Override
    public synchronized int getSerialNumber() {
        return  super.getSerialNumber();
    }

    @Override
    public synchronized void setSerialNumber(int serialNumber) {
        super.setSerialNumber(serialNumber);
    }

    @Override
    public synchronized String getStatus() {
        return super.getStatus();
    }

    @Override
    public synchronized void setStatus(String status) {
        super.setStatus(status);
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
    public synchronized int compareTo(Connection o) {
        return  super.compareTo(o);
    }

    @Override
    public synchronized List<B> getBPoints() {
        return super.getBPoints();
    }

    @Override
    public synchronized void setBPoints(List<B> devices) {
        super.setBPoints(devices);
    }

    @Override
    public synchronized int getBCapacity() {
        return  super.getBCapacity();
    }

    @Override
    public synchronized B getBPoint(int deviceNumber) {
        return super.getBPoint(deviceNumber);
    }

    @Override
    public synchronized void setBPoint(B device, int deviceNumber) {
        super.setBPoint(device, deviceNumber);
    }

    @Override
    public synchronized Mode getMode() {
        return super.getMode();
    }

    @Override
    public synchronized Type getType() {
        return super.getType();
    }

    @Override
    public synchronized int getLength() {
        return  super.getLength();
    }

    @Override
    public synchronized void setLength(int length) {
        super.setLength(length);
    }

    @Override
    public synchronized String getTechnology() {
        return super.getTechnology();
    }

    @Override
    public synchronized String getProtocol() {
        return super.getProtocol();
    }

    @Override
    public synchronized void setProtocol(String protocol) {
        super.setProtocol(protocol);
    }

    @Override
    public synchronized int getVersion() {
        return  super.getVersion();
    }

    @Override
    public synchronized void setVersion(int version) {
        super.setVersion(version);
    }

    @Override
    public synchronized ConnectorType getAPointConnectorType() {
        return super.getAPointConnectorType();
    }

    @Override
    public synchronized ConnectorType getBPointConnectorType() {
        return super.getBPointConnectorType();
    }

    @Override
    public synchronized A getAPoint() {
        return super.getAPoint();
    }

    @Override
    public synchronized void setAPoint(A device) {
        super.setAPoint(device);
    }

    @Override
    public synchronized B getBPoint() {
        return super.getBPoint();
    }

    @Override
    public synchronized void setBPoint(B device) {

    }
}