package com.netcracker.edu.inventory.model.device.entity.wrapper.publish;

import com.netcracker.edu.inventory.model.device.entity.Battery;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class BatteryPublishWrapper extends DevicePublishWrapper<Battery> implements Battery{
    public BatteryPublishWrapper(Battery wrappee, PropertyChangeListener listener) {
        super(wrappee,listener);
        batteryWrappee=wrappee;
    }

    @Override
    public int getChargeVolume() {
        return batteryWrappee.getChargeVolume();
    }

    @Override
    public void setChargeVolume(int chargeVolume) {
        for (PropertyChangeListener listener: listeners) {
            listener.propertyChange(new PropertyChangeEvent(this, "chargeVolume", batteryWrappee.getChargeVolume(), chargeVolume));
        }
        batteryWrappee.setChargeVolume(chargeVolume);
    }
}
