package com.isa.pl.redbugs.service;

import com.isa.pl.redbugs.model.Stop;

import java.util.List;

public class StopService {

    public void createStop(long stopId, String stopName) {
        new Stop(stopId, stopName);
    }

    public void deleteStop() {
        //delete stop
    }

    public List<Stop> findAllStops() {

        return null;
    }
}