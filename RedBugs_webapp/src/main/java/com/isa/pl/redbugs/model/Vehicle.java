package com.isa.pl.redbugs.model;


import com.isa.pl.redbugs.service.ReadService;

import java.io.IOException;
import java.util.List;

public class Vehicle {
    private long vehicleId;
    private String vehicleName;
    private VehicleType type;

    public Vehicle(long vehicleId, String vehicleName, VehicleType type) {
        this.vehicleId = vehicleId;
        this.vehicleName = vehicleName;
        this.type = type;
    }

    public Vehicle() {
    }

    public Vehicle findVehicleById(long id) throws IOException {
        ReadService rs = new ReadService();
        List<Vehicle> allVehicles = rs.readJson("Vehicles.json", Vehicle[].class);
        for (int i = 0; i < allVehicles.size(); i++) {
            if (allVehicles.get(i).getVehicleId() == id) {
                Vehicle foundVehicle = allVehicles.get(i);
                return foundVehicle;
            }
        }
        throw new RuntimeException("No vehicle found");
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "VehicleId: " + vehicleId +
                ", Name: " + vehicleName +
                ", type: " + type;
    }
}
