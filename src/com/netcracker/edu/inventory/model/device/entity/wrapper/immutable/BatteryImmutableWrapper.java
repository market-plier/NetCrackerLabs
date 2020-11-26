package com.netcracker.edu.inventory.model.device.entity.wrapper.immutable;

import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.device.entity.Battery;
import com.netcracker.edu.inventory.model.device.entity.wrapper.BatteryWrapper;

import java.util.Date;
import java.util.Queue;
import java.util.logging.Level;

public class BatteryImmutableWrapper extends DeviceImmutableWrapper<Battery> implements Battery {

    public BatteryImmutableWrapper(Battery wrappee) {
        super(wrappee);
        batteryWrappee=wrappee;
    }

    @Override
    public int getChargeVolume() {
        return batteryWrappee.getChargeVolume();
    }

    @Override
    public void setChargeVolume(int chargeVolume) {
        logger.log(Level.WARNING,"Can't change immutable connection");

    }
}

