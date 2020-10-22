package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.model.Device;
import com.netcracker.edu.inventory.service.Service;

public class ServiceImpl implements Service {
    @Override
    public void sortByIN(Device[] devices) {
        if (devices!=null){
            int nulls=0;
            int size=devices.length-1;
            for (int i =0;i<=size-nulls;i++){
               while (devices[size-nulls]==null){
                   nulls++;
               }
               if (devices[i]==null){
                   devices[i]=devices[size-nulls];
                   devices[size-nulls]=null;
                   nulls++;
               }
            }

            for (int i =0;i<=size-nulls;i++){
                while (devices[size-nulls].getIn()==0){
                    nulls++;
                }
                if (devices[i].getIn()==0){
                    Device temp = devices[i];
                    devices[i]=devices[size-nulls];
                    devices[size-nulls]=temp;
                    nulls++;
                }
            }
            if (size!=nulls-1){

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
    }
    @Override
    public void filtrateByType(Device[] devices, String type) {
        if (devices!=null){
            for(int i=0;i<devices.length;i++){
                if (devices[i]!=null){
                    if(devices[i].getType()!=null && type != null){
                        if (type.compareTo(devices[i].getType())!=0){
                            devices[i]=null;
                        }
                    }
                    else if (devices[i].getType()!=type){
                        devices[i]=null;
                    }

                }
            }
        }
    }
}
