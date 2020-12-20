package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.exception.DeviceValidationException;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.device.DevicePrimaryKey;
import com.netcracker.edu.inventory.service.DeviceService;
import com.netcracker.edu.io.IOService;
import com.netcracker.edu.io.impl.IOServiceImpl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

class DeviceServiceImpl implements DeviceService {

    private static DeviceService deviceService=null;
    private final Logger logger = Logger.getLogger(DeviceServiceImpl.class.getName());
    private final IOService ioService = new IOServiceImpl();
    private final DeviceFiltrateService filtrateService = new DeviceFiltrateService();
    private final RDBProvider provider = new RDBProvider();
    public static DeviceService getDeviceService() {

        if (deviceService == null) {
            deviceService = new DeviceServiceImpl();
        }
        return deviceService;
    }

    @Override
    public void sortByIN(Device[] devices) {
        Arrays.sort(devices,new DeviceInComparator());
    }

    @Override
    public void sortByProductionDate(Device[] devices) {
        if (devices != null) {
            Arrays.sort(devices, new DeviceDateComparator());
        }
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
        if (device == null) {
            return false;
        }
        return device.getIn() > 0 && !device.isLazy();
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

    @Override
    public Device getDeviceFromDB(Connection dbConnection, DevicePrimaryKey dpk) throws SQLException {
        return provider.getDeviceFromDB(dbConnection,dpk);
    }

    @Override
    public boolean putDeviceToDB(Connection dbConnection, Device device) throws SQLException {
        return provider.putDeviceToDB(dbConnection,device);
    }

    @Override
    public boolean removeDeviceFromDB(Connection dbConnection, DevicePrimaryKey dpk) throws SQLException {
        return provider.removeDeviceFromDB(dbConnection, dpk);
    }
}
