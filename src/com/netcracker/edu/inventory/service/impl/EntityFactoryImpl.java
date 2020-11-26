package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.model.NetworkElement;
import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.entity.OpticFiber;
import com.netcracker.edu.inventory.model.connection.entity.ThinCoaxial;
import com.netcracker.edu.inventory.model.connection.entity.TwistedPair;
import com.netcracker.edu.inventory.model.connection.entity.Wireless;
import com.netcracker.edu.inventory.model.connection.entity.wrapper.immutable.OpticFiberImmutableWrapper;
import com.netcracker.edu.inventory.model.connection.entity.wrapper.immutable.ThinCoaxialImmutableWrapper;
import com.netcracker.edu.inventory.model.connection.entity.wrapper.immutable.TwistedPairImmutableWrapper;
import com.netcracker.edu.inventory.model.connection.entity.wrapper.immutable.WirelessImmutableWrapper;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.device.entity.Battery;
import com.netcracker.edu.inventory.model.device.entity.Router;
import com.netcracker.edu.inventory.model.device.entity.Switch;
import com.netcracker.edu.inventory.model.device.entity.WifiRouter;
import com.netcracker.edu.inventory.model.device.entity.wrapper.immutable.BatteryImmutableWrapper;
import com.netcracker.edu.inventory.model.device.entity.wrapper.immutable.RouterImmutableWrapper;
import com.netcracker.edu.inventory.model.device.entity.wrapper.immutable.SwitchImmutableWrapper;
import com.netcracker.edu.inventory.model.device.entity.wrapper.immutable.WifiRouterImmutableWrapper;
import com.netcracker.edu.inventory.model.rack.Rack;
import com.netcracker.edu.inventory.model.rack.impl.RackArrayImpl;
import com.netcracker.edu.inventory.service.EntityFactory;

import java.beans.PropertyChangeListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EntityFactoryImpl implements EntityFactory {

    private final Logger logger = Logger.getLogger(EntityFactory.class.getName());
    @Override
    public NetworkElement createEmptyNetworkElementImpl(String className) throws IllegalArgumentException {
        Class clazz;
        try {
            clazz = Class.forName(className);
        }
        catch (Exception e){
            IllegalArgumentException ex = new IllegalArgumentException(e.getMessage());
            logger.log(Level.SEVERE,ex.getMessage(),ex);
            throw ex;
        }
        return createEmptyNetworkElementImpl(clazz);
    }

    @Override
    public <T extends NetworkElement> T createEmptyNetworkElementImpl(Class<T> clazz) throws IllegalArgumentException {
        if (clazz!=null && NetworkElement.class.isAssignableFrom(clazz)){
            if (Device.class.isAssignableFrom(clazz)){
                if (Battery.class.isAssignableFrom(clazz)) {
                    return (T) new com.netcracker.edu.inventory.model.device.entity.impl.Battery();
                }

                if (WifiRouter.class.isAssignableFrom(clazz)) {
                    return (T)new com.netcracker.edu.inventory.model.device.entity.impl.WifiRouter();
                }
                if (Switch.class.isAssignableFrom(clazz)) {
                    return (T)new com.netcracker.edu.inventory.model.device.entity.impl.Switch();
                }
                if (Router.class.isAssignableFrom(clazz)) {
                    return (T)new com.netcracker.edu.inventory.model.device.entity.impl.Router();
                }
            }
            else if (Connection.class.isAssignableFrom(clazz)){
                if (OpticFiber.class.isAssignableFrom(clazz)){
                    return (T)new com.netcracker.edu.inventory.model.connection.entity.impl.OpticFiber<>();
                }
                if (ThinCoaxial.class.isAssignableFrom(clazz)){
                    return (T)new com.netcracker.edu.inventory.model.connection.entity.impl.ThinCoaxial<>();
                }
                if (TwistedPair.class.isAssignableFrom(clazz)){
                    return  (T)new com.netcracker.edu.inventory.model.connection.entity.impl.TwistedPair<>();
                }
                if (Wireless.class.isAssignableFrom(clazz)){
                    return (T)new com.netcracker.edu.inventory.model.connection.entity.impl.Wireless<>();
                }
            }
        }
        IllegalArgumentException exception = new IllegalArgumentException("Переданный аргумент не относится к семейству device или connection");
        logger.log(Level.SEVERE,exception.getMessage(),exception);
        throw exception;
    }

    @Override
    public <T extends Device> Rack<T> createEmptyRackImpl(String name, int size, Class<T> limitation) throws IllegalArgumentException {
      if (name==null) {
          IllegalArgumentException ex = new IllegalArgumentException("Name is null");
          logger.log(Level.SEVERE, ex.getMessage(), ex);
          throw ex;
      }
      if (RackArrayImpl.class.getSimpleName().equals(name)){
          return new RackArrayImpl<>(size, limitation);
      }
        IllegalArgumentException ex = new IllegalArgumentException("Name is null");
        logger.log(Level.SEVERE, ex.getMessage(), ex);
        throw ex;
    }

    @Override
    public <T extends NetworkElement> T getImmutableNetworkElement(T original) throws IllegalArgumentException {

        if (original != null) {
            Class clazz = original.getClass();
            if (Device.class.isAssignableFrom(clazz)){
                if (Battery.class.isAssignableFrom(clazz)) {
                    return (T)new BatteryImmutableWrapper((Battery)original);
                }

                if (WifiRouter.class.isAssignableFrom(clazz)) {
                    return (T)new WifiRouterImmutableWrapper((WifiRouter) original);
                }
                if (Switch.class.isAssignableFrom(clazz)) {
                    return (T)new SwitchImmutableWrapper((Switch)original);
                }
                if (Router.class.isAssignableFrom(clazz)) {
                    return (T)new RouterImmutableWrapper((Router)original);
                }
            }
            else if (Connection.class.isAssignableFrom(clazz)){
                if (OpticFiber.class.isAssignableFrom(clazz)){
                    return (T)new OpticFiberImmutableWrapper((OpticFiber)original);                }
                if (ThinCoaxial.class.isAssignableFrom(clazz)){
                    return (T)new ThinCoaxialImmutableWrapper((ThinCoaxial) original);                }
                if (TwistedPair.class.isAssignableFrom(clazz)){
                    return (T)new TwistedPairImmutableWrapper<>((TwistedPair)original);                }
                if (Wireless.class.isAssignableFrom(clazz)){
                    return (T)new WirelessImmutableWrapper((Wireless)original);                }
            }
        }
        IllegalArgumentException exception = new IllegalArgumentException("Переданный объект не относится к семейству device или connection");
        logger.log(Level.SEVERE,exception.getMessage(),exception);
        throw exception;
    }

    @Override
    public <D extends Device> Rack<D> getImmutableRack(Rack<D> original) throws IllegalArgumentException {
        return null;
    }

    @Override
    public <T extends NetworkElement> T subscribeTo(T original, PropertyChangeListener listener) throws IllegalArgumentException {
        return null;
    }

    @Override
    public <D extends Device> Rack<D> subscribeTo(Rack<D> original, PropertyChangeListener listener) throws IllegalArgumentException {
        return null;
    }

    @Override
    public boolean unsubscribeFrom(NetworkElement publisher, PropertyChangeListener listener) throws IllegalArgumentException {
        return false;
    }

    @Override
    public boolean unsubscribeFrom(Rack publisher, PropertyChangeListener listener) throws IllegalArgumentException {
        return false;
    }
}
