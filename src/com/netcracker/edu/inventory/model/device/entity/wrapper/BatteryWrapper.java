package com.netcracker.edu.inventory.model.device.entity.wrapper;

import com.netcracker.edu.inventory.model.device.entity.Battery;
import com.netcracker.edu.inventory.model.device.entity.wrapper.implementations.AbstractDeviceWrapper;

public class BatteryWrapper extends DeviceWrapper implements Battery {

    public BatteryWrapper(AbstractDeviceWrapper wrapper) {
        super(wrapper);
    }

    @Override
    public int getChargeVolume() {
        return wrapper.getChargeVolume();
    }

    @Override
    public void setChargeVolume(int chargeVolume) {
        wrapper.setChargeVolume(chargeVolume);
    }
}

