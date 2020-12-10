package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.model.rack.Rack;
import com.netcracker.edu.io.IOService;
import com.netcracker.edu.io.impl.IOServiceImpl;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RackOutputThread implements Runnable  {
    Logger logger = Logger.getLogger(RackOutputThread.class.getName());
    IOService ioService = new IOServiceImpl();
    OutputStream outputStream;
    Collection<Rack> racks;
    public RackOutputThread(Collection<Rack> racks, OutputStream outputStream) {
        this.racks = racks;
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        for (Rack rack: racks) {
            try {
                ioService.outputRack(rack,outputStream);
            } catch (IOException e) {
                logger.log(Level.SEVERE,e.getMessage(),e);
                e.printStackTrace();
            }

        }
        }
    }

