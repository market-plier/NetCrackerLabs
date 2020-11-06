package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.model.Device;
import com.netcracker.edu.inventory.model.impl.Battery;
import com.netcracker.edu.inventory.model.impl.Router;
import com.netcracker.edu.inventory.model.impl.Switch;
import com.netcracker.edu.inventory.model.impl.WifiRouter;

class DeviceCreateService {
    public <T extends Device> T CreateDevice(Class<T> clazz) {
        if (clazz.isAssignableFrom(Battery.class)) {
            return (T) new Battery();
        }
        if (clazz.isAssignableFrom(Router.class)) {
            return (T) new Router();
        }

        if (WifiRouter.class.isAssignableFrom(clazz)) {
            return (T) new WifiRouter();
        }

        if (Switch.class.isAssignableFrom(clazz)) {
            return (T) new Switch();
        }
        return null;
    }

    public boolean isValidDeviceForInsertToRack(Device device) {
        if (device == null) {
            return false;
        }
        return device.getIn() > 0;
    }
}