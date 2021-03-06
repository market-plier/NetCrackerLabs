package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.model.rack.Rack;
import com.netcracker.edu.inventory.service.RackService;
import com.netcracker.edu.io.IOService;
import com.netcracker.edu.io.impl.IOServiceImpl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class RackServiceImpl implements RackService {
    private final IOService service= new IOServiceImpl();
    private static RackService rackService;
    public static RackService getRackService(){
        if (rackService==null)
            rackService=new RackServiceImpl();
        return rackService;
    }
    @Override
    public boolean isValidRackForOutputToStream(Rack rack) {
        return service.isValidRackForOutputToStream(rack);
    }

    @Override
    public void outputRack(Rack rack, OutputStream outputStream) throws IOException {
        service.outputRack(rack,outputStream);
    }

    @Override
    public Rack inputRack(InputStream inputStream) throws IOException, ClassNotFoundException {
        return service.inputRack(inputStream);
    }
}
