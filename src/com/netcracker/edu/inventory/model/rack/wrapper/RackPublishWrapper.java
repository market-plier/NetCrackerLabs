package com.netcracker.edu.inventory.model.rack.wrapper;

import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.rack.Rack;
import com.netcracker.edu.location.Location;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class RackPublishWrapper<D extends Device> extends RackWrapper<D> {
protected List<PropertyChangeListener> listeners;
    public RackPublishWrapper(Rack<D> rack,PropertyChangeListener listener) {
        listeners=new ArrayList<>();
        listeners.add(listener);
        wrappee=rack;
    }

    @Override
    public Location getLocation() {
        return wrappee.getLocation();
    }

    @Override
    public void setLocation(Location location) {
        for (PropertyChangeListener listener: listeners) {
            listener.propertyChange(new PropertyChangeEvent(this, "location", wrappee.getLocation(), location));
        }
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
    public boolean insertDevToSlot(D device, int index) {
        for (PropertyChangeListener listener: listeners) {
            listener.propertyChange(new PropertyChangeEvent(this, "devices", wrappee.getDevAtSlot(index), device));
        }
        return wrappee.insertDevToSlot(device,index);
    }

    @Override
    public D removeDevFromSlot(int index) {
        for (PropertyChangeListener listener: listeners) {
            listener.propertyChange(new PropertyChangeEvent(this, "devices", wrappee.getDevAtSlot(index), null));
        }
        return wrappee.removeDevFromSlot(index);
    }

    @Override
    public D getDevByIN(int in) {
        return wrappee.getDevByIN(in);
    }

    @Override
    public D[] getAllDeviceAsArray() {
        return wrappee.getAllDeviceAsArray();
    }
    public void subscribe(PropertyChangeListener listener) {
        listeners.add(listener);
    }

    public boolean unsubscribe(PropertyChangeListener listener) {
        return listeners.remove(listener);
    }
}
