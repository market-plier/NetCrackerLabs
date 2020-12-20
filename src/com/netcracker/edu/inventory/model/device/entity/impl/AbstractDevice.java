package com.netcracker.edu.inventory.model.device.entity.impl;

import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.device.DevicePrimaryKey;
import com.netcracker.edu.inventory.model.device.impl.DevicePK;

import java.util.Date;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractDevice implements Device  {

    protected int in;
    protected String type;
    protected String manufacturer;
    protected String model;
    protected Date productionDate;
    protected static Logger logger = Logger.getLogger(AbstractDevice.class.getName());

    @Override
    public int compareTo(Device device)
    {
        if (device != null){
            if (device.isLazy()){
                return Integer.compare(getIn(),device.getPrimaryKey().getIn());
            }
        return Integer.compare(getIn(),device.getIn());
        }
        return 1;
    }

    @Override
    public int getIn() {
        return in;
    }

    @Override
    public void fillAllFields(Queue<Field> fields){
        try {
        setIn((Integer) fields.remove().getValue());
        setManufacturer((String)fields.remove().getValue());
        setModel((String)fields.remove().getValue());
        setProductionDate((Date)fields.remove().getValue());
        setType((String)fields.remove().getValue());
        }
        catch (NoSuchElementException exception){
            logger.log(Level.SEVERE,exception.getMessage(),exception);
            throw exception;
        }
    }

    @Override
    public Queue<Field> getAllFields() {
        Queue<Field> fields= new LinkedList<>();
        fields.add(new Field(Integer.class,getIn()));
        fields.add(new Field(String.class,getManufacturer()));
        fields.add(new Field(String.class,getModel()));
        fields.add(new Field(Date.class,getProductionDate()));
        fields.add(new Field(String.class,getType()));
        return fields;
    }

    @Override
    public void setIn(int in) {
        if (this.in == 0 && in > 0) {
            this.in = in;
        } else if (in < 0) {
            IllegalArgumentException ex = new IllegalArgumentException("IN can not be negative");
            logger.log(Level.SEVERE, ex.getMessage(), ex);
            throw ex;
        } else if (this.in != 0) {
            logger.log(Level.WARNING, "Inventory number can not be reset");
        }
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public Date getProductionDate() {
        return productionDate;
    }

    @Override
    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    @Override
    public boolean isLazy() {
        return false;
    }

    @Override
    public DevicePrimaryKey getPrimaryKey() {
        if (in==0)
            return null;
        return new DevicePK(in);
    }
}
