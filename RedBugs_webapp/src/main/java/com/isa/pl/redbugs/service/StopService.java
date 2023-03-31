package com.isa.pl.redbugs.service;

import com.isa.pl.redbugs.model.Stop;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class StopService {

    private WriteService ws;
    private ReadService rs;

    public StopService(WriteService ws) {
        this.ws = ws;
    }

    public StopService(ReadService rs) {
        this.rs = rs;
    }

    public StopService() {
    }

    public void createStop(Stop stop) throws IOException {
        List<Stop> allStops = new ArrayList(rs.readJson("Stops.json", Stop[].class));
        allStops.add(stop);
        ws.writeToJson(allStops, "Stops.json");
    }

    public void deleteStop(long idOfStop) throws IOException {
        Stop stopToDelete = findStopById(idOfStop);
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