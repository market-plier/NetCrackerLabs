package com.netcracker.edu.inventory.model.connection.entity.wrapper.immutable;

import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.connection.entity.ThinCoaxial;
import com.netcracker.edu.inventory.model.device.Device;

import java.util.Set;
import java.util.logging.Level;

public class ThinCoaxialImmutableWrapper<T extends Device> extends ConnectionImmutableWrapper<T,T,ThinCoaxial<T>> implements ThinCoaxial<T> {

    public ThinCoaxialImmutableWrapper(ThinCoaxial<T> wrappee) {
        super(wrappee);
        thinCoaxialWrapee = wrappee;
    }

    @Override
    public ConnectorType getConnectorType() {
        return thinCoaxialWrapee.getConnectorType();
    }

    @Override
    public boolean addDevice(T device) {
        logger.log(Level.WARNING, "Can't change immutable connection");
        return false;
    }

    @Override
    public boolean removeDevice(T device) {
        logger.log(Level.WARNING, "Can't change immutable connection");
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
