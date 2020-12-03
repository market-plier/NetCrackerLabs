package com.netcracker.edu.inventory.model.connection.entity.wrapper;

import com.netcracker.edu.inventory.model.AbstractNetworkElementWrapper;
import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.connection.OneToOneConnection;
import com.netcracker.edu.inventory.model.connection.entity.*;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.location.Trunk;

import java.util.List;
import java.util.Set;

public class AbstractConnectionWrapper<A extends Device,B extends Device> extends AbstractNetworkElementWrapper<Connection> implements AllConnections<A,B> {

    protected Connection<A,B> connection;
    protected OpticFiber<A,B> opticFiber;
    protected ThinCoaxial<A> thinCoaxial;
    protected TwistedPair<A,B> twistedPair;
    protected Wireless<A,B> wireless;
    protected OneToOneConnection<A,B> oneToOneConnection;

    public AbstractConnectionWrapper(Connection<A,B> connection) {
        super(connection);
        this.connection=connection;
        if (connection instanceof OpticFiber){
            opticFiber=(OpticFiber<A,B>) connection;
            oneToOneConnection = (OneToOneConnection<A,B>) connection;
        }
        if (connection instanceof ThinCoaxial){
            thinCoaxial=(ThinCoaxial<A>) connection;
        }
        if (connection instanceof TwistedPair){
            twistedPair=(TwistedPair<A,B>) connection;
            oneToOneConnection = (OneToOneConnection<A,B>) connection;
        }
        if (connection instanceof Wireless){
            wireless = (Wireless<A,B>) connection;
        }
    }

    @Override
    public List<B> getBPoints() {
        return wireless.getBPoints();
    }

    @Override
    public void setBPoints(List<B> devices) {
        wireless.setBPoints(devices);
    }

    @Override
    public int getBCapacity() {
        return wireless.getBCapacity();
    }

    @Override
    public B getBPoint(int deviceNumber) {
        return wireless.getBPoint(deviceNumber);
    }

    @Override
    public void setBPoint(B device, int deviceNumber) {
        wireless.setBPoint(device, deviceNumber);
    }

    @Override
    public Mode getMode() {
        return opticFiber.getMode();
    }

    @Override
    public Type getType() {
        return twistedPair.getType();
    }

    @Override
    public int getLength() {
        if (connection instanceof OpticFiber )
            return opticFiber.getLength();
        else
            return twistedPair.getLength();
    }

    @Override
    public void setLength(int length) {
        if (connection instanceof OpticFiber )
            opticFiber.setLength(length);
else
            twistedPair.setLength(length);
    }

    @Override
    public String getTechnology() {
        return wireless.getTechnology();
    }

    @Override
    public String getProtocol() {
        return wireless.getProtocol();
    }

    @Override
    public void setProtocol(String protocol) {
        wireless.setProtocol(protocol);
    }

    @Override
    public int getVersion() {
        return wireless.getVersion();
    }

    @Override
    public void setVersion(int version) {
        wireless.setVersion(version);
    }

    @Override
    public Trunk getTrunk() {
        return connection.getTrunk();
    }

    @Override
    public void setTrunk(Trunk trunk) {
        connection.setTrunk(trunk);
    }

    @Override
    public int getSerialNumber() {
        return connection.getSerialNumber();
    }

    @Override
    public void setSerialNumber(int serialNumber) {
        connection.setSerialNumber(serialNumber);
    }

    @Override
    public String getStatus() {
        return connection.getStatus();
    }

    @Override
    public void setStatus(String status) {
        connection.setStatus(status);
    }

    @Override
    public ConnectorType getAPointConnectorType() {
        if (connection instanceof OneToOneConnection)
            return oneToOneConnection.getAPointConnectorType();
        return wireless.getAPointConnectorType();
    }

    @Override
    public ConnectorType getBPointConnectorType() {
        if (connection instanceof OneToOneConnection)
            return oneToOneConnection.getBPointConnectorType();
        return wireless.getBPointConnectorType();
    }

    @Override
    public A getAPoint() {
        if (connection instanceof OneToOneConnection)
            return oneToOneConnection.getAPoint();

        return wireless.getAPoint();
    }

    @Override
    public void setAPoint(A device) {
        if (connection instanceof OneToOneConnection)
            oneToOneConnection.setAPoint(device);
        else
            wireless.setAPoint(device);
    }

    @Override
    public B getBPoint() {
        return oneToOneConnection.getBPoint();
    }

    @Override
    public void setBPoint(B device) {
        oneToOneConnection.setBPoint(device);
    }

    @Override
    public int compareTo(Connection o) {
        return connection.compareTo(o);
    }

    //thincoaxial
    public ConnectorType getConnectorType() {
        return thinCoaxial.getConnectorType();
    }

    //thincoaxial
    public boolean addDevice(A device) {
        return thinCoaxial.addDevice(device);
    }

    //thincoaxial
    public boolean removeDevice(A device) {
        return thinCoaxial.removeDevice(device);
    }

    //thincoaxial
    public boolean containDevice(A device) {
        return thinCoaxial.containDevice(device);
    }

    //thincoaxial
    public Set<A> getAllDevices() {
        return thinCoaxial.getAllDevices();
    }

    //thincoaxial
    public int getCurSize() {
        return thinCoaxial.getCurSize();
    }

    //thincoaxial
    public int getMaxSize() {
        return thinCoaxial.getMaxSize();
    }
}
