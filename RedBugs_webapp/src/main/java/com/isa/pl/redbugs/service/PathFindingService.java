package com.isa.pl.redbugs.service;

import com.isa.pl.redbugs.model.Route;
import com.isa.pl.redbugs.model.Stop;
import com.isa.pl.redbugs.service.pathfinding.DistanceScorer;
import com.isa.pl.redbugs.service.pathfinding.Graph;
import com.isa.pl.redbugs.service.pathfinding.RouteFinder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PathFindingService {

    public Graph<Stop> setUpStopsAndConnections() throws Exception {
        Set<Stop> stops = InitDataService.stopsDataList().stream().collect(Collectors.toSet());
        Set<Route> routes = InitDataService.routesDataList().stream().collect(Collectors.toSet());
        Map<String, Set<String>> connections = new HashMap<>();


        stops.forEach(stop -> {
            connections.put(stop.getStopId(), new HashSet<>());
        });


        stops.forEach(stop -> {

            routes.forEach(route -> {
                for (int i = 0; i < route.getStops().length; i++) {
                    if (route.getStops()[i].equals(stop.getStopId())) {
                        Set<String> stopConnection = connections.get(stop.getStopId());

                        if (i == 0) {
                            stopConnection.add(route.getStops()[i + 1]);
                        } else if (i > 0 && i < route.getStops().length - 1) {
                            stopConnection.add(route.getStops()[i - 1]);
                            stopConnection.add(route.getStops()[i + 1]);
                        } else if (i == route.getStops().length - 1) {
                            stopConnection.add(route.getStops()[i - 1]);
                        }
                    }
                }
            });
        });


        return new Graph<>(stops, connections);

    }

    public void calculateShortestRoute(String startId, String endId) throws Exception {
        Graph<Stop> stopsGraph = setUpStopsAndConnections();
        RouteFinder<Stop> routeFinder = new RouteFinder<>(stopsGraph, new DistanceScorer(), new DistanceScorer());
        List<Stop> route = routeFinder.findRoute(stopsGraph.getNode(startId), stopsGraph.getNode(endId));
        route.stream().map(Stop::getStopName).collect(Collectors.toList()).forEach(stop -> System.out.println(stop));
    }
}
