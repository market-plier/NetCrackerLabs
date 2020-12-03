package com.netcracker.edu.inventory.model.connection.entity.wrapper;

import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.connection.entity.ThinCoaxial;
import com.netcracker.edu.inventory.model.connection.entity.wrapper.ConnectionImmutableWrapper;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.device.entity.wrapper.DeviceWrapper;

import java.util.Set;
import java.util.logging.Level;

public class ThinCoaxialWrapper<T extends Device> extends ConnectionWrapper<T,T> implements ThinCoaxial<T> {


    public ThinCoaxialWrapper(AbstractConnectionWrapper<T, T> wrapper) {
        super(wrapper);
    }

    @Override
    public ConnectorType getConnectorType() {
        return wrapper.getConnectorType();
    }

    @Override
    public boolean addDevice(T device) {
        return wrapper.addDevice(device);
    }

    @Override
    public boolean removeDevice(T device) {
        return wrapper.removeDevice(device);
    }

    @Override
    public boolean containDevice(T device) {
        return wrapper.containDevice(device);
    }

    @Override
    public Set<T> getAllDevices() {
        return wrapper.getAllDevices();
    }

    @Override
    public int getCurSize() {
        return wrapper.getCurSize();
    }

    @Override
    public int getMaxSize() {
        return wrapper.getMaxSize();
    }
}
