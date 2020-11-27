package com.netcracker.edu.inventory.model.device.entity.wrapper.publish;

import com.netcracker.edu.inventory.model.device.entity.Router;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class RouterPublishWrapper extends DevicePublishWrapper<Router> implements Router {

    public RouterPublishWrapper(Router device, PropertyChangeListener listener) {
        super(device, listener);
        routerWrappee=device;
    }

    @Override
    public int getDataRate() {
        return routerWrappee.getDataRate();
    }

    @Override
    public void setDataRate(int dataRate) {
        for (PropertyChangeListener listener: listeners) {
            listener.propertyChange(new PropertyChangeEvent(this, "dataRate", routerWrappee.getDataRate(), dataRate));
        }
        routerWrappee.setDataRate(dataRate);
    }
}
