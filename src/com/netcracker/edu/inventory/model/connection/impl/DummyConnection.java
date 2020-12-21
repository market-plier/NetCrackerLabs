package com.netcracker.edu.inventory.model.connection.impl;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectionPrimaryKey;
import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.connection.entity.AllConnections;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.location.Trunk;

import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class DummyConnection<A extends Device,B extends Device> implements AllConnections<A,B> {

    private final ConnectionPrimaryKey primaryKey;

    public DummyConnection(ConnectionPrimaryKey primaryKey) {
        this.primaryKey = primaryKey;
    }

    @Override
    public Trunk getTrunk() {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public void setTrunk(Trunk trunk) {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public int getSerialNumber() {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public void setSerialNumber(int serialNumber) {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public String getStatus() {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public void setStatus(String status) {
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
    public ConnectionPrimaryKey getPrimaryKey() {
        return primaryKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DummyConnection<?, ?> that = (DummyConnection<?, ?>) o;
        return Objects.equals(primaryKey, that.primaryKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(primaryKey);
    }

    @Override
    public int compareTo(Connection<A,B> o) {
        return primaryKey.compareTo(o.getPrimaryKey());
    }

    @Override
    public List<B> getBPoints() {
        return null;
    }

    @Override
    public void setBPoints(List<B> devices) {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public int getBCapacity() {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public B getBPoint(int deviceNumber) {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public void setBPoint(B device, int deviceNumber) {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public Mode getMode() {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public Type getType() {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public int getLength() {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public void setLength(int length) {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public String getTechnology() {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public String getProtocol() {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public void setProtocol(String protocol) {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public int getVersion() {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public void setVersion(int version) {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public ConnectorType getAPointConnectorType() {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public ConnectorType getBPointConnectorType() {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public A getAPoint() {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public void setAPoint(A device) {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public B getBPoint() {
        throw new UnsupportedOperationException("Connection is Dummy");
    }

    @Override
    public void setBPoint(B device) {
        throw new UnsupportedOperationException("Connection is Dummy");
    }
}
