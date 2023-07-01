package com.isa.pl.redbugs.service;

import com.isa.pl.redbugs.model.Route;
import com.isa.pl.redbugs.model.Stop;
import com.isa.pl.redbugs.repository.RouteRepository;
import com.isa.pl.redbugs.repository.StopRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RouteService {
    private StopRepository stopRepository;
    private RouteRepository routeRepository;

    public RouteService(StopRepository stopRepository, RouteRepository routeRepository) {
        this.stopRepository = stopRepository;
        this.routeRepository = routeRepository;
    }

    public List<Stop> stopsOnRoute(String routeId) {

        List<Stop> getStops =  stopRepository.findAll();
        Optional<Route> route = routeRepository.findById(routeId);
        List<String> stopList = route.get().getStops();

        List<Stop> getStopsNameOnRoute = new ArrayList<>();

        for (int i = 0; i < getStops.size(); i++) {
            for (int x = 0; x < stopList.size(); x++) {
                if (stopList.get(x).equals(getStops.get(i).getStopName())) {
                    getStopsNameOnRoute.add(getStops.get(i));
                }
            }
        }

        return getStopsNameOnRoute;
    }
}