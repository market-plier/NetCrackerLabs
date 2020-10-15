package com.netcracker.edu.inventory.model.impl;

import com.netcracker.edu.inventory.model.Device;

public class Router extends AbstractDevice implements Device {
    protected int dataRate;

    public void setDataRate(int dataRate) {
        this.dataRate = dataRate;
    }

    public int getDataRate() {
        return dataRate;
    }
}
