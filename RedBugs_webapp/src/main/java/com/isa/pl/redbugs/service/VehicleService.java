package com.isa.pl.redbugs.service;

import com.isa.pl.redbugs.model.Vehicle;
import com.isa.pl.redbugs.model.VehicleType;

import java.io.IOException;
import java.util.List;

public class VehicleService {

    public Vehicle createVehicle(long vehicleId, String vehicleName, VehicleType type) {
        return new Vehicle(vehicleId, vehicleName, type); // should the created vehicle be added to list in InitData?
    }

    public void deleteVehicle(long idOfVehicle) throws IOException {
    }

    public List<Object> findAllVehicles() throws IOException {
        ReadService rs = new ReadService();
        return rs.readJson("Vehicles.json", Vehicle[].class);
    }




}
