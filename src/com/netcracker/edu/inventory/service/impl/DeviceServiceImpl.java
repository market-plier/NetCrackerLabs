package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.exception.DeviceValidationException;
import com.netcracker.edu.inventory.model.Device;
import com.netcracker.edu.inventory.model.FillableEntity;
import com.netcracker.edu.inventory.model.impl.*;
import com.netcracker.edu.inventory.service.DeviceService;
import com.netcracker.edu.io.IOService;
import com.netcracker.edu.io.impl.IOServiceImpl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

class DeviceServiceImpl implements DeviceService {

    private final Logger logger = Logger.getLogger(RackArrayImpl.class.getName());
    private IOService service = new IOServiceImpl();

    @Override
    public <T extends Device> T createDeviceInstance(Class<T> clazz) {

        if (clazz!=null && Device.class.isAssignableFrom(clazz)) {
            if (clazz.isAssignableFrom(Battery.class)) {
                return (T) new Battery();
            }
            if (clazz.isAssignableFrom(Router.class)) {
                return (T) new Router();
            }

            if (WifiRouter.class.isAssignableFrom(clazz)) {
                return (T) new WifiRouter();
            }

            if (Switch.class.isAssignableFrom(clazz)) {
                return (T) new Switch();
            }
        }
        IllegalArgumentException exception = new IllegalArgumentException("Переданный аргумент не относится к семейству device");
        logger.log(Level.SEVERE,exception.getMessage(),exception);
        throw exception;
    }

    @Override
    public void sortByIN(Device[] devices) {
        if (devices != null) {
            Arrays.sort(devices, new DeviceInComparator());
        }
    }

    @Override
    public void sortByProductionDate(Device[] devices) {
        if (devices != null) {
            Arrays.sort(devices, new DeviceDateComparator());

        }
    }

    @Override
    public void filtrateByType(Device[] devices, String type) {
        if (devices != null) {
            for (int i = 0; i < devices.length; i++) {
                if (devices[i] != null) {
                    if (devices[i].getType() != null && type != null) {
                        if (type.compareTo(devices[i].getType()) != 0) {
                            devices[i] = null;
                        }
                    } else if (devices[i].getType() != type) {
                        devices[i] = null;
                    }
                }
            }
        }
    }

    @Override
    public void filtrateByManufacturer(Device[] devices, String manufacturer) {
        if (devices != null) {
            for (int i = 0; i < devices.length; i++) {
                if (devices[i] != null) {
                    if (devices[i].getManufacturer() != null && manufacturer != null) {
                        if (manufacturer.compareTo(devices[i].getManufacturer()) != 0) {
                            devices[i] = null;
                        }
                    } else if (devices[i].getManufacturer() != manufacturer) {
                        devices[i] = null;
                    }

                }
            }
        }
    }

    @Override
    public void filtrateByModel(Device[] devices, String model) {
        if (devices != null) {
            for (int i = 0; i < devices.length; i++) {
                if (devices[i] != null) {
                    if (devices[i].getModel() != null && model != null) {
                        if (model.compareTo(devices[i].getModel()) != 0) {
                            devices[i] = null;
                        }
                    } else if (devices[i].getModel() != model) {
                        devices[i] = null;
                    }
                }
            }
        }
    }

    @Override
    public boolean isValidDeviceForInsertToRack(Device device) {
        if (device == null) {
            return false;
        }
        return device.getIn() > 0;
    }

    @Override
    public boolean isValidDeviceForOutputToStream(Device device) {
        return service.isValidEntityForOutputToStream(device);
    }

    @Override
    public void outputDevice(Device device, OutputStream outputStream) throws IOException {
        if (!isValidDeviceForOutputToStream(device)){
            DeviceValidationException exception=new DeviceValidationException("DeviceService.outputDevice");
            logger.log(Level.SEVERE,exception.getMessage(),exception);
            throw exception;
        }
    service.outputFillableEntity(device,outputStream);
    }

    @Override
    public Device inputDevice(InputStream inputStream) throws IOException, ClassNotFoundException {
        return (Device) service.inputFillableEntity(inputStream);
    }
}
