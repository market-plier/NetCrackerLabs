package com.netcracker.edu.inventory.service;

import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.NetworkElement;

/**The interface Service describe list of services of Inventory component
 *
 * Created by makovetskyi on 05.10.2016.
 */
public interface Service {

    /**
     * Sort array of Device-s by identification number.
     *
     * @param devices - array of Device-s, that need to be sorted
     *
     * @deprecated
     * @see DeviceService
     */

    DeviceService getDeviceService();

    /**
     * Return ConnectionService implementation
     *
     * @return implementation of ConnectionService interface
     */
    ConnectionService getConnectionService();

    /**
     * Return RackService implementation
     *
     * @return implementation of RackService interface
     */
    RackService getRackService();

    /**
     * create new instance of NetworkElement by class
     *
     * @param clazz - class of NetworkElement
     * @return - instance of NetworkElement
     */
    <T extends NetworkElement> T createNEInstance(Class<T> clazz);

}