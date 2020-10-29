package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.model.Device;
import com.netcracker.edu.inventory.service.Service;

import java.util.Collections;

public class ServiceImpl implements Service {

    private int sortNulls(Device[] devices){
            int nulls = 0;
            int size = devices.length - 1;
            for (int i = 0; i <= size - nulls; i++) {
                while (devices[size - nulls] == null) {
                    nulls++;
                }
                if (devices[i] == null) {
                    devices[i] = devices[size - nulls];
                    devices[size - nulls] = null;
                    nulls++;
                }
            }

            return nulls;
    }
    @Override
    public void sortByIN(Device[] devices) {

        if (devices!=null){
            int nulls=sortNulls(devices);
            int size=devices.length-1;
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
    public void sortByProductionDate(Device[] devices) {
        if (devices!=null){
            int nulls=sortNulls(devices);
            int size=devices.length-1;
            for (int i =0;i<=size-nulls;i++){
                while (devices[size-nulls].getProductionDate()==null){
                    nulls++;
                }
                if (devices[i].getProductionDate()==null){
                    Device temp = devices[i];
                    devices[i]=devices[size-nulls];
                    devices[size-nulls]=temp;
                    nulls++;
                }
            }
            if (size!=nulls-1){
                for (int i = size-nulls; i > 0; i--) {
                    for (int j = 0; j < i; j++) {

                        if(devices[j].getProductionDate().after(devices[j+1].getProductionDate())){
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

    @Override
    public void filtrateByManufacturer(Device[] devices, String manufacturer) {
        if (devices!=null){
            for(int i=0;i<devices.length;i++){
                if (devices[i]!=null){
                    if(devices[i].getManufacturer()!=null && manufacturer != null){
                        if (manufacturer.compareTo(devices[i].getManufacturer())!=0){
                            devices[i]=null;
                        }
                    }
                    else if (devices[i].getManufacturer()!=manufacturer){
                        devices[i]=null;
                    }

                }
            }
        }
    }

    @Override
    public void filtrateByModel(Device[] devices, String model) {
        if (devices!=null){
            for(int i=0;i<devices.length;i++){
                if (devices[i]!=null){
                    if(devices[i].getModel()!=null && model != null){
                        if (model.compareTo(devices[i].getModel())!=0){
                            devices[i]=null;
                        }
                    }
                    else if (devices[i].getModel()!=model){
                        devices[i]=null;
                    }

                }
            }
        }
    }

    @Override
    public boolean isValidDeviceForInsertToRack(Device device) {
        if (device == null){
            return false;
        }
        if (device.getIn()>0){
            return true;
        }
        return false;
    }
}
