package Data;

import Data.VehicleType;

public class Vehicle {
    private long vehicleId;
    private String vehicleName;
    private VehicleType type;

    public Vehicle(long vehicleId, String vehicleName, VehicleType type) {
        this.vehicleId = vehicleId;
        this.vehicleName = vehicleName;
        this.type = type;
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
