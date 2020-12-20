package com.netcracker.edu.inventory.model.device.impl;

import com.netcracker.edu.inventory.model.device.DevicePrimaryKey;

import java.util.Objects;

public class DevicePK implements DevicePrimaryKey {
    private final int in;

    public DevicePK(int in) {
        this.in = in;
    }

    @Override
    public int getIn() {
        return in;
    }

    @Override
    public boolean equals(Object o){
        if (this==o)
        return true;
        if (o instanceof DevicePrimaryKey){
            return getIn() == ((DevicePrimaryKey) o).getIn();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(in);
    }

    @Override
    public int compareTo(DevicePrimaryKey o) {
        return in-o.getIn();
    }
}
