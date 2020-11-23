package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.service.ConnectionService;
import com.netcracker.edu.inventory.service.DeviceService;
import com.netcracker.edu.inventory.service.RackService;
import com.netcracker.edu.inventory.service.ServiceFactory;

public class ServiceFactoryImpl implements ServiceFactory {
    @Override
    public DeviceService createDeviceServiceImpl() {
        return DeviceServiceImpl.getDeviceService();
    }

    @Override
    public ConnectionService createConnectionServiceImpl() {
        return ConnectionServiceImpl.getConnectionService();
    }

    @Override
    public RackService createRackServiceImpl() {
        return RackServiceImpl.getRackService();
    }
}
