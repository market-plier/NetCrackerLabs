package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.entity.impl.OpticFiber;
import com.netcracker.edu.inventory.model.connection.entity.impl.ThinCoaxial;
import com.netcracker.edu.inventory.model.connection.entity.impl.TwistedPair;
import com.netcracker.edu.inventory.model.connection.entity.impl.Wireless;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.NetworkElement;
import com.netcracker.edu.inventory.model.device.entity.impl.Battery;
import com.netcracker.edu.inventory.model.device.entity.impl.Router;
import com.netcracker.edu.inventory.model.device.entity.impl.Switch;
import com.netcracker.edu.inventory.model.device.entity.impl.WifiRouter;
import com.netcracker.edu.inventory.service.ConnectionService;
import com.netcracker.edu.inventory.service.DeviceService;
import com.netcracker.edu.inventory.service.RackService;
import com.netcracker.edu.inventory.service.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ServiceImpl implements Service {

    private final Logger logger = Logger.getLogger(ServiceImpl.class.getName());

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
