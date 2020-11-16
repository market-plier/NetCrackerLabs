package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.model.Device;

class DeviceCreateService {
    @Deprecated
    public <T extends Device> T CreateDevice(Class<T> clazz) {
        return new ServiceImpl().createNEInstance(clazz);
    }

    public boolean isValidDeviceForInsertToRack(Device device) {
        if (device == null) {
            return false;
        }
        return device.getIn() > 0;
    }
}