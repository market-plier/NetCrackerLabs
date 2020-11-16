package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.exception.ConnectionValidationException;
import com.netcracker.edu.inventory.model.Connection;
import com.netcracker.edu.inventory.service.ConnectionService;
import com.netcracker.edu.io.IOService;
import com.netcracker.edu.io.impl.IOServiceImpl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionServiceImpl implements ConnectionService {

    private static ConnectionService connectionService=null;
    private final Logger logger = Logger.getLogger(ConnectionServiceImpl.class.getName());
    private final IOService ioService = new IOServiceImpl();

    public static ConnectionService getConnectionService(){
        if (connectionService==null)
            connectionService = new ConnectionServiceImpl();
        return connectionService;
    }

    @Override
    public boolean isValidConnectionForOutputToStream(Connection connection) {
        return ioService.isValidEntityForOutputToStream(connection);
    }

    @Override
    public void outputConnection(Connection connection, OutputStream outputStream) throws IOException {
        if (!isValidConnectionForOutputToStream(connection)){
            ConnectionValidationException exception=new ConnectionValidationException("ConnectionService.outputConnection");
          logger.log(Level.SEVERE,exception.getMessage(),exception);
            throw exception;
        }
    ioService.outputFillableEntity(connection,outputStream);
    }

    @Override
    public Connection inputConnection(InputStream inputStream) throws IOException, ClassNotFoundException {
        return (Connection)ioService.inputFillableEntity(inputStream);
    }
}
