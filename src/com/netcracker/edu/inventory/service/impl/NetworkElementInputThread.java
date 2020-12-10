package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.model.NetworkElement;
import com.netcracker.edu.inventory.model.rack.Rack;
import com.netcracker.edu.io.IOService;
import com.netcracker.edu.io.impl.IOServiceImpl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;

public class NetworkElementInputThread implements Callable<Collection<NetworkElement>> {

    IOService ioService = new IOServiceImpl();
    InputStream inputStream;
    Collection<NetworkElement> elements;
    int number;

    public NetworkElementInputThread(InputStream inputStream, int number) {
        this.inputStream = inputStream;
        this.elements = new ArrayList<>(0);
        this.number = number;
    }


    @Override
    public Collection<NetworkElement> call() throws Exception {
        for (int i = 0 ;i<number;i++) {
            try {
                NetworkElement element = (NetworkElement)ioService.inputFillableEntity(inputStream);
                elements.add(element);
            }
            catch (Exception e){
                return elements;
            }
        }
        return elements;
    }
}