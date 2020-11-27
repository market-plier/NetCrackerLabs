package com.netcracker.edu.inventory.model.device.entity.wrapper.publish;

import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.device.entity.wrapper.DeviceWrapper;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;

public class DevicePublishWrapper<T extends Device> extends DeviceWrapper {

    protected List<PropertyChangeListener> listeners;
    
    public DevicePublishWrapper(T device, PropertyChangeListener listener) {
        this.wrappee = device;
        listeners = new ArrayList<>();
        listeners.add(listener);
    }

    public void subscribe(PropertyChangeListener listener) {
        listeners.add(listener);
    }

    public boolean unsubscribe(PropertyChangeListener listener) {
        return listeners.remove(listener);
    }
    @Override
    public int getIn() {
        return wrappee.getIn();
    }

    @Override
    public void setIn(int in) {
        for (PropertyChangeListener listener: listeners) {
            listener.propertyChange(new PropertyChangeEvent(this, "in", wrappee.getIn(), in));
        }
        wrappee.setIn(in);
    }

    @Override
    public String getType() {
        return wrappee.getType();
    }

    @Override
    public void setType(String type) {
        for (PropertyChangeListener listener: listeners) {
            listener.propertyChange(new PropertyChangeEvent(this,"type",wrappee.getType(),type));
        }
        wrappee.setType(type);
    }

    @Override
    public String getManufacturer() {
        return wrappee.getManufacturer();
    }

    @Override
    public void setManufacturer(String manufacturer) {
        for (PropertyChangeListener listener: listeners) {
            listener.propertyChange(new PropertyChangeEvent(this, "manufacturer", wrappee.getManufacturer(), manufacturer));
        }
        wrappee.setManufacturer(manufacturer);
    }

    @Override
    public String getModel() {
        return wrappee.getModel();
    }

    @Override
    public void setModel(String model) {
        for (PropertyChangeListener listener: listeners) {
            listener.propertyChange(new PropertyChangeEvent(this, "model", wrappee.getModel(), model));
        }
        wrappee.setModel(model);
    }

    @Override
    public Date getProductionDate() {
        return wrappee.getProductionDate();
    }

    @Override
    public void setProductionDate(Date productionDate) {
        for (PropertyChangeListener listener: listeners) {
            listener.propertyChange(new PropertyChangeEvent(this, "productionDate", wrappee.getProductionDate(), productionDate));
        }
        wrappee.setProductionDate(productionDate);
    }

    @Override
    public void fillAllFields(Queue<Field> fields) {
        wrappee.fillAllFields(fields);
    }

    @Override
    public Queue<Field> getAllFields() {
        return wrappee.getAllFields();
    }

    @Override
    public int compareTo(Device o) {
        return wrappee.compareTo(o);
    }
}
