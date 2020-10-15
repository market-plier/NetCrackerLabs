package com.netcracker.edu.inventory.model.impl;

import com.netcracker.edu.inventory.model.Device;

import java.util.Date;

public class AbstractDevice implements Device {

    protected int in=0;
    protected String type;
    protected String manufacturer;
    protected String model;
    protected Date productionDate;

    @Override
    public int getIn() {
        return in;
    }

    @Override
    public void setIn(int in) {
        if (in>0) {
        this.in=in;
        }
        else {
            System.err.println("Значение in не может быть меньше или равным 0");
        }
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public void setType(String type) {

    }

    @Override
    public String getManufacturer() {
        return null;
    }

    @Override
    public void setManufacturer(String manufacturer) {

    }

    @Override
    public String getModel() {
        return null;
    }

    @Override
    public void setModel(String model) {

    }

    @Override
    public Date getProductionDate() {
        return null;
    }

    @Override
    public void setProductionDate(Date productionDate) {

    }
}
