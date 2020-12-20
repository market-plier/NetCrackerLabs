package com.netcracker.edu.inventory.model.rack.wrapper;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.rack.Rack;
import com.netcracker.edu.inventory.model.rack.RackPrimaryKey;

import java.util.logging.Logger;

 abstract class RackWrapper<D extends Device> implements Rack<D> {
    protected Logger logger = Logger.getLogger(RackWrapper.class.getName());

    protected Rack<D> wrappee;

     @Override
     public boolean isLazy() {
         return wrappee.isLazy();
     }

     @Override
     public RackPrimaryKey getPrimaryKey() {
         return wrappee.getPrimaryKey();
     }
 }
