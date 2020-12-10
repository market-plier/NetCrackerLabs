package com.netcracker.edu.inventory.model.device.entity.wrapper.implementations;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.device.Device;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeviceImmutableWrapper<T extends Device> extends AbstractDeviceWrapper {

    Logger logger = Logger.getLogger(DeviceImmutableWrapper.class.getName());
    public DeviceImmutableWrapper(T device) {
        super(device);
    }

    @Override
    public void setIn(int in) {logger.log(Level.WARNING, "Can't change immutable connection");
    }

    @Override
    public void setType(String type) {
        logger.log(Level.WARNING, "Can't change immutable connection");
    }


    @Override
    public void setManufacturer(String manufacturer) {logger.log(Level.WARNING, "Can't change immutable connection");
    }

    @Override
    public void setModel(String model) {logger.log(Level.WARNING, "Can't change immutable connection");
    }


    @Override
    public void setProductionDate(Date productionDate) {logger.log(Level.WARNING, "Can't change immutable connection");
    }


    @Override
    public void setChargeVolume(int chargeVolume) {logger.log(Level.WARNING, "Can't change immutable connection");
    }

    @Override
    public void setNumberOfPorts(int numberOfPorts) {logger.log(Level.WARNING, "Can't change immutable connection");
    }

    @Override
    public void setPortConnection(Connection connection, int portNumber) {logger.log(Level.WARNING, "Can't change immutable connection");
    }

    @Override
    public void setSecurityProtocol(String securityProtocol) {logger.log(Level.WARNING, "Can't change immutable connection");
    }

    @Override
    public void setWirelessConnection(Connection wirelessConnection) {logger.log(Level.WARNING, "Can't change immutable connection");
    }

    @Override
    public void setWireConnection(Connection wireConnection) {logger.log(Level.WARNING, "Can't change immutable connection");
    }


    @Override
    public void setDataRate(int dataRate) {logger.log(Level.WARNING, "Can't change immutable connection");
    }
}
