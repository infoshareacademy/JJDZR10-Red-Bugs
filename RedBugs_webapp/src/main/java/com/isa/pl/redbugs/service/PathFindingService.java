package com.isa.pl.redbugs.service;

import com.isa.pl.redbugs.model.Stop;
import com.isa.pl.redbugs.service.pathfinding.DistanceScorer;
import com.isa.pl.redbugs.service.pathfinding.Graph;
import com.isa.pl.redbugs.service.pathfinding.RouteFinder;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PathFindingService {

    private final StopService stopService;

    public PathFindingService(StopService stopService) {
        this.stopService = stopService;
    }

    public Graph<Stop> setUpStopsAndConnections() throws Exception {
        Set<Stop> stops = stopService.findAllStops().stream().collect(Collectors.toSet());
        Map<String, Set<String>> connections = new HashMap<>();

        // TODO: task 39 to be done by Adam
        connections.put("1013", Stream.of("1028").collect(Collectors.toSet()));
        connections.put("1028", Stream.of("1013", "14693", "1248").collect(Collectors.toSet()));
        connections.put("14693", Stream.of("1028", "1200").collect(Collectors.toSet()));

        return new Graph<>(stops, connections);
    }
    public void calculateShortestRoute(String firstStopId, String lastStopId) throws Exception {
        Graph<Stop> stopsGraph = setUpStopsAndConnections();
        List<Stop> route = findShortestRoute(stopsGraph, firstStopId, lastStopId);
        printRoute(route);
    }

    private List<Stop> findShortestRoute(Graph<Stop> stopsGraph, String firstStopId, String lastStopId) {
        RouteFinder<Stop> routeFinder = new RouteFinder<>(stopsGraph, new DistanceScorer(), new DistanceScorer());
        return routeFinder.findRoute(stopsGraph.getNode(firstStopId), stopsGraph.getNode(lastStopId));
    }

    private void printRoute(List<Stop> route) {
        route.stream().map(Stop::getStopName).forEach(stop -> System.out.println(stop));
    }
}
