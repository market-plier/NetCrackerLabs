package com.netcracker.edu.inventory.model.connection.entity;

import com.netcracker.edu.inventory.model.device.Device;

public interface AllConnections<A extends Device,B extends Device> extends OpticFiber<A,B>,TwistedPair<A,B>,Wireless<A,B> {
}
