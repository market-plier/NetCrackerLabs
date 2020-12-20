package com.netcracker.edu.inventory.model.connection.impl;

import com.netcracker.edu.inventory.model.connection.ConnectionPrimaryKey;
import com.netcracker.edu.location.Trunk;

import java.util.Objects;

public class ConnectionPK implements ConnectionPrimaryKey {
    private final Trunk trunk;
    private final int serialNumber;

    public ConnectionPK(Trunk trunk, int serialNumber) {
        this.trunk = trunk;
        this.serialNumber = serialNumber;
    }

    @Override
    public Trunk getTrunk() {
        return trunk;
    }

    @Override
    public int getSerialNumber() {
        return serialNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConnectionPK that = (ConnectionPK) o;
        return serialNumber == that.serialNumber &&
                Objects.equals(trunk, that.trunk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trunk, serialNumber);
    }

    @Override
    public int compareTo( ConnectionPrimaryKey o) {
        return serialNumber-o.getSerialNumber();
    }
}
