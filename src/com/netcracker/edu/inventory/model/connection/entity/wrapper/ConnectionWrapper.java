package com.netcracker.edu.inventory.model.connection.entity.wrapper;

import com.netcracker.edu.inventory.model.FillableEntity;
import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.entity.OpticFiber;
import com.netcracker.edu.inventory.model.connection.entity.ThinCoaxial;
import com.netcracker.edu.inventory.model.connection.entity.TwistedPair;
import com.netcracker.edu.inventory.model.connection.entity.Wireless;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.device.entity.wrapper.immutable.DeviceImmutableWrapper;

import java.util.Collection;
import java.util.logging.Logger;

public abstract class ConnectionWrapper<A extends Device,B extends Device> implements Connection<A,B> {

    protected Connection wrappee;
    protected OpticFiber opticFiberWrapee;
    protected ThinCoaxial thinCoaxialWrapee;
    protected Wireless wirelessWrapee;
    protected TwistedPair twistedPairWrapee;

    protected Logger logger = Logger.getLogger(Connection.class.getName());

}