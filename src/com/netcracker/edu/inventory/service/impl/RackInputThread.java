package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.model.rack.Rack;
import com.netcracker.edu.io.IOService;
import com.netcracker.edu.io.impl.IOServiceImpl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;

public class RackInputThread implements Callable<Collection<Rack>> {

    IOService ioService = new IOServiceImpl();
    InputStream inputStream;
    Collection<Rack> racks;
    int number;

    public RackInputThread(InputStream inputStream, int number) {
        this.inputStream = inputStream;
        this.racks = new ArrayList<>(0);
        this.number = number;
    }


    @Override
    public Collection<Rack> call() throws Exception {
        for (int i = 0 ;i<number;i++) {
            try {
                Rack rack = ioService.inputRack(inputStream);
                racks.add(rack);
            }
            catch (Exception e){
                return racks;
            }
        }
        return racks;
    }
}
