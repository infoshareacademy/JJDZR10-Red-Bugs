package com.isa.pl.redbugs.service;

import com.isa.pl.redbugs.model.Vehicle;
import com.isa.pl.redbugs.model.VehicleType;

import java.util.List;

public class VehicleService {

    private ReadService readService;

    public void createVehicle(long vehicleId, String vehicleName, VehicleType type) {
        new Vehicle(vehicleId, vehicleName, type);
    }

    public void deleteVehicle() {
        //delete vehicle
    }

    public List<Vehicle> findAllVehicles() {

        return null;
    }
}
