package com.isa.pl.redbugs.service.exception;

public class VehicleNotFoundException extends RuntimeException {
    public VehicleNotFoundException(long vehicleId) {

        super(String.format("Vehicle with id %d not found", vehicleId));
    }
}
