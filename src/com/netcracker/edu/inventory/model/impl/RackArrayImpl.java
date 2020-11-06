package com.netcracker.edu.inventory.model.impl;

import com.netcracker.edu.inventory.exception.DeviceValidationException;
import com.netcracker.edu.inventory.model.Device;
import com.netcracker.edu.inventory.model.Rack;
import com.netcracker.edu.inventory.service.impl.ServiceImpl;
import com.netcracker.edu.location.Location;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RackArrayImpl<D extends Device> implements Rack<D> {
    private Location location;
    private final Class typeOfDevices;
    private final D[] devices;
    private final int size;
    private int freeSize;
    private final Logger logger = Logger.getLogger(RackArrayImpl.class.getName());

    public RackArrayImpl(int size) {
        this(size, Device.class);
    }

    public RackArrayImpl(int size, Class clazz) {
        if (clazz != null && Device.class.isAssignableFrom(clazz)) {
            typeOfDevices = clazz;
        } else {
            IllegalArgumentException ex = new IllegalArgumentException("не может быть null или не Device");
            logger.log(Level.SEVERE, ex.getMessage(), ex);
            throw ex;
        }
        if (size > 0) {
            devices = (D[]) new Device[size];
        } else {
            IllegalArgumentException ex = new IllegalArgumentException("Size of rack can not be 0 or less");
            logger.log(Level.SEVERE, ex.getMessage(), ex);
            throw ex;
        }
        this.size = size;
        freeSize = size;
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public void setLocation(Location location) {
        this.location=location;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getFreeSize() {
        return freeSize;
    }

    @Override
    public Class getTypeOfDevices() {
        return typeOfDevices;
    }

    private boolean indexIsValid(int index) {
        if (index < 0 || index >= size) {
            IndexOutOfBoundsException ex = new IndexOutOfBoundsException("Index " + index + " is invalid. Valid index is from 0 to " + (size - 1));
            logger.log(Level.SEVERE, ex.getMessage(), ex);
            throw ex;
        }
        return true;
    }

    @Override
    public D getDevAtSlot(int index) {
        if (indexIsValid(index)) {
            return devices[index];
        } else {
            return null;
        }
    }

    @Override
    public boolean insertDevToSlot(D device, int index) {
        ServiceImpl service = new ServiceImpl();
        if (service.isValidDeviceForInsertToRack(device)) {
            if (!typeOfDevices.isAssignableFrom(device.getClass())) {
                IllegalArgumentException ex = new IllegalArgumentException("тип передаваемого объекта не совместим с типом, который может\n" +
                        "хранить стойка");
                logger.log(Level.SEVERE, ex.getMessage(), ex);
                throw ex;
            }
            if (getDevAtSlot(index) == null) {
                devices[index] = device;
                freeSize -= 1;
                return true;
            } else {
                logger.log(Level.WARNING, ("Can't insert in full"));
                return false;
            }
        }
        DeviceValidationException ex = new DeviceValidationException("Rack.insertDevToSlot ", device);
        logger.log(Level.SEVERE, ex.getMessage(), ex);
        throw ex;
    }

    @Override
    public D removeDevFromSlot(int index) {
        if (getDevAtSlot(index) != null) {
            D temp = devices[index];
            devices[index] = null;
            return temp;
        } else {

            logger.log(Level.WARNING, "Can not remove from empty slot <" + index + ">");
            return null;
        }
    }

    @Override
    public D getDevByIN(int in) {
        if (in > 0) {
            for (int i = 0; i < size; i++) {
                if (getDevAtSlot(i) == null) continue;
                if (getDevAtSlot(i).getIn() == in) {
                    return devices[i];
                }
            }
        }
        return null;
    }

    @Override
    public D[] getAllDeviceAsArray() {
        D[] temp = (D[]) new Device[size - freeSize];
        for (int i = 0, j = 0; i < size && j < (size - freeSize); i++) {
            if (devices[i] != null) {
                temp[j] = devices[i];
                j++;
            }
        }
        return temp;
    }
}