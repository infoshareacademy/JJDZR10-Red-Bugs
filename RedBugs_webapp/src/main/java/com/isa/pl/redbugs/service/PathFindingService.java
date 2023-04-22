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

    public Graph<Stop> setUpStopsAndConnections(Set<Stop> stops, Set<Route> routes) throws Exception {
        Map<String, Set<String>> connections = new HashMap<>();

        for (Stop stop : stops) {
            connections.put(stop.getStopId(), new HashSet<>());
        }

        for (Route route : routes) {
            String[] routeStops = route.getStops();
            for (int i = 0; i < routeStops.length; i++) {
                String currentStopId = routeStops[i];
                Set<String> currentStopConnection = connections.get(currentStopId);
                if (i == 0) {
                    currentStopConnection.add(routeStops[i + 1]);
                } else if (i < routeStops.length - 1) {
                    currentStopConnection.add(routeStops[i - 1]);
                    currentStopConnection.add(routeStops[i + 1]);
                } else {
                    currentStopConnection.add(routeStops[i - 1]);
                }
            }
        }

        return new Graph<>(stops, connections);
    }


    public void calculateShortestRoute(Set<Stop> stops, Set<Route> routes, String startId, String endId) throws Exception {
        Graph<Stop> stopsGraph = setUpStopsAndConnections(stops, routes);
        RouteFinder<Stop> routeFinder = new RouteFinder<>(stopsGraph, new DistanceScorer(), new DistanceScorer());
        List<Stop> route = routeFinder.findRoute(stopsGraph.getNode(startId), stopsGraph.getNode(endId));
        route.stream().map(Stop::getStopName).collect(Collectors.toList()).forEach(stop -> System.out.println(stop));
    }
}
