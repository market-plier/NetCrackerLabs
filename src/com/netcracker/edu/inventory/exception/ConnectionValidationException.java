package com.netcracker.edu.inventory.exception;

import com.netcracker.edu.inventory.model.Connection;

public class ConnectionValidationException extends RuntimeException {
    public final static String defaultMessage = "Connection is not valid for operation";

    private Connection connection;

    public ConnectionValidationException() {
        super();
    }

    public ConnectionValidationException(String operation) {
        super((operation != null) ? (defaultMessage + " " + operation) : defaultMessage);
    }

    public ConnectionValidationException(String operation, Connection connection) {
        this(operation);
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }
}
