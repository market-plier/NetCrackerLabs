package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.model.Device;

import java.util.Comparator;

class DeviceInComparator implements Comparator<Device>{
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
        if (device1.getIn() == device2.getIn()) {
            return 0;
        }
        if (device1.getIn() == 0) {
            return 1;
        }
        if (device2.getIn() == 0) {
            return -1;
        }
        return device1.getIn() - device2.getIn();
    }
}


