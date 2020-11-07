package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.model.Device;
import com.netcracker.edu.inventory.service.DeviceService;
import com.netcracker.edu.inventory.service.RackService;
import com.netcracker.edu.inventory.service.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class ServiceImpl implements Service {

    @Deprecated
    @Override
    public void sortByIN(Device[] devices) {
        getDeviceService().sortByIN(devices);
    }

    @Deprecated
    @Override
    public void sortByProductionDate(Device[] devices) {
        getDeviceService().sortByProductionDate(devices);
    }

    @Deprecated
    @Override
    public void filtrateByType(Device[] devices, String type) {
        getDeviceService().filtrateByType(devices,type);
    }

    @Deprecated
    @Override
    public void filtrateByManufacturer(Device[] devices, String manufacturer) {
       getDeviceService().filtrateByManufacturer(devices, manufacturer);
    }

    @Deprecated
    @Override
    public void filtrateByModel(Device[] devices, String model) {
       getDeviceService().filtrateByModel(devices,model);
    }

    @Deprecated
    @Override
    public boolean isValidDeviceForInsertToRack(Device device) {
        return getDeviceService().isValidDeviceForInsertToRack(device);
    }

    @Override
    public DeviceService getDeviceService() {
        return new DeviceServiceImpl();
    }

    @Override
    public RackService getRackService() {
        return new RackServiceImpl();
    }
}
