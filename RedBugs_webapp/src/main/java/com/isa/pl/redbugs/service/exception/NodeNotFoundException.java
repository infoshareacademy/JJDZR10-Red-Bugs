package com.isa.pl.redbugs.service.exception;

public class NodeNotFoundException extends RuntimeException {
    public NodeNotFoundException(String stopId) {
        super(String.format("Node with given id %s not found", stopId));
    }
}
