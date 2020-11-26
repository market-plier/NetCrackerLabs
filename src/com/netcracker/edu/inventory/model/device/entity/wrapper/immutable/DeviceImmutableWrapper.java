package com.netcracker.edu.inventory.model.device.entity.wrapper.immutable;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.device.entity.Battery;
import com.netcracker.edu.inventory.model.device.entity.Router;
import com.netcracker.edu.inventory.model.device.entity.Switch;
import com.netcracker.edu.inventory.model.device.entity.WifiRouter;
import com.netcracker.edu.inventory.model.device.entity.wrapper.DeviceWrapper;

import java.util.Date;
import java.util.List;
import java.util.Queue;
import java.util.logging.Level;

public class DeviceImmutableWrapper<T extends Device> extends DeviceWrapper {

    public DeviceImmutableWrapper(T device) {
        this.wrappee = device;
    }

    @Override
    public int getIn() {
        return wrappee.getIn();
    }

    @Override
    public void setIn(int in) {
        logger.log(Level.WARNING,"Can't change immutable connection");

    }

    @Override
    public String getType() {
        return wrappee.getType();
    }

    @Override
    public void setType(String type) {
        logger.log(Level.WARNING,"Can't change immutable connection");

    }

    @Override
    public String getManufacturer() {
        return wrappee.getManufacturer();
    }

    @Override
    public void setManufacturer(String manufacturer) {
        logger.log(Level.WARNING,"Can't change immutable connection");

    }

    @Override
    public String getModel() {
        return wrappee.getModel();
    }

    @Override
    public void setModel(String model) {
        logger.log(Level.WARNING,"Can't change immutable connection");

    }

    @Override
    public Date getProductionDate() {
        return wrappee.getProductionDate();
    }

    @Override
    public void setProductionDate(Date productionDate) {
        logger.log(Level.WARNING,"Can't change immutable connection");
    }

    @Override
    public void fillAllFields(Queue<Field> fields) {
wrappee.fillAllFields(fields);
    }

    @Override
    public Queue<Field> getAllFields() {
        return wrappee.getAllFields();
    }

    @Override
    public int compareTo(Device o) {
        return wrappee.compareTo(o);
    }
}
