package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.model.Device;

import java.util.Comparator;

class DeviceDateComparator implements Comparator<Device> {

    @Override
    public int compare(Device device1, Device device2) {
        if (device1 == null && device2 == null) {
            return 0;
        }
        if (device1 == null) {
            return 1;
        }
        if (device2 == null) {
            return -1;
        }
        if (device1.getProductionDate() == device2.getProductionDate()) {
            return 0;
        }
        if (device1.getProductionDate() == null) {
            return 1;
        }
        if (device2.getProductionDate() == null) {
            return -1;
        }
        if (device1.getProductionDate().after(device2.getProductionDate())) {
            return 1;
        } else return -1;
    }
}