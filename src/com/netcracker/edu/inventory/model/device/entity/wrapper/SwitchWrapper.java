package com.netcracker.edu.inventory.model.device.entity.wrapper;

import com.netcracker.edu.inventory.model.device.entity.Battery;
import com.netcracker.edu.inventory.model.device.entity.Router;
import com.netcracker.edu.inventory.model.device.entity.Switch;

import java.util.logging.Logger;

public abstract class SwitchWrapper implements Switch {
    protected Switch wrappee;
    protected Logger logger = Logger.getLogger(Switch.class.getName());
}
