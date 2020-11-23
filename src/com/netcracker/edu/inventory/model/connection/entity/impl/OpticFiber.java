package com.netcracker.edu.inventory.model.connection.entity.impl;

import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.device.Device;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.logging.Level;

public class OpticFiber<A extends Device,B extends Device>  extends AbstractOneToOneConnection<A,B> implements com.netcracker.edu.inventory.model.connection.entity.OpticFiber<A,B> {

    private Mode mode=Mode.need_init;
    private int length=0;


    public OpticFiber() {
        setAPointConnectorType(ConnectorType.FiberConnector_FC);
        setBPointConnectorType(ConnectorType.FiberConnector_FC);
    }

    public OpticFiber(Mode mode,int length){
        this();
        setMode(mode);
        setLength(length);
    }

    public void setLength(int length) {
        this.length=length;
    }
    public int getLength(){
        return length;
    }
    private void setMode(Mode mode){
        if (this.mode==Mode.need_init)
        this.mode = mode;
    }
    public Mode getMode(){
        return mode;
    }

    @Override
    public void fillAllFields(Queue<Field> fields) {
        try {
            super.fillAllFields(fields);
            setLength((Integer) fields.remove().getValue());
            setMode(Mode.valueOf((String)fields.remove().getValue()));
        }
        catch (NoSuchElementException e){
            logger.log(Level.SEVERE,e.getMessage(),e);
            throw e;
        }
    }

    @Override
    public Queue<Field> getAllFields() {
        Queue<Field> fields = super.getAllFields();
        fields.add(new Field(Integer.class,getLength()));
        fields.add(new Field(String.class,getMode().toString()));
        return fields;
    }
}
