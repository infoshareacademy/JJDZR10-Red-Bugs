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

        //Connections withoout iterations are separeted within brackets - if connection is previously used, it will not
        //apper in further vehicle/routId

//vehicle 4 / routId 4

        connections.put("1013", Stream.of("1028").collect(Collectors.toSet()));
        connections.put("1028", Stream.of("1013", "14693", "1248").collect(Collectors.toSet()));
        connections.put("14693", Stream.of("1028", "1200").collect(Collectors.toSet()));
        connections.put("1200", Stream.of("14693", "1238").collect(Collectors.toSet()));
        connections.put("1238", Stream.of("1200", "1239").collect(Collectors.toSet()));
        connections.put("1239", Stream.of("1238", "1241").collect(Collectors.toSet()));
        connections.put("1241", Stream.of("1239", "1252").collect(Collectors.toSet()));
        connections.put("1252", Stream.of("1241", "130").collect(Collectors.toSet()));
        connections.put("130", Stream.of("1252", "1247").collect(Collectors.toSet()));
        connections.put("1247", Stream.of("130", "1717", "1254").collect(Collectors.toSet()));
        connections.put("1717", Stream.of("1247", "1861", "1314").collect(Collectors.toSet()));
        connections.put("1861", Stream.of("1717", "1863").collect(Collectors.toSet()));
        connections.put("1863", Stream.of("1861", "1865").collect(Collectors.toSet()));
        connections.put("1865", Stream.of("1863", "1314").collect(Collectors.toSet()));

//vehicle 14 / routId 14

        connections.put("1248", Stream.of("1028", "1250").collect(Collectors.toSet()));
        connections.put("1250", Stream.of("1248", "1254").collect(Collectors.toSet()));
        connections.put("1254", Stream.of("1250", "1247").collect(Collectors.toSet()));
        connections.put("1314", Stream.of("1717", "1865").collect(Collectors.toSet()));

        return new Graph<>(stops, connections);
    }

    public void calculateShortestRoute(String startId, String endId) throws Exception {
        Graph<Stop> stopsGraph = setUpStopsAndConnections();
        RouteFinder<Stop> routeFinder = new RouteFinder<>(stopsGraph, new DistanceScorer(), new DistanceScorer());
        List<Stop> route = routeFinder.findRoute(stopsGraph.getNode(startId), stopsGraph.getNode(endId));
        route.stream().map(Stop::getStopName).collect(Collectors.toList()).forEach(stop -> System.out.println(stop));
    }
}
