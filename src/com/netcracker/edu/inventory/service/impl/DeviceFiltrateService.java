package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.model.Device;

public class DeviceFiltrateService {
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
}
