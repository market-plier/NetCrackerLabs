package com.netcracker.edu.inventory.model.device.entity.wrapper;

import com.netcracker.edu.inventory.model.device.entity.WifiRouter;

import java.util.logging.Logger;

public abstract class WifiRouterWrapper implements WifiRouter
{
    protected WifiRouter wrappee;
    protected Logger logger = Logger.getLogger(WifiRouter.class.getName());
}
