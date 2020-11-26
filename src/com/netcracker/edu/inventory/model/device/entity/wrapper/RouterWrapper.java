package com.netcracker.edu.inventory.model.device.entity.wrapper;

import com.netcracker.edu.inventory.model.device.entity.Battery;
import com.netcracker.edu.inventory.model.device.entity.Router;

import java.util.logging.Logger;

public abstract class RouterWrapper implements Router {

    protected Router wrappee;
    protected Logger logger = Logger.getLogger(Router.class.getName());
}
