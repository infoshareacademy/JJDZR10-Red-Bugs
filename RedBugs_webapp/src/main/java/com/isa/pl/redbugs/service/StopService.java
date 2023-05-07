package com.isa.pl.redbugs.service;

import com.isa.pl.redbugs.model.Stop;
import com.isa.pl.redbugs.service.exception.StopNotFoundException;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.List;

@Component
public class StopService {

    private final WriteService ws;
    private final ReadService rs;

    public StopService(WriteService ws, ReadService rs) {
        this.ws = ws;
        this.rs = rs;
    }

    public void createStop(Stop stop) throws IOException {
        List<Stop> allStops = findAllStops();
        allStops.add(stop);
        ws.writeToJson(allStops, "Stops.json");
    }

    public void deleteStop(String stopId) throws IOException {
        Stop stopToDelete = findStopById(stopId);
        List<Stop> allStops = findAllStops();
        allStops.remove(stopToDelete);
        ws.writeToJson(allStops, "Stops.json");
    }


    public List<Stop> findAllStops() throws IOException {
        return rs.readJson("Stops.json", Stop[].class);
    }

    public Stop findStopById(String stopId) throws IOException {
        List<Stop> allStops = findAllStops();

        return allStops.stream()
                .filter(route -> route.getStopId().equals(stopId))
                .findFirst()
                .orElseThrow(() -> new StopNotFoundException(String.format("Stop with id %s not found", stopId)));
    }
    public void saveStop(Stop stop) throws IOException {
        List<Stop> allStops = findAllStops();
        allStops.add(stop);
        ws.writeToJson(allStops, "Stops.json");
    }
}