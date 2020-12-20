package com.netcracker.edu.inventory.model.connection.entity.impl;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectionPrimaryKey;
import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.connection.impl.ConnectionPK;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.location.Trunk;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class AbstractConnection<A extends Device, B extends Device> implements Connection<A,B>, Connection.HaveAPoint, Connection.HaveBPoint {

    protected Logger logger = Logger.getLogger(AbstractConnection.class.getName());
    protected Trunk trunk;
    protected int serialNumber;
    protected ConnectorType aPointConnectorType=ConnectorType.need_init;
    protected ConnectorType bPointConnectorType=ConnectorType.need_init;
    protected String status=PLANED;

    @Override
    public Trunk getTrunk() {
        return trunk;
    }

    @Override
    public void setTrunk(Trunk trunk) {
        this.trunk = trunk;
    }

    @Override
    public int getSerialNumber() {
        return serialNumber;
    }

    @Override
    public void setSerialNumber(int serialNumber) {
        if (this.serialNumber == 0 && serialNumber > 0) {
            this.serialNumber = serialNumber;
        } else if (serialNumber < 0) {
            IllegalArgumentException ex = new IllegalArgumentException("serialNumber can not be negative");
            logger.log(Level.SEVERE, ex.getMessage(), ex);
            throw ex;
        } else if (this.serialNumber != 0) {
            logger.log(Level.WARNING, "serialNumber number can not be reset");
        }
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void setStatus(String status) {
        this.status=status;
    }

    @Override
    public void fillAllFields(Queue<Field> fields) {
        setTrunk((Trunk)fields.remove().getValue());
        setSerialNumber((Integer)fields.remove().getValue());
        setStatus((String)fields.remove().getValue());
        setAPointConnectorType(ConnectorType.valueOf((String)fields.remove().getValue()));
        setBPointConnectorType(ConnectorType.valueOf((String)fields.remove().getValue()));
    }

    @Override
    public Queue<Field> getAllFields() {
        Queue<Field> fields = new LinkedList<>();
        fields.add(new Field(Trunk.class,getTrunk()));
        fields.add(new Field(Integer.class,getSerialNumber()));
        fields.add(new Field(String.class,getStatus()));
        fields.add(new Field(String.class,getAPointConnectorType().toString()));
        fields.add(new Field(String.class,getBPointConnectorType().toString()));
        return fields;
    }

    @Override
    public int compareTo(Connection o) {
        return Integer.compare(getSerialNumber(),o.getSerialNumber());
    }

    @Override
    public ConnectorType getAPointConnectorType() {
        return aPointConnectorType;
    }

    @Override
    public ConnectorType getBPointConnectorType() {
        return bPointConnectorType;
    }

    protected void setAPointConnectorType(ConnectorType type){
        if (getAPointConnectorType()==ConnectorType.need_init)
        aPointConnectorType=type;
    }

    protected void setBPointConnectorType(ConnectorType type){
        if(getBPointConnectorType()==ConnectorType.need_init)
        bPointConnectorType=type;
    }

    @Override
    public boolean isLazy() {
        return false;
    }

    @Override
    public ConnectionPrimaryKey getPrimaryKey() {
        if (trunk == null || serialNumber == 0)
            return null;
        return new ConnectionPK(trunk,serialNumber);
    }
}
