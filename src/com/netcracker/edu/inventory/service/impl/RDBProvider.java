package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.InventoryFactoryManager;
import com.netcracker.edu.inventory.model.FillableEntity;
import com.netcracker.edu.inventory.model.NetworkElement;
import com.netcracker.edu.inventory.model.connection.ConnectionPrimaryKey;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.device.DevicePrimaryKey;
import com.netcracker.edu.inventory.model.device.entity.Battery;
import com.netcracker.edu.inventory.model.device.entity.Router;
import com.netcracker.edu.inventory.model.device.entity.Switch;
import com.netcracker.edu.inventory.model.device.entity.WifiRouter;
import com.netcracker.edu.inventory.service.EntityFactory;
import com.netcracker.edu.location.Service;
import com.netcracker.edu.location.impl.ServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by makovetskyi on 03.11.17.
 */
public class RDBProvider {

    protected final String CHECK_DEVICE_CLASS_QUERY = "SELECT `Class` FROM Device WHERE `InventoryNumber` = ?";

    protected final String GET_BATTERY_QUERY = "SELECT InventoryNumber,Manufacturer,Model,ProductionDate,Type,ChargeVolume FROM `Battery`,`Device` WHERE Battery.Device_id = Device.id AND Device.InventoryNumber = ?";
    protected final String GET_ROUTER_QUERY = "SELECT InventoryNumber,Manufacturer,Model,ProductionDate,Type,DataRate FROM `Router`,`Device` WHERE Router.Device_id = Device.id AND Device.InventoryNumber = ?";
    protected final String GET_SWITCH_QUERY = "SELECT InventoryNumber,Manufacturer,Model,ProductionDate,Type,DataRate,NumberOfPorts,PortsType,Switch.Device_id,NumberOfPorts FROM `Switch`,`Device`,`Router` WHERE Switch.Device_id = Device.id AND Device.InventoryNumber = ? AND Router.Device_id = Device.id";
    protected final String GET_WIFIROUTER_QUERY = "SELECT InventoryNumber,Manufacturer,Model,ProductionDate,Type,DataRate,TechnologyVersion,SecurityProtocol,WirePortType,WirelessConnection,WireConnection FROM `WifiRouter`,`Device`,`Router` WHERE WifiRouter.Device_id = Device.id AND Router.Device_id = Device.id AND Device.InventoryNumber = ?";

    protected final String GET_CONNECTION_PK_QUERY = "SELECT `Trunk_seq`, `SerialNumber` FROM `ConnectionPK` WHERE `PK_id` = ?";
    protected final String GET_CONNECTIONS_REF_QUERY = "SELECT `Index`, `Connection_PK_id` FROM `MultDevToConReferences` WHERE `Device_id` = ? AND `FieldSeq` = ?";

    protected final String INSERT_DEVICE_QUERY = "INSERT INTO `Device` (`Class`, `InventoryNumber`, `Manufacturer`, `Model`, `ProductionDate`, `Type`) VALUES (?,?,?,?,?,?)";
    protected final String INSERT_BATTERY_QUERY = "INSERT INTO `Battery` (`Device_id`, `ChargeVolume`) VALUES (?,?)";
    protected final String INSERT_ROUTER_QUERY = "INSERT INTO `Router` (`Device_id`, `DataRate`) VALUES (?,?)";
    protected final String INSERT_SWITCH_QUERY = "INSERT INTO `Switch` (`Device_id`, `NumberOfPorts`, `PortsType`) VALUES (?,?,?)";
    protected final String INSERT_WIFIROUTER_QUERY = "INSERT INTO `WifiRouter` (`Device_id`, `TechnologyVersion`, `SecurityProtocol`, `WirePortType`, `WirelessConnection`, `WireConnection`) VALUES (?,?,?,?,?,?)";

    protected final String INSERT_CPK_QUERY = "INSERT INTO `ConnectionPK` (`Trunk_seq`, `SerialNumber`) VALUES (?,?)";
    protected final String INSERT_CONNECTIONS_REF_QUERY = "INSERT INTO `MultDevToConReferences` (Device_id, `FieldSeq`, `Index`, `Connection_PK_id`) VALUES (?,?,?,?)";

    protected final String UPDATE_DEVICE_QUERY = "UPDATE `Device` SET `Type` = ?,`Model` = ?,`Manufacturer` = ?,`ProductionDate` = ? WHERE `InventoryNumber` = ?";
    protected final String UPDATE_BATTERY_QUERY = "UPDATE `Battery` SET `ChargeVolume` = ? WHERE `Device_id`= ?";
    protected final String UPDATE_ROUTER_QUERY = "UPDATE `Router` SET `DataRate` = ? WHERE `Device_id`= ?";
    protected final String UPDATE_SWITCH_QUERY = "UPDATE `Switch` SET `NumberOfPorts` = ?, `PortsType` = ? WHERE `Device_id`= ?";
    protected final String UPDATE_WIFIROUTER_QUERY = "UPDATE `WifiRouter` SET `TechnologyVersion` = ?, `SecurityProtocol` = ?,`WirelessConnection` = ?,`WirePortType` = ?,`WireConnection` = ? WHERE `Device_id`= ?";

    protected final String UPDATE_CPK_QUERY = "UPDATE `ConnectionPK` SET `Trunk_seq` = ?, `SerialNumber` = ? WHERE `PK_id`= ?";

    protected final String REMOVE_DEVICE_QUERY = "DELETE FROM `Device` WHERE `id` = ?";
    protected final String REMOVE_BATTERY_QUERY = "DELETE FROM `Battery` WHERE `Device_id` = ?";
    protected final String REMOVE_ROUTER_QUERY = "DELETE FROM `Router` WHERE `Device_id` = ?";
    protected final String REMOVE_SWITCH_QUERY = "DELETE FROM `Switch` WHERE `Device_id` = ?";
    protected final String REMOVE_WIFIROUTER_QUERY = "DELETE FROM `WifiRouter` WHERE `Device_id` = ?";

    protected final String REMOVE_CONNECTIONS_REF_QUERY = "DELETE FROM `MultDevToConReferences` WHERE `Device_id` = ? AND `FieldSeq` = ?";


    protected final String GET_DEVICE_ID_QUERY = "SELECT `id` FROM `Device` WHERE `InventoryNumber` = ?";
    protected final String GET_CPK_ID_QUERY = "SELECT `PK_id` FROM `ConnectionPK` WHERE `Trunk_seq` = ? AND `SerialNumber` = ?";

    protected final int DEVICE_FIELDS_NUMBER = 5;
    protected final int BATTERY_FIELDS_NUMBER = 1;
    protected final int ROUTER_FIELDS_NUMBER = 1;
    protected final int SWITCH_FIELDS_NUMBER = 2;
    protected final int WIFIROUTER_FIELDS_NUMBER = 5;

    protected final String SWITCH_PORTS_FIELD_SEQ = "P";

    private static final EntityFactory entityFactory = InventoryFactoryManager.getEntityFactory();
    private static final Service locationService = new ServiceImpl();

    protected Map<Class, String> getQueries;
    protected Map<Class, String> insertQueries;
    protected Map<Class, String> updateQueries;
    protected Map<Class, String> removeQueries;

    public RDBProvider() {
        getQueries = new HashMap<>();
        getQueries.put(Battery.class, GET_BATTERY_QUERY);
        getQueries.put(Router.class, GET_ROUTER_QUERY);
        getQueries.put(Switch.class, GET_SWITCH_QUERY);
        getQueries.put(WifiRouter.class, GET_WIFIROUTER_QUERY);
        insertQueries = new HashMap<>();
        insertQueries.put(Device.class, INSERT_DEVICE_QUERY);
        insertQueries.put(Battery.class, INSERT_BATTERY_QUERY);
        insertQueries.put(Router.class, INSERT_ROUTER_QUERY);
        insertQueries.put(Switch.class, INSERT_SWITCH_QUERY);
        insertQueries.put(WifiRouter.class, INSERT_WIFIROUTER_QUERY);
        updateQueries = new HashMap<>();
        updateQueries.put(Device.class, UPDATE_DEVICE_QUERY);
        updateQueries.put(Battery.class, UPDATE_BATTERY_QUERY);
        updateQueries.put(Router.class, UPDATE_ROUTER_QUERY);
        updateQueries.put(Switch.class, UPDATE_SWITCH_QUERY);
        updateQueries.put(WifiRouter.class, UPDATE_WIFIROUTER_QUERY);
        removeQueries = new HashMap<>();
        removeQueries.put(Device.class, REMOVE_DEVICE_QUERY);
        removeQueries.put(Battery.class, REMOVE_BATTERY_QUERY);
        removeQueries.put(Router.class, REMOVE_ROUTER_QUERY);
        removeQueries.put(Switch.class, REMOVE_SWITCH_QUERY);
        removeQueries.put(WifiRouter.class, REMOVE_WIFIROUTER_QUERY);
    }


    public Device getDeviceFromDB(Connection dbConnection, DevicePrimaryKey dpk) throws SQLException {
        checkDBConnection(dbConnection);
        if (dpk == null) {
            return null;
        }
        Class deviceClass = checkDeviceClass(dbConnection, dpk.getIn());
        if (deviceClass == null) {
            return null;
        }

        PreparedStatement statement = getStatement(dbConnection, Operation.get, deviceClass);
        statement.setInt(1, dpk.getIn());
        ResultSet resultSet = statement.executeQuery();
        if (!resultSet.next()) {
            return null;
        }

        Device device = (Device) entityFactory.createEmptyNetworkElementImpl(deviceClass);
        fillNetworkElement(dbConnection, device, resultSet);

        return device;
    }

    public boolean putDeviceToDB(Connection dbConnection, Device device) throws SQLException {
        checkDBConnection(dbConnection);
        if (device == null || device.isLazy()) {
            return false;
        }
        Class deviceClass = checkDeviceClass(dbConnection, device.getIn());

        try {
            if (deviceClass == null) {
                insertNetworkElement(dbConnection, device);
            } else {
                if (!deviceClass.isInstance(device)) {
                    return false;
                }
                updateNetworkElement(dbConnection, deviceClass, device);
            }
        } catch (RuntimeException e) {
            throw e;
        }

        return true;
    }

    public boolean removeDeviceFromDB(Connection dbConnection, DevicePrimaryKey dpk) throws SQLException {
        checkDBConnection(dbConnection);
        if (dpk == null) {
            return false;
        }
        Class deviceClass = checkDeviceClass(dbConnection, dpk.getIn());
        if (deviceClass == null) {
            return false;
        }
        try {
            if (Device.class.isAssignableFrom(deviceClass)) {
                if (Battery.class.isAssignableFrom(deviceClass)) {
                    removeBattery(dbConnection, dpk.getIn());
                    return true;
                }
                if (Router.class.isAssignableFrom(deviceClass)) {
                    if (Switch.class.isAssignableFrom(deviceClass)) {
                        removeSwitch(dbConnection, dpk.getIn());
                        return true;
                    }
                    if (WifiRouter.class.isAssignableFrom(deviceClass)) {
                        removeWifiRouter(dbConnection, dpk.getIn());
                        return true;
                    }
                    removeRouter(dbConnection, dpk.getIn());
                    return true;
                }
                return false;
            }
        } catch (RuntimeException e) {
            return false;
        }
        return false;
    }


    protected PreparedStatement getStatement(Connection dbConnection, Operation get, Class deviceClass) throws SQLException {
        if (Operation.get.equals(get)) {
            return dbConnection.prepareStatement(getQueries.get(deviceClass));
        }
        if (Operation.insert.equals(get)) {
            return dbConnection.prepareStatement(insertQueries.get(deviceClass));
        }
        if (Operation.update.equals(get)) {
            return dbConnection.prepareStatement(updateQueries.get(deviceClass));
        }
        if (Operation.remove.equals(get)) {
            return dbConnection.prepareStatement(removeQueries.get(deviceClass));
        }
        return null;
    }

    protected void insertNetworkElement(Connection dbConnection, NetworkElement networkElement) throws SQLException {
        FillableEntity.Field classNameField = new FillableEntity.Field(String.class, null);
        Queue<FillableEntity.Field> fields = new LinkedList<>();
        fields.add(classNameField);
        fields.addAll(networkElement.getAllFields());
        if (Device.class.isAssignableFrom(networkElement.getClass())) {
            if (Battery.class.isAssignableFrom(networkElement.getClass())) {
                classNameField.setValue(Battery.class.getName());
                insertBattery(dbConnection, fields);
                return;
            }
            if (Router.class.isAssignableFrom(networkElement.getClass())) {
                if (Switch.class.isAssignableFrom(networkElement.getClass())) {
                    classNameField.setValue(Switch.class.getName());
                    insertSwitch(dbConnection, fields);
                    return;
                }
                if (WifiRouter.class.isAssignableFrom(networkElement.getClass())) {
                    classNameField.setValue(WifiRouter.class.getName());
                    insertWifiRouter(dbConnection, fields);
                    return;
                }
                classNameField.setValue(Router.class.getName());
                insertRouter(dbConnection, fields);
                return;
            }
        }
    }

    protected void updateNetworkElement(Connection dbConnection, Class clazz, NetworkElement networkElement) throws SQLException {
        Queue<FillableEntity.Field> fields = networkElement.getAllFields();
        if (Device.class.isAssignableFrom(clazz)) {
            if (Battery.class.isAssignableFrom(clazz)) {
                updateBattery(dbConnection, fields);
                return;
            }
            if (Router.class.isAssignableFrom(clazz)) {
                if (Switch.class.isAssignableFrom(clazz)) {
                    updateSwitch(dbConnection, fields);
                    return;
                }
                if (WifiRouter.class.isAssignableFrom(clazz)) {
                    updateWifiRouter(dbConnection, fields);
                    return;
                }
                updateRouter(dbConnection, fields);
                return;
            }
        }
    }


    protected int insertDevice(Connection dbConnection, Queue<FillableEntity.Field> fields) throws SQLException {
        PreparedStatement statement = getStatement(dbConnection, Operation.insert, Device.class);

        fillStatementByField(dbConnection, statement, fields.remove(), 1);
        FillableEntity.Field inField = fields.remove();
        fillStatementByField(dbConnection, statement, inField, 2);
        fillStatementByFields(dbConnection, statement, fields, 3, DEVICE_FIELDS_NUMBER + 1);

        int affectedRows = statement.executeUpdate();
        if (affectedRows != 1) {
            throw new RuntimeException("not inserted");
        }

        return getDeviceId(dbConnection, (Integer) inField.getValue());
    }

    protected int updateDevice(Connection dbConnection, Queue<FillableEntity.Field> fields) throws SQLException {
        PreparedStatement statement = getStatement(dbConnection, Operation.update, Device.class);

        int in = (Integer) fields.remove().getValue();
        fillStatementByFields(dbConnection, statement, fields, 1, DEVICE_FIELDS_NUMBER - 1);
        statement.setInt(DEVICE_FIELDS_NUMBER, in);

        int affectedRows = statement.executeUpdate();
        if (affectedRows != 1) {
            throw new RuntimeException("not updated");
        }

        return getDeviceId(dbConnection, in);
    }

    protected int removeDevice(Connection dbConnection, int in) throws SQLException {
        int id = getDeviceId(dbConnection, in);
        if (id == 0) {
            return 0;
        }

        PreparedStatement statement = getStatement(dbConnection, Operation.remove, Device.class);
        statement.setInt(1, id);
        int affectedRows = statement.executeUpdate();
        if (affectedRows != 1) {
            throw new RuntimeException("not removed");
        }

        return id;
    }

    protected int insertBattery(Connection dbConnection, Queue<FillableEntity.Field> fields) throws SQLException {
        int id = insertDevice(dbConnection, fields);

        PreparedStatement statement = getStatement(dbConnection, Operation.insert, Battery.class);

        statement.setInt(1 , id);
        fillStatementByFields(dbConnection, statement, fields, 2, BATTERY_FIELDS_NUMBER + 1);

        int affectedRows = statement.executeUpdate();
        if (affectedRows != 1) {
            throw new RuntimeException("not inserted");
        }

        return id;
    }

    protected int insertRouter(Connection dbConnection, Queue<FillableEntity.Field> fields) throws SQLException {
        int id = insertDevice(dbConnection, fields);

        PreparedStatement statement = getStatement(dbConnection, Operation.insert, Router.class);

        statement.setInt(1 , id);
        fillStatementByFields(dbConnection, statement, fields, 2, ROUTER_FIELDS_NUMBER + 1);

        int affectedRows = statement.executeUpdate();
        if (affectedRows != 1) {
            throw new RuntimeException("not inserted");
        }

        return id;
    }

    protected int insertSwitch(Connection dbConnection, Queue<FillableEntity.Field> fields) throws SQLException {
        int id = insertRouter(dbConnection, fields);

        PreparedStatement statement = getStatement(dbConnection, Operation.insert, Switch.class);

        statement.setInt(1 , id);
        fillStatementByFields(dbConnection, statement, fields, 2, SWITCH_FIELDS_NUMBER + 1);
        insertConnectionReferences(dbConnection,
                (com.netcracker.edu.inventory.model.connection.Connection<?, ?>[]) fields.remove().getValue(),
                id, SWITCH_PORTS_FIELD_SEQ);

        int affectedRows = statement.executeUpdate();
        if (affectedRows != 1) {
            throw new RuntimeException("Switch not inserted");
        }

        return id;
    }

    protected int insertWifiRouter(Connection dbConnection, Queue<FillableEntity.Field> fields) throws SQLException {
        int id = insertRouter(dbConnection, fields);

        PreparedStatement statement = getStatement(dbConnection, Operation.insert, WifiRouter.class);

        statement.setInt(1 , id);
        fillStatementByFields(dbConnection, statement, fields, 2, WIFIROUTER_FIELDS_NUMBER + 1);

        int affectedRows = statement.executeUpdate();
        if (affectedRows != 1) {
            throw new RuntimeException("WifiRouter not inserted");
        }

        return id;
    }

    protected int updateBattery(Connection dbConnection, Queue<FillableEntity.Field> fields) throws SQLException {
        int id = updateDevice(dbConnection, fields);

        PreparedStatement statement = getStatement(dbConnection, Operation.update, Battery.class);

        fillStatementByFields(dbConnection, statement, fields, 1, BATTERY_FIELDS_NUMBER);
        statement.setInt(BATTERY_FIELDS_NUMBER + 1, id);

        int affectedRows = statement.executeUpdate();
        if (affectedRows != 1) {
            throw new RuntimeException("not updated");
        }

        return id;
    }

    protected int updateRouter(Connection dbConnection, Queue<FillableEntity.Field> fields) throws SQLException {
        int id = updateDevice(dbConnection, fields);

        PreparedStatement statement = getStatement(dbConnection, Operation.update, Router.class);

        fillStatementByFields(dbConnection, statement, fields, 1, ROUTER_FIELDS_NUMBER);
        statement.setInt(ROUTER_FIELDS_NUMBER + 1, id);

        int affectedRows = statement.executeUpdate();
        if (affectedRows != 1) {
            throw new RuntimeException("not updated");
        }

        return id;
    }

    protected int updateSwitch(Connection dbConnection, Queue<FillableEntity.Field> fields) throws SQLException {
        int id = updateRouter(dbConnection, fields);

        PreparedStatement statement = getStatement(dbConnection, Operation.update, Switch.class);

        fillStatementByFields(dbConnection, statement, fields, 1, SWITCH_FIELDS_NUMBER);
        statement.setInt(SWITCH_FIELDS_NUMBER + 1, id);
        updateConnectionReferences(dbConnection,
                (com.netcracker.edu.inventory.model.connection.Connection<?, ?>[]) fields.remove().getValue(),
                id, SWITCH_PORTS_FIELD_SEQ);

        int affectedRows = statement.executeUpdate();
        if (affectedRows != 1) {
            throw new RuntimeException("Switch not updated");
        }

        return id;
    }

    protected int updateWifiRouter(Connection dbConnection, Queue<FillableEntity.Field> fields) throws SQLException {
        int id = updateRouter(dbConnection, fields);

        PreparedStatement statement = getStatement(dbConnection, Operation.update, WifiRouter.class);

        fillStatementByFields(dbConnection, statement, fields, 1, WIFIROUTER_FIELDS_NUMBER);
        statement.setInt(WIFIROUTER_FIELDS_NUMBER + 1, id);

        int affectedRows = statement.executeUpdate();
        if (affectedRows != 1) {
            throw new RuntimeException("WifiRouter not updated");
        }

        return id;
    }

    protected int removeBattery(Connection dbConnection, int in) throws SQLException {
        int id = removeDevice(dbConnection, in);
        if (id == 0) {
            return 0;
        }

        PreparedStatement statement = getStatement(dbConnection, Operation.remove, Battery.class);
        statement.setInt(1, id);
        int affectedRows = statement.executeUpdate();
        if (affectedRows != 1) {
            throw new RuntimeException("not removed");
        }

        return id;
    }

    protected int removeRouter(Connection dbConnection, int in) throws SQLException {
        int id = removeDevice(dbConnection, in);
        if (id == 0) {
            return 0;
        }

        PreparedStatement statement = getStatement(dbConnection, Operation.remove, Router.class);
        statement.setInt(1, id);
        int affectedRows = statement.executeUpdate();
        if (affectedRows != 1) {
            throw new RuntimeException("not removed");
        }

        return id;
    }

    protected int removeSwitch(Connection dbConnection, int in) throws SQLException {
        int id = removeRouter(dbConnection, in);
        if (id == 0) {
            return 0;
        }

        PreparedStatement statement = getStatement(dbConnection, Operation.remove, Switch.class);
        statement.setInt(1, id);
        int affectedRows = statement.executeUpdate();
        if (affectedRows != 1) {
            throw new RuntimeException("Switch not removed");
        }

        return id;
    }

    protected int removeWifiRouter(Connection dbConnection, int in) throws SQLException {
        int id = removeRouter(dbConnection, in);
        if (id == 0) {
            return 0;
        }

        PreparedStatement statement = getStatement(dbConnection, Operation.remove, WifiRouter.class);
        statement.setInt(1, id);
        int affectedRows = statement.executeUpdate();
        if (affectedRows != 1) {
            throw new RuntimeException("WifiRouter not removed");
        }

        return id;
    }


    protected Class checkDeviceClass(Connection dbConnection, int in) throws SQLException {
        PreparedStatement statement = dbConnection.prepareStatement(CHECK_DEVICE_CLASS_QUERY);
        statement.setInt(1, in);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String className = resultSet.getString(1);
            try {
                return Class.forName(className);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    protected int getDeviceId(Connection dbConnection, int in) throws SQLException {
        PreparedStatement statement = dbConnection.prepareStatement(GET_DEVICE_ID_QUERY);
        statement.setInt(1, in);
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next() ? resultSet.getInt(1) : 0;
    }

    protected ConnectionPrimaryKey getConnectionPK(Connection dbConnection, int connectionPkId) throws SQLException {
        PreparedStatement statement = dbConnection.prepareStatement(GET_CONNECTION_PK_QUERY);
        statement.setInt(1, connectionPkId);
        ResultSet resultSet = statement.executeQuery();
        return !resultSet.next() ? null : entityFactory.createConnectionPrimaryKey(
                locationService.getTrunkFromDB(dbConnection, resultSet.getString(1)), resultSet.getInt(2));
    }

    protected int getCPKId(Connection dbConnection, ConnectionPrimaryKey cpk) throws SQLException {
        PreparedStatement statement = dbConnection.prepareStatement(GET_CPK_ID_QUERY);
        statement.setString(1, cpk.getTrunk().getAlias());
        statement.setInt(2, cpk.getSerialNumber());
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next() ? resultSet.getInt(1) : 0;
    }


    protected int putConnectionPK(Connection dbConnection, ConnectionPrimaryKey cpk) throws SQLException {
        int cpkId = getCPKId(dbConnection, cpk);
        if (cpkId == 0) {
            return insertCPK(dbConnection, cpk);
        } else {
            updateCPK(dbConnection, cpk,cpkId);
            return cpkId;
        }
    }

    private int insertCPK(Connection dbConnection, ConnectionPrimaryKey cpk) throws SQLException {
        PreparedStatement statement = dbConnection.prepareStatement(INSERT_CPK_QUERY);
        locationService.putTrunkToDB(dbConnection, cpk.getTrunk());
        statement.setString(1, cpk.getTrunk().getAlias());
        statement.setInt(2, cpk.getSerialNumber());
        int affectedRows = statement.executeUpdate();
        if (affectedRows != 1) {
            throw new RuntimeException("CPK not inserted");
        }

        return getCPKId(dbConnection, cpk);
    }

    protected void insertConnectionReferences(Connection dbConnection,
                                              com.netcracker.edu.inventory.model.connection.Connection<?, ?>[] connections,
                                              int deviceId, String fieldSeq) throws SQLException {
        for (int i = 0; i < connections.length; i++) {
            if (connections[i] != null) {
                ConnectionPrimaryKey cpk = connections[i].getPrimaryKey();
                PreparedStatement statement = dbConnection.prepareStatement(INSERT_CONNECTIONS_REF_QUERY);
                putConnectionPK(dbConnection, cpk);
                statement.setInt(1, deviceId);
                statement.setString(2, fieldSeq);
                statement.setInt(3, i);
                statement.setInt(4, getCPKId(dbConnection, cpk));
                int affectedRows = statement.executeUpdate();
                if (affectedRows != 1) {
                    throw new RuntimeException("Connection reference not inserted");
                }
            }
        }
    }

    private void updateCPK(Connection dbConnection, ConnectionPrimaryKey cpk) throws SQLException {
        PreparedStatement statement = dbConnection.prepareStatement(UPDATE_CPK_QUERY);
        locationService.putTrunkToDB(dbConnection, cpk.getTrunk());
        statement.setString(1, cpk.getTrunk().getAlias());
        statement.setInt(2, cpk.getSerialNumber());
        statement.setInt(3, cpk.getSerialNumber());
        statement.executeUpdate();
    }
    private void updateCPK(Connection dbConnection, ConnectionPrimaryKey cpk, int pkId) throws SQLException {
        PreparedStatement statement = dbConnection.prepareStatement(UPDATE_CPK_QUERY);
        locationService.putTrunkToDB(dbConnection, cpk.getTrunk());
        statement.setString(1, cpk.getTrunk().getAlias());
        statement.setInt(2, cpk.getSerialNumber());
        statement.setInt(3, pkId);
        statement.executeUpdate();
    }

    protected void updateConnectionReferences(Connection dbConnection,
                                              com.netcracker.edu.inventory.model.connection.Connection<?, ?>[] connections,
                                              int deviceId, String fieldSeq) throws SQLException {
        removeConnectionReferances(dbConnection, deviceId, fieldSeq);
        insertConnectionReferences(dbConnection, connections, deviceId, fieldSeq);
    }

    protected void removeConnectionReferances(Connection dbConnection, int deviceId, String fieldSeq) throws SQLException {
        PreparedStatement statement = dbConnection.prepareStatement(REMOVE_CONNECTIONS_REF_QUERY);
        statement.setInt(1, deviceId);
        statement.setString(2, fieldSeq);
        statement.executeUpdate();
    }


    protected void fillNetworkElement(Connection dbConnection, NetworkElement element, ResultSet source) throws SQLException {
        Queue<FillableEntity.Field> fields = element.getAllFields();
        int columnIndex = 1;
        for (FillableEntity.Field field : fields ) {
            if (field.getType() == String.class) {
                String string = source.getString(columnIndex++);
                field.setValue(string);
                continue;
            } if (field.getType() == Integer.class) {
                int integer = source.getInt(columnIndex++);
                field.setValue(integer);
                continue;
            } if (field.getType() == Date.class) {
                long aLong = source.getLong(columnIndex++);
                field.setValue(aLong == -1 ? null : new Date(aLong));
                continue;
            } if (field.getType() == com.netcracker.edu.inventory.model.connection.Connection.class) {
                ConnectionPrimaryKey pk = getConnectionPK(dbConnection, source.getInt(columnIndex++));
                field.setValue(pk == null ? null : entityFactory.createLazyInstance(pk));
                continue;
            } if (field.getType() == com.netcracker.edu.inventory.model.connection.Connection[].class) {
                int deviceId = source.getInt(columnIndex++);
                com.netcracker.edu.inventory.model.connection.Connection[] connections =
                        new com.netcracker.edu.inventory.model.connection.Connection[source.getInt(columnIndex++)];
                if (connections.length == 0) {
                    field.setValue(null);
                    continue;
                }
                fillConnections(dbConnection, connections, deviceId, SWITCH_PORTS_FIELD_SEQ);
                field.setValue(connections);
                continue;
            }
        }
        element.fillAllFields(fields);
        return;
    }

    protected void fillStatementByFields(Connection dbConnection, PreparedStatement statement, Queue<FillableEntity.Field> fields, int from, int to) throws SQLException {
        for (int columnCounter = from; columnCounter <= to; columnCounter++) {
            fillStatementByField(dbConnection, statement, fields.remove(), columnCounter);
        }
    }

    protected void fillStatementByField(Connection dbConnection, PreparedStatement statement, FillableEntity.Field field, int count) throws SQLException {
        if (field.getType() == String.class) {
            statement.setString(count, (String) field.getValue());
            return;
        } if (field.getType() == Integer.class) {
            statement.setInt(count, (Integer) field.getValue());
            return;
        } if (field.getType() == Date.class) {
            Date date = (Date) field.getValue();
            statement.setLong(count, date == null ? -1 : date.getTime());
            return;
        } if (field.getType() == com.netcracker.edu.inventory.model.connection.Connection.class) {
            com.netcracker.edu.inventory.model.connection.Connection<?, ?> connection =
                    (com.netcracker.edu.inventory.model.connection.Connection<?, ?>) field.getValue();
            statement.setInt(count, connection == null ? 0 : putConnectionPK(dbConnection, connection.getPrimaryKey()));
            return;
        }
    }

    protected void fillConnections(Connection dbConnection,
                                   com.netcracker.edu.inventory.model.connection.Connection[] connections,
                                   int deviceId, String fieldSeq) throws SQLException {
        PreparedStatement statement = dbConnection.prepareStatement(GET_CONNECTIONS_REF_QUERY);
        statement.setInt(1, deviceId);
        statement.setString(2, fieldSeq);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            connections[resultSet.getInt(1)] = entityFactory.createLazyInstance(
                    getConnectionPK(dbConnection, resultSet.getInt(2)));
        }
    }

    protected void checkDBConnection(Connection dbConnection) throws SQLException {
        if (dbConnection == null) {
            throw new SQLException("Data base connection is null");
        }
    }

    protected boolean checkDevice(Device device) throws SQLException {
        return device == null;
    }

    protected boolean checkDevicePK(DevicePrimaryKey devicePK) throws SQLException {
        return devicePK == null;
    }

    protected enum Operation {get, insert, update, remove}

}