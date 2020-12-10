package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.service.*;

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

    @Override
    public ConcurrentService createConcurrentServiceImpl() {
        return new ConcurrentServiceImpl();
    }
}
