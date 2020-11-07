package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.exception.DeviceValidationException;
import com.netcracker.edu.inventory.model.Device;
import com.netcracker.edu.inventory.model.impl.*;
import com.netcracker.edu.inventory.service.DeviceService;
import com.netcracker.edu.io.IOService;
import com.netcracker.edu.io.impl.IOServiceImpl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

class DeviceServiceImpl implements DeviceService {

    private final Logger logger = Logger.getLogger(RackArrayImpl.class.getName());
    private final IOService ioService = new IOServiceImpl();
    private final DeviceSortService sortService = new DeviceSortService();
    private final DeviceCreateService createService = new DeviceCreateService();
    private final DeviceFiltrateService filtrateService = new DeviceFiltrateService();

    @Override
    public <T extends Device> T createDeviceInstance(Class<T> clazz) {
        T device = createService.CreateDevice(clazz);
        if (device != null) {
            return device;
        }
        IllegalArgumentException exception = new IllegalArgumentException("Переданный аргумент не относится к семейству device");
        logger.log(Level.SEVERE,exception.getMessage(),exception);
        throw exception;
    }

    @Override
    public void sortByIN(Device[] devices) {
        sortService.sortByIN(devices);
    }

    @Override
    public void sortByProductionDate(Device[] devices) {
        sortService.sortByProductionDate(devices);
    }

    @Override
    public void filtrateByType(Device[] devices, String type) {
        filtrateService.filtrateByType(devices, type);
    }

    @Override
    public void filtrateByManufacturer(Device[] devices, String manufacturer) {
       filtrateService.filtrateByManufacturer(devices,manufacturer);
    }

    @Override
    public void filtrateByModel(Device[] devices, String model) {
       filtrateService.filtrateByModel(devices,model);
    }

    @Override
    public boolean isValidDeviceForInsertToRack(Device device) {
        return createService.isValidDeviceForInsertToRack(device);
    }

    @Override
    public boolean isValidDeviceForOutputToStream(Device device) {
        return ioService.isValidEntityForOutputToStream(device);
    }

    @Override
    public void outputDevice(Device device, OutputStream outputStream) throws IOException {
        if (!isValidDeviceForOutputToStream(device)){
            DeviceValidationException exception=new DeviceValidationException("DeviceService.outputDevice");
            logger.log(Level.SEVERE,exception.getMessage(),exception);
            throw exception;
        }
    ioService.outputFillableEntity(device,outputStream);
    }

    @Override
    public Device inputDevice(InputStream inputStream) throws IOException, ClassNotFoundException {
        return (Device) ioService.inputFillableEntity(inputStream);
    }
}
