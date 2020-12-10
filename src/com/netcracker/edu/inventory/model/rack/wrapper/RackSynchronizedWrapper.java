package com.netcracker.edu.inventory.model.rack.wrapper;

import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.rack.Rack;
import com.netcracker.edu.location.Location;

public  class RackSynchronizedWrapper<D extends Device> extends RackWrapper<D> {
    public RackSynchronizedWrapper(Rack<D> rack) {
        wrappee = rack;
    }

    @Override
    public synchronized Location getLocation() {
        return wrappee.getLocation();
    }

    @Override
    public synchronized void setLocation(Location location) {
        wrappee.setLocation(location);
    }

    @Override
    public synchronized int getSize() {
        return wrappee.getSize();
    }

    @Override
    public synchronized int getFreeSize() {
        return wrappee.getFreeSize();
    }

    @Override
    public synchronized Class getTypeOfDevices() {
        return wrappee.getTypeOfDevices();
    }

    @Override
    public synchronized D getDevAtSlot(int index) {
        return wrappee.getDevAtSlot(index);
    }

    @Override
    public synchronized boolean insertDevToSlot(D device, int index) {
        return wrappee.insertDevToSlot(device,index);
    }

    @Override
    public synchronized D removeDevFromSlot(int index) {
        return wrappee.removeDevFromSlot(index);
    }

    @Override
    public synchronized D getDevByIN(int in) {
        return wrappee.getDevByIN(in);
    }

    @Override
    public synchronized D[] getAllDeviceAsArray() {
        return wrappee.getAllDeviceAsArray();
    }
}
