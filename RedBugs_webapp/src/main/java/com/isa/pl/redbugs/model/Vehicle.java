package com.isa.pl.redbugs.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Getter
@Setter

public class Vehicle {
    @Id
    private long vehicleId;
    private String vehicleName;
    private VehicleType type;

    @Override
    public String toString() {
        return "VehicleId: " + vehicleId +
                ", Name: " + vehicleName +
                ", type: " + type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle vehicle)) return false;
        return vehicleId == vehicle.vehicleId && Objects.equals(vehicleName, vehicle.vehicleName)
                && type == vehicle.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleId, vehicleName, type);
    }
}
