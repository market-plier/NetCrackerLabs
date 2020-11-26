package com.netcracker.edu.inventory.model.device.entity.wrapper;

import com.netcracker.edu.inventory.model.connection.entity.Wireless;
import com.netcracker.edu.inventory.model.device.entity.Battery;

import java.util.logging.Logger;

public abstract class BatteryWrapper implements Battery {
    protected Battery wrappee;
    protected Logger logger = Logger.getLogger(Battery.class.getName());
}
