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

    public Graph<Stop> setUpStopsAndConnections() throws Exception {
        Set<Stop> stops = InitDataService.stopsDataList().stream().collect(Collectors.toSet());
        Map<String, Set<String>> connections = new HashMap<>();

        connections.put("1013", Stream.of("1028").collect(Collectors.toSet()));
        connections.put("1028", Stream.of("1013", "14693", "1248").collect(Collectors.toSet()));
        connections.put("14693", Stream.of("1028", "1200").collect(Collectors.toSet()));

        return new Graph<>(stops, connections);
    }
    public void calculateShortestRoute(String startId, String endId) throws Exception {
        Graph<Stop> stopsGraph = setUpStopsAndConnections();
        RouteFinder<Stop> routeFinder = new RouteFinder<>(stopsGraph, new DistanceScorer(), new DistanceScorer());
        List<Stop> route = routeFinder.findRoute(stopsGraph.getNode(startId), stopsGraph.getNode(endId));
        route.stream().map(Stop::getStopName).collect(Collectors.toList()).forEach(stop -> System.out.println(stop));
    }
}
