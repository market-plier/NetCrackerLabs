package com.netcracker.edu.inventory.model.connection.entity.wrapper;

import com.netcracker.edu.inventory.model.connection.entity.OpticFiber;
import com.netcracker.edu.inventory.model.connection.entity.Wireless;
import com.netcracker.edu.inventory.model.device.Device;

import java.util.logging.Logger;

public abstract class OpticFiberWrapper<A extends Device,B extends Device> implements OpticFiber<A,B> {

    protected OpticFiber wrappee;
    protected Logger logger = Logger.getLogger(OpticFiber.class.getName());

}
