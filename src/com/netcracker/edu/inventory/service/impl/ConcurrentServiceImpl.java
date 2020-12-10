package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.model.NetworkElement;
import com.netcracker.edu.inventory.model.rack.Rack;
import com.netcracker.edu.inventory.service.ConcurrentService;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrentServiceImpl implements ConcurrentService {
    @Override
    public Future parallelOutputElements(Collection<NetworkElement> elements, OutputStream outputStream) {
        ExecutorService service = Executors.newCachedThreadPool();
        return service.submit(new NetworkElementOutputThread(outputStream,elements));
    }

    @Override
    public Future<Collection<NetworkElement>> parallelInputElements(int number, InputStream inputStream) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        return service.submit((new NetworkElementInputThread(inputStream, number)));
    }

    @Override
    public Future parallelOutputRacks(Collection<Rack> racks, OutputStream outputStream) {
        ExecutorService service = Executors.newCachedThreadPool();
        return service.submit(new RackOutputThread(racks, outputStream));
    }

    @Override
    public Future<Collection<Rack>> parallelInputRacks(int number, InputStream inputStream) {
            ExecutorService service = Executors.newSingleThreadExecutor();

            return service.submit((new RackInputThread(inputStream, number)));
    }
}
