package com.isa.pl.redbugs.service.pathfinding;

import com.isa.pl.redbugs.service.exception.RouteNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;


public class RouteFinder<T extends GraphNode> {
    private static final Logger LOGGER = LogManager.getLogger(RouteFinder.class);
    private final Graph<T> graph;
    private final Scorer<T> nextNodeScorer;
    private final Scorer<T> targetScorer;

    private Map<T, RouteNode<T>> allNodes = new HashMap<>();
    private Queue<RouteNode> openSet = new PriorityQueue<>();

    public RouteFinder(Graph<T> graph, Scorer<T> nextNodeScorer, Scorer<T> targetScorer) {
        this.graph = graph;
        this.nextNodeScorer = nextNodeScorer;
        this.targetScorer = targetScorer;
    }

    public List<T> findRoute(T from, T to) {
        createStartNode(from, to);

        while (!openSet.isEmpty()) {
            LOGGER.info("Open Set contains: " + openSet.stream().map(RouteNode::getCurrent).collect(Collectors.toSet()));
            RouteNode<T> next = openSet.poll();
            LOGGER.info("Looking at node: " + next);
            if (isDestinationReached(next, to)) {
                List<T> route = new ArrayList<>();
                RouteNode<T> current = next;
                do {
                    route.add(0, current.getCurrent());
                    current = allNodes.get(current.getPrevious());
                } while (current != null);

                LOGGER.info("Best route: " + route);
                return route;
            }

            graph.getConnections(next.getCurrent()).forEach(connection -> {
                double newScore = next.getRouteScore() + nextNodeScorer.computeCost(next.getCurrent(), connection);
                RouteNode<T> nextNode = allNodes.getOrDefault(connection, new RouteNode<>(connection));
                allNodes.put(connection, nextNode);

                if (nextNode.getRouteScore() > newScore) {
                    nextNode.setPrevious(next.getCurrent());
                    nextNode.setRouteScore(newScore);
                    nextNode.setEstimatedScore(newScore + targetScorer.computeCost(connection, to));
                    openSet.add(nextNode);
                    LOGGER.info("Found a better route to node: " + nextNode);
                }
            });
        }

        throw new RouteNotFoundException("Route not found");
    }

    private boolean isDestinationReached(RouteNode<T> next, T to) {
        if (next.getCurrent().equals(to)) {
            LOGGER.info("Destination found. Stop ID: " + to.getStopId());
            return true;
        } else {
            return false;
        }
    }

    private void createStartNode(T from, T to) {
        RouteNode<T> start = new RouteNode<>(from, null, 0d, targetScorer.computeCost(from, to));
        allNodes.put(from, start);
        openSet.add(start);
    }
}