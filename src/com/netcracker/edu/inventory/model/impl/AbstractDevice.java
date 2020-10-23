package com.netcracker.edu.inventory.model.impl;

import com.netcracker.edu.inventory.model.Device;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public abstract class AbstractDevice implements Device {

    protected int in;
    protected String type;
    protected String manufacturer;
    protected String model;
    protected Date productionDate;
    protected static Logger logger=Logger.getLogger(AbstractDevice.class.getName());
    @Override
    public int getIn() {
        return in;
    }

    @Override
    public void setIn(int in) {
        try {
            FileInputStream fis = new FileInputStream("./src/logging.properties");
            LogManager.getLogManager().readConfiguration(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (this.in == 0 && in > 0) {
            this.in = in;
        } else if (in < 0) {
            IllegalArgumentException ex =new IllegalArgumentException("IN can not be negative");
            logger.log(Level.SEVERE, "Wrong IN", ex);
            throw ex;
        } else if (this.in != 0) {
            logger.log(Level.WARNING,"Inventory number can not be reset");
        }
    }
    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
    this.type=type;
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public void setManufacturer(String manufacturer) {
    this.manufacturer=manufacturer;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void setModel(String model) {
    this.model=model;
    }

    @Override
    public Date getProductionDate() {
        return productionDate;
    }

    @Override
    public void setProductionDate(Date productionDate) {
    this.productionDate=productionDate;
    }
}
