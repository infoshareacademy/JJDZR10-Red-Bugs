package com.isa.pl.redbugs.service;

import com.isa.pl.redbugs.model.Route;
import com.isa.pl.redbugs.model.Schedule;
import com.isa.pl.redbugs.model.Stop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class StopService {

    ReadService rs = new ReadService();
    WriteService ws = new WriteService();

    public void createStop(Stop stop) throws IOException {
        List<Stop> allStops = new ArrayList(rs.readJson("Stops.json", Stop[].class));
        allStops.add(stop);
        ws.writeToJson(allStops, "Stops.json");
    }

    public void deleteStop(long idOfStop) throws IOException {
        Stop stopToDelete = new StopService().findStopById(idOfStop);
        List<Stop> allStops = new ArrayList(findAllStops());
        allStops.remove(stopToDelete);
        ws.writeToJson(allStops, "Stops.json");
    }

    public List<Stop> findAllStops() throws IOException {
        return rs.readJson("Stops.json", Stop[].class);
    }

    public Stop findStopById(long id) throws IOException {
        List<Stop> allStops = rs.readJson("Stops.json", Stop[].class);

        return allStops.stream()
                .filter(route -> route.getStopId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Stop with id " + id + " not found"));
    }
}