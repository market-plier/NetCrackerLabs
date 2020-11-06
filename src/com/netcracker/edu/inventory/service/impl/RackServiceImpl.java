package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.model.Rack;
import com.netcracker.edu.inventory.service.RackService;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class RackServiceImpl implements RackService {
    @Override
    public boolean isValidRackForOutputToStream(Rack rack) {
        return false;
    }

    @Override
    public void outputRack(Rack rack, OutputStream outputStream) throws IOException {

    }

    @Override
    public Rack inputRack(InputStream inputStream) throws IOException, ClassNotFoundException {
        return null;
    }
}
