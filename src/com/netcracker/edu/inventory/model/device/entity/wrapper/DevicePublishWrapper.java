package com.netcracker.edu.inventory.model.device.entity.wrapper;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.device.entity.AllDevices;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Flow;

public class DevicePublishWrapper<T extends Device> extends AbstractDeviceWrapper  {

    protected List<PropertyChangeListener> listeners;
    
    public DevicePublishWrapper(T device) {
        super(device);
        listeners = new ArrayList<>();

    }

    public void subscribe(PropertyChangeListener listener) {
        listeners.add(listener);
    }

    public boolean unsubscribe(PropertyChangeListener listener) {
        return listeners.remove(listener);
    }

    private void notifyListeners(Object source,String propertyName,Object oldValue,Object newValue){
        for (PropertyChangeListener listener: listeners) {
            listener.propertyChange(new PropertyChangeEvent(source, propertyName, oldValue, newValue));
        }
    }

    @Override
    public void setIn(int in) {
        notifyListeners(this,"in",getIn(),in);
        super.setIn(in);
    }

    @Override
    public void setType(String type) {
        notifyListeners(this,"type",super.getType(),type);
        super.setType(type);
    }


    @Override
    public void setManufacturer(String manufacturer) {
        notifyListeners(this, "manufacturer", super.getManufacturer(), manufacturer);
        super.setManufacturer(manufacturer);
    }

    @Override
    public void setModel(String model) {
        notifyListeners(this, "model", super.getModel(), model);
        super.setModel(model);
    }


    @Override
    public void setProductionDate(Date productionDate) {
        notifyListeners(this, "productionDate", super.getProductionDate(), productionDate);
        super.setProductionDate(productionDate);
    }


    @Override
    public void setChargeVolume(int chargeVolume) {
        notifyListeners(this, "chargeVolume", super.getChargeVolume(), chargeVolume);
        super.setChargeVolume(chargeVolume);
    }

    @Override
    public void setNumberOfPorts(int numberOfPorts) {
        notifyListeners(this, "numberOfPorts", super.getNumberOfPorts(), numberOfPorts);
        super.setNumberOfPorts(numberOfPorts);
    }

    @Override
    public void setPortConnection(Connection connection, int portNumber) {
        notifyListeners(this, "portConnection", super.getPortConnection(portNumber), connection);
        super.setPortConnection(connection,portNumber);
    }

    @Override
    public void setSecurityProtocol(String securityProtocol) {
        notifyListeners(this, "securityProtocol", super.getSecurityProtocol(), securityProtocol);

        super.setSecurityProtocol(securityProtocol);
    }

    @Override
    public void setWirelessConnection(Connection wirelessConnection) {
        notifyListeners(this, "wirelessConnection", super.getWirelessConnection(), wirelessConnection);

        super.setWirelessConnection(wirelessConnection);
    }

    @Override
    public void setWireConnection(Connection wireConnection) {
        notifyListeners(this, "wireConnection", super.getWireConnection(), wireConnection);

        super.setWireConnection(wireConnection);
    }


    @Override
    public void setDataRate(int dataRate) {
        notifyListeners(this, "dataRate", super.getDataRate(), dataRate);

        super.setDataRate(dataRate);
    }
}
