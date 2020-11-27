package com.netcracker.edu.inventory.model.device.entity.wrapper.publish;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.device.entity.WifiRouter;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class WifiRouterPublishWrapper extends DevicePublishWrapper<WifiRouter> implements WifiRouter {

    public WifiRouterPublishWrapper(WifiRouter device, PropertyChangeListener listener) {
        super(device, listener);
        wifiRouterWrappee=device;
    }

    @Override
    public String getTechnologyVersion() {
        return wifiRouterWrappee.getTechnologyVersion();
    }

    @Override
    public String getSecurityProtocol() {
        return wifiRouterWrappee.getSecurityProtocol();
    }

    @Override
    public void setSecurityProtocol(String securityProtocol) {
        for (PropertyChangeListener listener: listeners) {
            listener.propertyChange(new PropertyChangeEvent(this, "securityProtocol", wifiRouterWrappee.getSecurityProtocol(), securityProtocol));
        }
        wifiRouterWrappee.setSecurityProtocol(securityProtocol);
    }

    @Override
    public Connection getWirelessConnection() {
        return wifiRouterWrappee.getWirelessConnection();
    }

    @Override
    public void setWirelessConnection(Connection wirelessConnection) {
        for (PropertyChangeListener listener: listeners) {
            listener.propertyChange(new PropertyChangeEvent(this, "wirelessConnection", wifiRouterWrappee.getWirelessConnection(), wirelessConnection));
        }
        wifiRouterWrappee.setWirelessConnection(wirelessConnection);
    }

    @Override
    public ConnectorType getWirePortType() {
        return wifiRouterWrappee.getWirePortType();
    }

    @Override
    public Connection getWireConnection() {
        return wifiRouterWrappee.getWireConnection();
    }

    @Override
    public void setWireConnection(Connection wireConnection) {
        for (PropertyChangeListener listener: listeners) {
            listener.propertyChange(new PropertyChangeEvent(this, "wireConnection", wifiRouterWrappee.getWireConnection(), wireConnection));
        }
        wifiRouterWrappee.setWireConnection(wireConnection);
    }

    @Override
    public int getDataRate() {
        return wifiRouterWrappee.getDataRate();
    }

    @Override
    public void setDataRate(int dataRate) {
        for (PropertyChangeListener listener: listeners) {
            listener.propertyChange(new PropertyChangeEvent(this, "dataRate", wifiRouterWrappee.getDataRate(), dataRate));
        }
    }
}
