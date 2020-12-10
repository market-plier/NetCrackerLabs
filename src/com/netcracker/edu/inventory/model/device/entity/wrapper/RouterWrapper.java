package com.netcracker.edu.inventory.model.device.entity.wrapper;

import com.netcracker.edu.inventory.model.device.entity.Router;
import com.netcracker.edu.inventory.model.device.entity.wrapper.implementations.AbstractDeviceWrapper;

public class RouterWrapper extends DeviceWrapper implements Router {

    public RouterWrapper(AbstractDeviceWrapper device) {
        super(device);
    }

    @Override
    public int getDataRate() {
        return wrapper.getDataRate();
    }

    @Override
    public void setDataRate(int dataRate) {
        wrapper.setDataRate(dataRate);
    }
}
