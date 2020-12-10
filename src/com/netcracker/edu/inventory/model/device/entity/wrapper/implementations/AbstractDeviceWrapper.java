package com.netcracker.edu.inventory.model.device.entity.wrapper.implementations;

import com.netcracker.edu.inventory.model.AbstractNetworkElementWrapper;
import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.device.entity.*;

import java.util.Date;
import java.util.List;

public class AbstractDeviceWrapper extends AbstractNetworkElementWrapper<Device> implements AllDevices {

    Device device;
    Battery battery;
    Router router;
    Switch aSwitch;
    WifiRouter wifiRouter;

    public AbstractDeviceWrapper(Device device) {
        super(device);
        this.device = device;
        if (device instanceof Battery){
            battery=(Battery) device;
        }
        if (device instanceof Switch){
            aSwitch = (Switch) device;
        }
        if (device instanceof  WifiRouter){
            wifiRouter = (WifiRouter) device;
        }
        if (device instanceof Router){
            router = (Router)device;
        }
    }

    @Override
    public int getChargeVolume() {
        return battery.getChargeVolume();
    }

    @Override
    public void setChargeVolume(int chargeVolume) {
        battery.setChargeVolume(chargeVolume);
    }

    @Override
    public int getNumberOfPorts() {
        return aSwitch.getNumberOfPorts();
    }

    @Override
    public void setNumberOfPorts(int numberOfPorts) {
        aSwitch.setNumberOfPorts(numberOfPorts);
    }

    @Override
    public ConnectorType getPortsType() {
        return aSwitch.getPortsType();
    }

    @Override
    public Connection getPortConnection(int portNumber) {
        return aSwitch.getPortConnection(portNumber);
    }

    @Override
    public void setPortConnection(Connection connection, int portNumber) {
        aSwitch.setPortConnection(connection,portNumber);
    }

    @Override
    public List<Connection> getAllPortConnections() {
        return aSwitch.getAllPortConnections();
    }

    @Override
    public String getTechnologyVersion() {
        return wifiRouter.getTechnologyVersion();
    }

    @Override
    public String getSecurityProtocol() {
        return wifiRouter.getSecurityProtocol();
    }

    @Override
    public void setSecurityProtocol(String securityProtocol) {
        wifiRouter.setSecurityProtocol(securityProtocol);
    }

    @Override
    public Connection getWirelessConnection() {
        return wifiRouter.getWirelessConnection();
    }

    @Override
    public void setWirelessConnection(Connection wirelessConnection) {
        wifiRouter.setWirelessConnection(wirelessConnection);
    }

    @Override
    public ConnectorType getWirePortType() {
        return wifiRouter.getWirePortType();
    }

    @Override
    public Connection getWireConnection() {
        return wifiRouter.getWireConnection();
    }

    @Override
    public void setWireConnection(Connection wireConnection) {
        wifiRouter.setWireConnection(wireConnection);
    }

    @Override
    public int getDataRate() {
        return router.getDataRate();
    }

    @Override
    public void setDataRate(int dataRate) {
        router.setDataRate(dataRate);
    }

    @Override
    public int getIn() {
        return device.getIn();
    }

    @Override
    public void setIn(int in) {
        device.setIn(in);
    }

    @Override
    public String getType() {
        return device.getType();
    }

    @Override
    public void setType(String type) {
        device.setType(type);
    }

    @Override
    public String getManufacturer() {
        return device.getManufacturer();
    }

    @Override
    public void setManufacturer(String manufacturer) {
        device.setManufacturer(manufacturer);
    }

    @Override
    public String getModel() {
        return device.getModel();
    }

    @Override
    public void setModel(String model) {
        device.setModel(model);
    }

    @Override
    public Date getProductionDate() {
        return device.getProductionDate();
    }

    @Override
    public void setProductionDate(Date productionDate) {
        device.setProductionDate(productionDate);
    }

}
