package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.model.NetworkElement;
import com.netcracker.edu.inventory.model.rack.Rack;
import com.netcracker.edu.io.IOService;
import com.netcracker.edu.io.impl.IOServiceImpl;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NetworkElementOutputThread implements Runnable  {
    Logger logger = Logger.getLogger(RackOutputThread.class.getName());
    IOService ioService = new IOServiceImpl();
    OutputStream outputStream;
    Collection<NetworkElement> elements;

    public NetworkElementOutputThread(OutputStream outputStream,Collection<NetworkElement> elements) {
        this.outputStream = outputStream;
        this.elements = elements;
    }

    @Override
    public void run() {
        for (NetworkElement element: elements) {
            try {
                ioService.outputFillableEntity(element,outputStream);
            } catch (IOException e) {
                logger.log(Level.SEVERE,e.getMessage(),e);
                e.printStackTrace();
            }
        }
    }
}
