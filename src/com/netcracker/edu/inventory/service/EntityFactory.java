package com.netcracker.edu.inventory.service;

import com.netcracker.edu.inventory.model.NetworkElement;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.rack.Rack;

/**
 * Created by makovetskyi on 24.05.17.
 */
public interface EntityFactory {

    /**
     * Create empty NetworkElement instance by full class-name.
     *
     * @param className - class-name of target object
     * @return - empty NetworkElement instance
     * @throws IllegalArgumentException - if class with such full name not found or instance of this class can not be created
     */
    NetworkElement createEmptyNetworkElementImpl(String className) throws IllegalArgumentException;

    /**
     * Create empty NetworkElement instance by full class-object.
     *
     * @param clazz - class-object of target object
     * @return - empty NetworkElement instance
     * @throws IllegalArgumentException - if instance of this class can not be created
     */
    <T extends NetworkElement> T createEmptyNetworkElementImpl(Class<T> clazz) throws IllegalArgumentException;

    /**
     * Create empty Reck instance by simple name of class with constructors arguments.
     *
     * @param name - simple name of Rack implementation class
     * @param size - size of new Rack implementation
     * @param limitation - class-object of rack limitation on new Rack implementation
     * @param <T> - rack limitation of new Rack implementation
     * @return - empty Rack instance
     * @throws IllegalArgumentException - if instance of this class can not be created
     */
    <T extends Device> Rack<T> createEmptyRackImpl(String name, int size, Class<T> limitation) throws IllegalArgumentException;

}
