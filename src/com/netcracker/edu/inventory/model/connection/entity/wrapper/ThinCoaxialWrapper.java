package com.netcracker.edu.inventory.model.connection.entity.wrapper;

import com.netcracker.edu.inventory.model.connection.entity.ThinCoaxial;
import com.netcracker.edu.inventory.model.connection.entity.Wireless;
import com.netcracker.edu.inventory.model.device.Device;

import java.util.logging.Logger;

public abstract class ThinCoaxialWrapper<T extends Device> implements ThinCoaxial<T> {

    protected ThinCoaxial wrappee;
    protected Logger logger = Logger.getLogger(ThinCoaxial.class.getName());
}
