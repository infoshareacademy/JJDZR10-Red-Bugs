package com.isa.pl.redbugs.service;

import com.isa.pl.redbugs.model.Vehicle;
import com.isa.pl.redbugs.model.VehicleType;

import java.util.List;

public class VehicleService {

    private ReadService readService; // what should this field do?

    public static Vehicle createVehicle(long vehicleId, String vehicleName, VehicleType type) {
        return new Vehicle(vehicleId, vehicleName, type); // should the created vehicle be added to list in InitData?
    }

    public static List<Vehicle> deleteVehicle(List<Vehicle> listOfVehicles, long idOfVehicle) {
        for (int i = 0; i < listOfVehicles.size(); i++) {
            if (listOfVehicles.get(i).getVehicleId() == idOfVehicle) {
                listOfVehicles.remove(i);
                i--;
            }
        } return listOfVehicles;
    }

    public static List<Vehicle> findAllVehicles() {
        return InitDataService.vehiclesDataList();
    }




}
