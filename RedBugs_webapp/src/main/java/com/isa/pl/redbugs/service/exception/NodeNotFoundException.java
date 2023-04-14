package com.isa.pl.redbugs.service.exception;

public class NodeNotFoundException extends RuntimeException {
    public NodeNotFoundException(String stopId) {
        super(String.format("Node with id %s not found", stopId));
    }
}
