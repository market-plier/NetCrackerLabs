package com.netcracker.edu.inventory.model.device.entity.wrapper.immutable;

import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.device.entity.Router;
import com.netcracker.edu.inventory.model.device.entity.wrapper.RouterWrapper;

import java.util.Date;
import java.util.Queue;
import java.util.logging.Level;

public class RouterImmutableWrapper extends RouterWrapper {

    public RouterImmutableWrapper(Router wrappee) {
        this.wrappee=wrappee;
    }

    @Override
    public int getDataRate() {
        return wrappee.getDataRate();
    }

    @Override
    public void setDataRate(int dataRate) {
        logger.log(Level.WARNING,"Can't change immutable connection");

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
