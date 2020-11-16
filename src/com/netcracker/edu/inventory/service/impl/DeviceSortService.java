package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.model.Device;

import java.util.Arrays;

class DeviceSortService {

    public void sortByIN(Device[] devices) {
        if (devices != null) {
            Arrays.sort(devices, new DeviceInComparator());
        }
    }
    public void sortByProductionDate(Device[] devices) {
        if (devices != null) {
            Arrays.sort(devices, new DeviceDateComparator());
        }
    }
}
