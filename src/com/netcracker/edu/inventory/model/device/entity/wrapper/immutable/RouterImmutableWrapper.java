package com.netcracker.edu.inventory.model.device.entity.wrapper.immutable;

import com.netcracker.edu.inventory.model.device.entity.Router;

import java.util.logging.Level;

public class RouterImmutableWrapper extends DeviceImmutableWrapper<Router> implements Router {

    public RouterImmutableWrapper(Router wrappee) {
        super(wrappee);
        routerWrappee=wrappee;
    }

    @Override
    public int getDataRate() {
        return routerWrappee.getDataRate();
    }

    @Override
    public void setDataRate(int dataRate) {
        logger.log(Level.WARNING, "Can't change immutable connection");

    }
}
