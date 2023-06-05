package com.isa.pl.redbugs.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Vehicle {
    @Id
    private long vehicleId;
    private String vehicleName;
    private VehicleType type;
}
