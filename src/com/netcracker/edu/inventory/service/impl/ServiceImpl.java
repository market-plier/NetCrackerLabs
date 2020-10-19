package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.model.Device;
import com.netcracker.edu.inventory.service.Service;

public class ServiceImpl implements Service {
    @Override
    public void sortByIN(Device[] devices) {
        if (devices!=null){
            int nulls=0;
            int size=devices.length-1;
            for (int i =0;i<size;i++){
                if (devices[i]==null){
                    nulls++;
                    devices[i]=devices[devices.length-nulls];
                    devices[devices.length-nulls]=null;
                }
            }

            for (int i = size-nulls; i > 0; i--) {
                for (int j = 0; j < i; j++) {

                    if(devices[j].getIn()>devices[j+1].getIn()){
                        Device temp = devices[j];
                        devices[j]=devices[j+1];
                        devices[j+1]=temp;
                    }
                }
            }
        }
    }
    @Override
    public void filtrateByType(Device[] devices, String type) {
        if (devices!=null && type!=null){
            for(int i=0;i<devices.length;i++){
                if (devices[i]!=null){
                    if(devices[i].getType().compareTo(type)==0) {
                        devices[i]=null;
                    }
                }
            }
        }
    }
}
