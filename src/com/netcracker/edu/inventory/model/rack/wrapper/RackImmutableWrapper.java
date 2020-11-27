package com.netcracker.edu.inventory.model.rack.wrapper;

import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.rack.Rack;
import com.netcracker.edu.location.Location;

import java.util.logging.Level;

public class RackImmutableWrapper<D extends Device> extends RackWrapper<D>{


    public RackImmutableWrapper(Rack<D> wrappee) {
        this.wrappee=wrappee;
    }

    @Override
    public Location getLocation() {
        return wrappee.getLocation();
    }

    @Override
    public void setLocation(Location location) {
        logger.log(Level.WARNING,"Can't change immutable rack");
    }

    @Override
    public int getSize() {
        return wrappee.getSize();
    }

    @Override
    public int getFreeSize() {
        return wrappee.getFreeSize();
    }

    @Override
    public Class getTypeOfDevices() {
        return wrappee.getTypeOfDevices();
    }

    @Override
    public D getDevAtSlot(int index) {
        return wrappee.getDevAtSlot(index);
    }

    @Override
    public boolean insertDevToSlot(Device device, int index) {
        logger.log(Level.WARNING,"Can't change immutable rack");
        return false;
    }

    @Override
    public D removeDevFromSlot(int index) {
        logger.log(Level.WARNING,"Can't change immutable rack");
        return null;
    }

    @Override
    public D getDevByIN(int in) {
        return wrappee.getDevByIN(in);
    }

    @Override
    public D[] getAllDeviceAsArray() {
        return wrappee.getAllDeviceAsArray();
    }
}
