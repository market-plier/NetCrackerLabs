package com.netcracker.edu.inventory.model.connection.entity.wrapper;

import com.netcracker.edu.inventory.model.connection.entity.TwistedPair;
import com.netcracker.edu.inventory.model.connection.entity.Wireless;
import com.netcracker.edu.inventory.model.device.Device;

import java.util.logging.Logger;

public abstract class TwistedPairWrapper<A extends Device,B extends Device> implements TwistedPair<A,B> {

    protected TwistedPair wrappee;
    protected Logger logger = Logger.getLogger(TwistedPair.class.getName());

}
