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
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

class DeviceServiceImpl implements DeviceService {

    private final Logger logger = Logger.getLogger(RackArrayImpl.class.getName());
    private IOService ioService = new IOServiceImpl();
    private DeviceArrayService arrayService = new DeviceArrayService();
    private DeviceCreateService createService = new DeviceCreateService();

    @Override
    public <T extends Device> T createDeviceInstance(Class<T> clazz) {
        if (clazz!=null && Device.class.isAssignableFrom(clazz)) {
            return createService.CreateDevice(clazz);
        }
        IllegalArgumentException exception = new IllegalArgumentException("Переданный аргумент не относится к семейству device");
        logger.log(Level.SEVERE,exception.getMessage(),exception);
        throw exception;
    }

    @Override
    public void sortByIN(Device[] devices) {
        arrayService.sortByIN(devices);
    }

    @Override
    public void sortByProductionDate(Device[] devices) {
        arrayService.sortByProductionDate(devices);
    }

    @Override
    public void filtrateByType(Device[] devices, String type) {
        arrayService.filtrateByType(devices, type);
    }

    @Override
    public void filtrateByManufacturer(Device[] devices, String manufacturer) {
       arrayService.filtrateByManufacturer(devices,manufacturer);
    }

    @Override
    public void filtrateByModel(Device[] devices, String model) {
       arrayService.filtrateByModel(devices,model);
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
