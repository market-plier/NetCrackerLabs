package com.netcracker.edu.inventory.model.rack.wrapper;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.rack.Rack;
import java.util.logging.Logger;

abstract class RackWrapper<D extends Device> implements Rack<D> {
    protected Logger logger = Logger.getLogger(RackWrapper.class.getName());

    protected Rack<D> wrappee;

}
