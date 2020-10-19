package com.netcracker.edu.inventory.model.impl;

public class Router extends AbstractDevice {
    protected int dataRate;

    public void setDataRate(int dataRate) {
        this.dataRate = dataRate;
    }

    public int getDataRate() {
        return dataRate;
    }
}
