package com.isa.pl.redbugs.service;

import com.isa.pl.redbugs.model.Route;
import com.isa.pl.redbugs.model.Stop;

import java.util.List;

public class StopService {

    public Stop createStop(long stopId, String stopName) {
        return new Stop(stopId, stopName);
    }

    public static List<Stop> deleteStop(List<Stop> listOfStops, long idOfStop) {
        for (int i = 0; i < listOfStops.size(); i++) {
            if (listOfStops.get(i).getStopId() == idOfStop) {
                listOfStops.remove(i);
                i--;
            }
        } return listOfStops;
    }

    public List<Stop> findAllStops() {
        return InitDataService.stopsDataList();
    }
}