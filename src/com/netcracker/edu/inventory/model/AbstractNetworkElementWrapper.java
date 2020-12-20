package com.netcracker.edu.inventory.model;

import java.util.Queue;

public class AbstractNetworkElementWrapper<T extends NetworkElement,K extends Unique.PrimaryKey> {

    protected NetworkElement<T,K> networkElement;

    public AbstractNetworkElementWrapper(NetworkElement<T,K> networkElement) {
        this.networkElement = networkElement;
    }

    public void fillAllFields(Queue<FillableEntity.Field> fields) {
        networkElement.fillAllFields(fields);
    }

    public Queue<FillableEntity.Field> getAllFields() {
        return networkElement.getAllFields();
    }

    public int compareTo(T o) {
        return networkElement.compareTo(o);
    }
}
