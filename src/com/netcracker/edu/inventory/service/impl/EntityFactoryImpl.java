package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.model.NetworkElement;
import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.entity.OpticFiber;
import com.netcracker.edu.inventory.model.connection.entity.ThinCoaxial;
import com.netcracker.edu.inventory.model.connection.entity.TwistedPair;
import com.netcracker.edu.inventory.model.connection.entity.Wireless;
import com.netcracker.edu.inventory.model.connection.entity.wrapper.*;
import com.netcracker.edu.inventory.model.connection.entity.wrapper.implementations.ConnectionImmutableWrapper;
import com.netcracker.edu.inventory.model.connection.entity.wrapper.implementations.ConnectionPublishWrapper;
import com.netcracker.edu.inventory.model.connection.entity.wrapper.implementations.ConnectionSynchronizedWrapper;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.device.entity.Battery;
import com.netcracker.edu.inventory.model.device.entity.Router;
import com.netcracker.edu.inventory.model.device.entity.Switch;
import com.netcracker.edu.inventory.model.device.entity.WifiRouter;
import com.netcracker.edu.inventory.model.device.entity.wrapper.*;
import com.netcracker.edu.inventory.model.device.entity.wrapper.implementations.DeviceImmutableWrapper;
import com.netcracker.edu.inventory.model.device.entity.wrapper.implementations.DevicePublishWrapper;
import com.netcracker.edu.inventory.model.device.entity.wrapper.implementations.DeviceSynchronizedWrapper;
import com.netcracker.edu.inventory.model.rack.Rack;
import com.netcracker.edu.inventory.model.rack.impl.RackArrayImpl;
import com.netcracker.edu.inventory.model.rack.wrapper.RackImmutableWrapper;
import com.netcracker.edu.inventory.model.rack.wrapper.RackPublishWrapper;
import com.netcracker.edu.inventory.model.rack.wrapper.RackSynchronizedWrapper;
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
                    return (T)new BatteryWrapper(new DeviceImmutableWrapper<>((Battery)original));
                }
                if (WifiRouter.class.isAssignableFrom(clazz)) {
                    return (T)new WifiRouterWrapper(new DeviceImmutableWrapper<>((WifiRouter)original));
                }
                if (Switch.class.isAssignableFrom(clazz)) {
                    return (T)new SwitchWrapper(new DeviceImmutableWrapper<>((Switch)original));
                }
                if (Router.class.isAssignableFrom(clazz)) {
                    return (T)new RouterWrapper(new DeviceImmutableWrapper<>((Router)original));
                }
            }
            else if (Connection.class.isAssignableFrom(clazz)){
                if (OpticFiber.class.isAssignableFrom(clazz)){
                    return (T)new OpticFiberWrapper(new ConnectionImmutableWrapper((OpticFiber)original));
                }
                if (ThinCoaxial.class.isAssignableFrom(clazz)){
                    return (T)new ThinCoaxialWrapper(new ConnectionImmutableWrapper((ThinCoaxial)original));
                }
                if (TwistedPair.class.isAssignableFrom(clazz)){
                    return (T)new TwistedPairWrapper(new ConnectionImmutableWrapper((TwistedPair)original));
                }
                if (Wireless.class.isAssignableFrom(clazz)){
                    return (T)new WirelessWrapper(new ConnectionImmutableWrapper((Wireless)original));
                }
            }
        }
        IllegalArgumentException exception = new IllegalArgumentException("Переданный объект не относится к семейству device или connection");
        logger.log(Level.SEVERE,exception.getMessage(),exception);
        throw exception;
    }

    @Override
    public <D extends Device> Rack<D> getImmutableRack(Rack<D> original) throws IllegalArgumentException {
        return new RackImmutableWrapper<D>(original);
    }

    @Override
    public <T extends NetworkElement> T getSynchronizedNetworkElement(T original) throws IllegalArgumentException {

        if (original != null) {
            Class clazz = original.getClass();
            if (Device.class.isAssignableFrom(clazz)){
                if (Battery.class.isAssignableFrom(clazz)) {
                    return (T)new BatteryWrapper(new DeviceSynchronizedWrapper((Battery)original));
                }
                if (WifiRouter.class.isAssignableFrom(clazz)) {
                    return (T)new WifiRouterWrapper(new DeviceSynchronizedWrapper((WifiRouter)original));
                }
                if (Switch.class.isAssignableFrom(clazz)) {
                    return (T)new SwitchWrapper(new DeviceSynchronizedWrapper((Switch)original));
                }
                if (Router.class.isAssignableFrom(clazz)) {
                    return (T)new RouterWrapper(new DeviceSynchronizedWrapper((Router)original));
                }
            }
            else if (Connection.class.isAssignableFrom(clazz)){
                if (OpticFiber.class.isAssignableFrom(clazz)){
                    return (T)new OpticFiberWrapper(new ConnectionSynchronizedWrapper((OpticFiber)original));
                }
                if (ThinCoaxial.class.isAssignableFrom(clazz)){
                    return (T)new ThinCoaxialWrapper(new ConnectionSynchronizedWrapper((ThinCoaxial)original));
                }
                if (TwistedPair.class.isAssignableFrom(clazz)){
                    return (T)new TwistedPairWrapper(new ConnectionSynchronizedWrapper((TwistedPair)original));
                }
                if (Wireless.class.isAssignableFrom(clazz)){
                    return (T)new WirelessWrapper(new ConnectionSynchronizedWrapper((Wireless)original));
                }
            }
        }
        IllegalArgumentException exception = new IllegalArgumentException("Переданный объект не относится к семейству device или connection");
        logger.log(Level.SEVERE,exception.getMessage(),exception);
        throw exception;
    }

    @Override
    public <D extends Device> Rack<D> getSynchronizedRack(Rack<D> original) throws IllegalArgumentException {
        return new RackSynchronizedWrapper<>(original);
    }

    @Override
    public <T extends NetworkElement> T subscribeTo(T original, PropertyChangeListener listener) throws IllegalArgumentException {
        if (original != null && listener!=null) {
            Class clazz = original.getClass();
            if (Device.class.isAssignableFrom(clazz)){
                if (DeviceWrapper.class.isAssignableFrom(clazz)){
                    ((DevicePublishWrapper)((DeviceWrapper)original).getWrapper()).subscribe(listener);
                    return original;
                }
                if (Battery.class.isAssignableFrom(clazz)) {
                    BatteryWrapper  wrapper =new BatteryWrapper(new DevicePublishWrapper<>((Battery)original));
                    ((DevicePublishWrapper)wrapper.getWrapper()).subscribe(listener);
                    return (T)wrapper;
                }

                if (WifiRouter.class.isAssignableFrom(clazz)) {
                    WifiRouterWrapper  wrapper =new WifiRouterWrapper(new DevicePublishWrapper<>((WifiRouter)original));
                    ((DevicePublishWrapper)wrapper.getWrapper()).subscribe(listener);
                    return (T)wrapper;
                }
                if (Switch.class.isAssignableFrom(clazz)) {
                    SwitchWrapper wrapper =new SwitchWrapper(new DevicePublishWrapper<>((Switch)original));
                    ((DevicePublishWrapper)wrapper.getWrapper()).subscribe(listener);
                    return (T)wrapper;
                }
                if (Router.class.isAssignableFrom(clazz)) {
                    RouterWrapper  wrapper =new RouterWrapper(new DevicePublishWrapper<>((Router)original));
                    ((DevicePublishWrapper)wrapper.getWrapper()).subscribe(listener);
                    return (T)wrapper;
                }
            }
            else if (Connection.class.isAssignableFrom(clazz)){
                if (ConnectionWrapper.class.isAssignableFrom(clazz)){
                    ((ConnectionPublishWrapper)((ConnectionWrapper)original).getWrapper()).addListeners(listener);
                    return original;
                }
                if (OpticFiber.class.isAssignableFrom(clazz)){
                    OpticFiberWrapper wrapper =new OpticFiberWrapper(new ConnectionPublishWrapper<>((OpticFiber) original));
                    ((ConnectionPublishWrapper)wrapper.getWrapper()).addListeners(listener);
                    return (T)wrapper;
                }
                if (ThinCoaxial.class.isAssignableFrom(clazz)){
                    ThinCoaxialWrapper wrapper =new ThinCoaxialWrapper(new ConnectionPublishWrapper<>((ThinCoaxial) original));
                    ((ConnectionPublishWrapper)wrapper.getWrapper()).addListeners(listener);
                    return (T)wrapper;
                }
                if (TwistedPair.class.isAssignableFrom(clazz)){
                    TwistedPairWrapper wrapper =new TwistedPairWrapper(new ConnectionPublishWrapper<>((TwistedPair) original));
                    ((ConnectionPublishWrapper)wrapper.getWrapper()).addListeners(listener);
                    return (T)wrapper;
                }
                if (Wireless.class.isAssignableFrom(clazz)){
                    WirelessWrapper wrapper =new WirelessWrapper(new ConnectionPublishWrapper<>((Wireless) original));
                    ((ConnectionPublishWrapper)wrapper.getWrapper()).addListeners(listener);
                    return (T)wrapper;
                }
            }
        }
        IllegalArgumentException exception = new IllegalArgumentException("Переданный объект не относится к семейству device или connection");
        logger.log(Level.SEVERE,exception.getMessage(),exception);
        throw exception;
    }

    @Override
    public <D extends Device> Rack<D> subscribeTo(Rack<D> original, PropertyChangeListener listener) throws IllegalArgumentException {
        if (original!=null) {
            if (RackPublishWrapper.class.isAssignableFrom(original.getClass())) {
                ((RackPublishWrapper<D>) original).subscribe(listener);
                return original;
            }
            return new RackPublishWrapper<>(original, listener);
        }
        IllegalArgumentException exception = new IllegalArgumentException("Переданный объект не относится к семейству device или connection");
        logger.log(Level.SEVERE,exception.getMessage(),exception);
        throw exception;
    }

    @Override
    public boolean unsubscribeFrom(NetworkElement publisher, PropertyChangeListener listener) throws IllegalArgumentException {
        if (publisher!= null) {
            if (ConnectionWrapper.class.isAssignableFrom(publisher.getClass())) {
                if (ConnectionPublishWrapper.class.isAssignableFrom(((ConnectionWrapper)publisher).getWrapper().getClass())){
                    return ((ConnectionPublishWrapper) ((ConnectionWrapper)publisher).getWrapper()).removeListeners(listener);
                }
            } else if (DeviceWrapper.class.isAssignableFrom(publisher.getClass())) {
                if (DevicePublishWrapper.class.isAssignableFrom(((DeviceWrapper)publisher).getWrapper().getClass()))
                return ((DevicePublishWrapper) ((DeviceWrapper)publisher).getWrapper()).unsubscribe(listener);
            }
        }
        IllegalArgumentException exception = new IllegalArgumentException("Переданный объект не относится к семейству device или connection");
        logger.log(Level.SEVERE,exception.getMessage(),exception);
        throw exception;
    }

    @Override
    public boolean unsubscribeFrom(Rack publisher, PropertyChangeListener listener) throws IllegalArgumentException {
        if (publisher!=null) {
            if (RackPublishWrapper.class.isAssignableFrom(publisher.getClass())) {
                return ((RackPublishWrapper) publisher).unsubscribe(listener);
            }
        }
        IllegalArgumentException exception = new IllegalArgumentException("Переданный объект не относится к rackpublishwrapper");
        logger.log(Level.SEVERE,exception.getMessage(),exception);
        throw exception;
    }
}
