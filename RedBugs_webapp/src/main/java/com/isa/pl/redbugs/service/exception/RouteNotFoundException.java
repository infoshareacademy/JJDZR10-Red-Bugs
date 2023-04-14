package com.isa.pl.redbugs.service.exception;

public class RouteNotFoundException extends RuntimeException {
    public RouteNotFoundException() {

        super("Route not found");
    }
}
