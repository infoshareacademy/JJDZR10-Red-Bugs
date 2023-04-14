package com.isa.pl.redbugs.service.exception;

public class StopNotFoundException extends RuntimeException {
    public StopNotFoundException(String stopId) {

        super(String.format("Stop with id %s not found", stopId));
    }
}
