package com.netcracker.edu.inventory.model.impl;

import com.netcracker.edu.inventory.model.Connection;
import com.netcracker.edu.inventory.model.ConnectorType;
import com.netcracker.edu.inventory.model.Device;
import com.netcracker.edu.inventory.model.OneToManyConnection;
import com.netcracker.edu.location.Trunk;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

abstract class AbstractOneToManyConnection<A extends Device,B extends Device> implements OneToManyConnection<A,B> {

    protected Trunk trunk;
    protected int serialNumber;
    protected String status;
    protected ConnectorType aPointConnectorType;
    protected ConnectorType bPointConnectorType;
    protected A aPoint;
    protected List<B> bPoints;
    protected int bCapacity;

    protected void setAPointConnectorType(ConnectorType connectorType){
        aPointConnectorType = connectorType;
    }

    protected void setBPointConnectorType(ConnectorType connectorType){
        bPointConnectorType=connectorType;
    }

    @Override
    public Trunk getTrunk() {
        return trunk;
    }

    @Override
    public void setTrunk(Trunk trunk) {
    this.trunk = trunk;
    }

    @Override
    public int getSerialNumber() {
        return serialNumber;
    }

    @Override
    public void setSerialNumber(int serialNumber) {
    this.serialNumber = serialNumber;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void setStatus(String status) {
    this.status = status;
    }

    @Override
    public ConnectorType getAPointConnectorType() {
        return aPointConnectorType;
    }

    @Override
    public ConnectorType getBPointConnectorType() {
        return bPointConnectorType;
    }

    @Override
    public A getAPoint() {
        return aPoint;
    }

    @Override
    public void setAPoint(A device) {
    aPoint = device;
    }

    @Override
    public List<B> getBPoints() {
        return bPoints;
    }

    @Override
    public void setBPoints(List<B> devices) {
    bPoints = devices;
    }

    @Override
    public int getBCapacity() {
        return bCapacity;
    }

    @Override
    public B getBPoint(int deviceNumber) {
        return bPoints.get(deviceNumber);
    }

    @Override
    public void setBPoint(B device, int deviceNumber) {
        if (bCapacity != 0){
            bCapacity--;
            bPoints.add(deviceNumber,device);
        }
    }

    @Override
    public int compareTo(Connection o) {
        return getSerialNumber() - o.getSerialNumber();
    }
}
