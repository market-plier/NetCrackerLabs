package com.netcracker.edu.inventory.model.impl;

public class Switch extends Router {
    protected int numberOfPorts;

    public void setNumberOfPorts(int numberOfPorts) {
        this.numberOfPorts = numberOfPorts;
    }

    public int getNumberOfPorts() {
        return numberOfPorts;
    }
}
