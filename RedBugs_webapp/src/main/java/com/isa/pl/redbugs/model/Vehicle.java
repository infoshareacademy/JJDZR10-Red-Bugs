package com.isa.pl.redbugs.model;


import com.isa.pl.redbugs.service.ReadService;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehicle vehicle = (Vehicle) o;

        if (vehicleId != vehicle.vehicleId) return false;
        if (!Objects.equals(vehicleName, vehicle.vehicleName)) return false;
        return type == vehicle.type;
    }

    @Override
    public int hashCode() {
        int result = (int) (vehicleId ^ (vehicleId >>> 32));
        result = 31 * result + (vehicleName != null ? vehicleName.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
