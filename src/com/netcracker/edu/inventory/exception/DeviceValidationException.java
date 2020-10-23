package com.netcracker.edu.inventory.exception;

import com.netcracker.edu.inventory.model.Device;

public class DeviceValidationException extends RuntimeException{
    public DeviceValidationException(){
        super();
    }
    public DeviceValidationException(String operation) {
        super(operation !=null ? operation + " " + defaultMessage : defaultMessage);
    }

    public DeviceValidationException(String operation, Device device) {
        super(operation);
        this.device = device;
    }

    public final static String defaultMessage="Device is not valid for this operation";

    protected Device device;

    public Device getDevice() {
        return device;
    }
}
