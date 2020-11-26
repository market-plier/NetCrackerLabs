package com.netcracker.edu.inventory.model.connection.entity.wrapper;

import com.netcracker.edu.inventory.model.connection.entity.Wireless;
import com.netcracker.edu.inventory.model.device.Device;

import java.util.logging.Logger;

public abstract class WirelessWrapper<A extends Device,B extends Device> implements Wireless<A, B> {

    protected Wireless wrappee;
    protected Logger logger = Logger.getLogger(Wireless.class.getName());
}
