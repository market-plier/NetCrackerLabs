package com.netcracker.edu.inventory.model.connection.entity.wrapper.publish;

import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.connection.entity.ThinCoaxial;
import com.netcracker.edu.inventory.model.device.Device;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Set;

public class ThinCoaxialPublishWrapper<T extends Device> extends ConnectionPublishWrapper<T,T, ThinCoaxial<T>> implements ThinCoaxial<T> {

    public ThinCoaxialPublishWrapper(ThinCoaxial<T> wrappee, PropertyChangeListener listener) {
        super(wrappee, listener);
        thinCoaxialWrapee = wrappee;
    }

    @Override
    public ConnectorType getConnectorType() {
        return thinCoaxialWrapee.getConnectorType();
    }

    @Override
    public boolean addDevice(T device) {
        for (PropertyChangeListener listener: listeners) {
            listener.propertyChange(new PropertyChangeEvent(this, "devices",null, device));
        }
        return thinCoaxialWrapee.addDevice(device);
    }

    @Override
    public boolean removeDevice(T device) {
        if (thinCoaxialWrapee.removeDevice(device)){
            for (PropertyChangeListener listener: listeners) {
                listener.propertyChange(new PropertyChangeEvent(this, "devices", device, null));
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean containDevice(T device) {
        return thinCoaxialWrapee.containDevice(device);
    }

    @Override
    public Set<T> getAllDevices() {
        return thinCoaxialWrapee.getAllDevices();
    }

    @Override
    public int getCurSize() {
        return thinCoaxialWrapee.getCurSize();
    }

    @Override
    public int getMaxSize() {
        return thinCoaxialWrapee.getMaxSize();
    }
}
