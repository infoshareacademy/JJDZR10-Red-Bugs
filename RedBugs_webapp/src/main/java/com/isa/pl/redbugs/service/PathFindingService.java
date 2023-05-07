package com.isa.pl.redbugs.service;

import com.isa.pl.redbugs.model.Route;
import com.isa.pl.redbugs.model.Stop;
import com.isa.pl.redbugs.service.pathfinding.DistanceScorer;
import com.isa.pl.redbugs.service.pathfinding.Graph;
import com.isa.pl.redbugs.service.pathfinding.RouteFinder;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public List<Stop> calculateShortestRoute(Set<Stop> stops, Set<Route> routes, String startId, String endId) throws Exception {
        Graph<Stop> stopsGraph = setUpStopsAndConnections(stops, routes);

        RouteFinder<Stop> routeFinder = new RouteFinder<>(stopsGraph, new DistanceScorer(), new DistanceScorer());
        return routeFinder.findRoute(stopsGraph.getNode(startId), stopsGraph.getNode(endId));
    }

    private void printRoute(List<Stop> route) {
        route.stream().map(Stop::getStopName).forEach(stop -> System.out.println(stop));
    }
}
