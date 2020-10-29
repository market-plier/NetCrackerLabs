package com.netcracker.edu.inventory.exception;

import com.netcracker.edu.inventory.model.Device;

public class DeviceValidationException extends RuntimeException {

    public final static String defaultMessage = "Device is not valid for operation";

    private Device device;

    public DeviceValidationException() {
        super();
    }

    public DeviceValidationException(String operation) {
        super((operation != null) ? (defaultMessage + " " + operation) : defaultMessage);
    }

    public DeviceValidationException(String operation, Device device) {
        this(operation);
        this.device = device;
    }

    public Device getDevice() {
        return device;
    }
}
