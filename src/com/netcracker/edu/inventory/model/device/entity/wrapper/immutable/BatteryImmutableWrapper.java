package com.netcracker.edu.inventory.model.device.entity.wrapper.immutable;

import com.netcracker.edu.inventory.model.device.entity.Battery;

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

