package com.netcracker.edu.inventory.model.device.entity.wrapper;

import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.device.entity.Battery;
import com.netcracker.edu.inventory.model.device.entity.Router;
import com.netcracker.edu.inventory.model.device.entity.Switch;
import com.netcracker.edu.inventory.model.device.entity.WifiRouter;

import java.util.logging.Logger;

public abstract class DeviceWrapper implements Device {
    protected Device wrappee;
    protected Battery batteryWrappee;
    protected Router routerWrappee;
    protected Switch aSwitchWrappee;
    protected WifiRouter wifiRouterWrappee;

    protected Logger logger = Logger.getLogger(DeviceWrapper.class.getName());

}
