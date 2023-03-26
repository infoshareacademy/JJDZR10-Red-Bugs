package com.isa.pl.redbugs.service;

import com.isa.pl.redbugs.model.Route;
import com.isa.pl.redbugs.model.Schedule;
import com.isa.pl.redbugs.model.Stop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StopService {

    public void createStop(Stop stop) throws IOException {
        ReadService rs = new ReadService();
        List<Stop> allStops = new ArrayList(rs.readJson("Stops.json", Stop[].class));
        allStops.add(stop);
        WriteService ws = new WriteService();
        ws.writeToJson(allStops, "Stops.json");
    }

    public void deleteStop(long idOfStop) throws IOException {
        Stop stopToDelete = new Stop().findStopById(idOfStop);
        List<Stop> allStops = new ArrayList(findAllStops());
        allStops.remove(stopToDelete);
        WriteService ws = new WriteService();
        ws.writeToJson(allStops, "Stops.json");
    }

    public List<Stop> findAllStops() throws IOException {
        ReadService rs = new ReadService();
        return rs.readJson("Stops.json", Stop[].class);
    }
}