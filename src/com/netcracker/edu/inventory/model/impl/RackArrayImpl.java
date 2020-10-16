package com.netcracker.edu.inventory.model.impl;

import com.netcracker.edu.inventory.model.Device;
import com.netcracker.edu.inventory.model.Rack;

public class RackArrayImpl implements Rack {
    private final Device[] devices;
    private final int size;
    private int freeSize;

    public RackArrayImpl(int size) {
        if (size > 0) {
            devices = new Device[size];
        } else {
            System.err.println("Значение size должно быть больше 0");
            devices = new Device[0];
            size = 0;
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

    @Override
    public Device getDevAtSlot(int index) {
        if (index > 0 && index < size) {

            return devices[index];
        } else {
            System.err.println("Такого слота нет в списке");
            return null;
        }
    }

    @Override
    public boolean insertDevToSlot(Device device, int index) {

        if(getDevAtSlot(index)==null){
            if (device.getIn() > 0) {
                devices[index] = device;
                freeSize -= 1;
                return true;
            } else {
                System.err.println("Can't insert device object with incorrect IN (<0) or IN by default (0)");
                return false;
            }
        } else {
            System.err.println("Can't insert to full slot");
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
                System.err.println("Device is null");
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