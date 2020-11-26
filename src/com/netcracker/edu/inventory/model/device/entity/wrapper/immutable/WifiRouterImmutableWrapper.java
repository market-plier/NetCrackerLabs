package com.netcracker.edu.inventory.model.device.entity.wrapper.immutable;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.device.entity.WifiRouter;
import com.netcracker.edu.inventory.model.device.entity.wrapper.WifiRouterWrapper;

import java.util.Date;
import java.util.Queue;
import java.util.logging.Level;

public class WifiRouterImmutableWrapper extends DeviceImmutableWrapper<WifiRouter> implements WifiRouter {

    public WifiRouterImmutableWrapper(WifiRouter wrappee) {
        super(wrappee);
        wifiRouterWrappee=wrappee;
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
        logger.log(Level.WARNING, "Can't change immutable connection");

    }

    @Override
    public Connection getWirelessConnection() {
        return wifiRouterWrappee.getWirelessConnection();
    }

    @Override
    public void setWirelessConnection(Connection wirelessConnection) {
        logger.log(Level.WARNING, "Can't change immutable connection");

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
        logger.log(Level.WARNING, "Can't change immutable connection");

    }

    @Override
    public int getDataRate() {
        return wifiRouterWrappee.getDataRate();
    }

    @Override
    public void setDataRate(int dataRate) {
        logger.log(Level.WARNING, "Can't change immutable connection");

    }
}