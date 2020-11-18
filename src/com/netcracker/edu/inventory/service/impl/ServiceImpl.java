package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.model.Connection;
import com.netcracker.edu.inventory.model.Device;
import com.netcracker.edu.inventory.model.NetworkElement;
import com.netcracker.edu.inventory.model.impl.*;
import com.netcracker.edu.inventory.service.ConnectionService;
import com.netcracker.edu.inventory.service.DeviceService;
import com.netcracker.edu.inventory.service.RackService;
import com.netcracker.edu.inventory.service.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ServiceImpl implements Service {

    private final Logger logger = Logger.getLogger(ServiceImpl.class.getName());

    @Deprecated
    @Override
    public void sortByIN(Device[] devices) {
        getDeviceService().sortByIN(devices);
    }

    @Deprecated
    @Override
    public void sortByProductionDate(Device[] devices) {
        getDeviceService().sortByProductionDate(devices);
    }

    @Deprecated
    @Override
    public void filtrateByType(Device[] devices, String type) {
        getDeviceService().filtrateByType(devices,type);
    }

    @Deprecated
    @Override
    public void filtrateByManufacturer(Device[] devices, String manufacturer) {
       getDeviceService().filtrateByManufacturer(devices, manufacturer);
    }

    @Deprecated
    @Override
    public void filtrateByModel(Device[] devices, String model) {
       getDeviceService().filtrateByModel(devices,model);
    }

    @Deprecated
    @Override
    public boolean isValidDeviceForInsertToRack(Device device) {
        return getDeviceService().isValidDeviceForInsertToRack(device);
    }

    @Override
    public DeviceService getDeviceService() {
        return DeviceServiceImpl.getDeviceService();
    }

    @Override
    public ConnectionService getConnectionService() {
        return ConnectionServiceImpl.getConnectionService();
    }

    @Override
    public RackService getRackService() {
        return RackServiceImpl.getRackService();
    }

    @Override
    public <T extends NetworkElement> T createNEInstance(Class<T> clazz) {
        if (clazz!=null && NetworkElement.class.isAssignableFrom(clazz)){
            if (Device.class.isAssignableFrom(clazz)){
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
            else if (Connection.class.isAssignableFrom(clazz)){
                if (OpticFiber.class.isAssignableFrom(clazz)){
                    return (T) new OpticFiber<>();
                }
                if (ThinCoaxial.class.isAssignableFrom(clazz)){
                    return (T) new ThinCoaxial<>();
                }
                if (TwistedPair.class.isAssignableFrom(clazz)){
                    return  (T) new TwistedPair<>();
                }
                if (Wireless.class.isAssignableFrom(clazz)){
                    return (T) new Wireless<>();
                }
            }
        }
        IllegalArgumentException exception = new IllegalArgumentException("Переданный аргумент не относится к семейству device или connection");
        logger.log(Level.SEVERE,exception.getMessage(),exception);
        throw exception;
    }
}
