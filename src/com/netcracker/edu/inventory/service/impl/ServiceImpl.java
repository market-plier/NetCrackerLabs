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
        if (devices != null) {
            Arrays.sort(devices, new DeviceInComparator());
        }
    }

    @Deprecated
    @Override
    public void sortByProductionDate(Device[] devices) {
        if (devices != null) {
            Arrays.sort(devices, new DeviceDateComparator());
        }
    }

    @Deprecated
    @Override
    public void filtrateByType(Device[] devices, String type) {
        if (devices != null) {
            for (int i = 0; i < devices.length; i++) {
                if (devices[i] != null) {
                    if (devices[i].getType() != null && type != null) {
                        if (type.compareTo(devices[i].getType()) != 0) {
                            devices[i] = null;
                        }
                    } else if (devices[i].getType() != type) {
                        devices[i] = null;
                    }
                }
            }
        }
    }

    @Deprecated
    @Override
    public void filtrateByManufacturer(Device[] devices, String manufacturer) {
        if (devices != null) {
            for (int i = 0; i < devices.length; i++) {
                if (devices[i] != null) {
                    if (devices[i].getManufacturer() != null && manufacturer != null) {
                        if (manufacturer.compareTo(devices[i].getManufacturer()) != 0) {
                            devices[i] = null;
                        }
                    } else if (devices[i].getManufacturer() != manufacturer) {
                        devices[i] = null;
                    }

                }
            }
        }
    }

    @Deprecated
    @Override
    public void filtrateByModel(Device[] devices, String model) {
        if (devices != null) {
            for (int i = 0; i < devices.length; i++) {
                if (devices[i] != null) {
                    if (devices[i].getModel() != null && model != null) {
                        if (model.compareTo(devices[i].getModel()) != 0) {
                            devices[i] = null;
                        }
                    } else if (devices[i].getModel() != model) {
                        devices[i] = null;
                    }
                }
            }
        }
    }

    @Deprecated
    @Override
    public boolean isValidDeviceForInsertToRack(Device device) {
        if (device == null) {
            return false;
        }
        return device.getIn() > 0;
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
