package com.netcracker.edu.inventory.model.impl;

import com.netcracker.edu.inventory.exception.DeviceValidationException;
import com.netcracker.edu.inventory.model.Device;
import com.netcracker.edu.inventory.model.Rack;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class RackArrayImpl implements Rack {
    private final Device[] devices;
    private final int size;
    private int freeSize;
    private Logger logger=Logger.getLogger(RackArrayImpl.class.getName());
    public RackArrayImpl(int size) {
        if (size > 0) {
            devices = new Device[size];
        } else {
            throw new IllegalArgumentException("Size of rack can not be 0 or less");
        }
        this.size = size;
        freeSize = size;
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getFreeSize() {
        return freeSize;
    }

    private boolean indexIsValid (int index){
        if (index<0 || index>=size) {
            throw new IndexOutOfBoundsException("Index "+index+" is invalid. Valid index is from 0 to "+(size-1));
        }
        return true;
    }
    @Override
    public Device getDevAtSlot(int index) {
        if (indexIsValid(index)) {
            return devices[index];
        } else {
            return null;
        }
    }

    @Override
    public boolean insertDevToSlot(Device device, int index) {
        if(getDevAtSlot(index)==null){
            if(device!=null){
                if (device.getIn() > 0) {
                    devices[index] = device;
                    freeSize -= 1;
                    return true;
                }

            }
            throw new DeviceValidationException("Rack.insertDevToSlot ",device);
        } else {
            //System.err.println("Can't insert to full slot");
            return false;
        }
    }

    @Override
    public Device removeDevFromSlot(int index) {

        if (getDevAtSlot(index) != null) {
            Device temp = devices[index];
            devices[index] = null;
            return temp;
        } else {
            try {
                FileInputStream fis = new FileInputStream("./src/logging.properties");
                LogManager.getLogManager().readConfiguration(fis);

            } catch (IOException e) {
                e.printStackTrace();
            }
            logger.log(Level.WARNING,"Can not remove from empty slot <"+index+">");
            return null;
        }
    }

    @Override
    public Device getDevByIN(int in) {
        if (in > 0) {
            for (int i = 0; i < size; i++) {
                if (getDevAtSlot(i)==null) continue;
                if (getDevAtSlot(i).getIn() == in) {
                    return devices[i];
                }
            }
        }
        return null;
    }
}