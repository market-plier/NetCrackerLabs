package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.model.Device;
import com.netcracker.edu.inventory.model.impl.Battery;
import com.netcracker.edu.inventory.model.impl.Router;
import com.netcracker.edu.inventory.model.impl.Switch;
import com.netcracker.edu.inventory.model.impl.WifiRouter;

import java.util.Arrays;
import java.util.logging.Level;

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
