package com.isa.pl.redbugs.service.pathfinding;

import com.isa.pl.redbugs.service.exception.NodeNotFoundException;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Graph<T extends GraphNode> {
    private final Set<T> nodes;

    private final Map<String, Set<String>> connections;

    public Graph(Set<T> nodes, Map<String, Set<String>> connections) {
        this.nodes = nodes;
        this.connections = connections;
    }

    public T getNode(String stopId) {
        return nodes.stream()
                .filter(node -> node.getStopId().equals(stopId))
                .findFirst()
                .orElseThrow(() -> new NodeNotFoundException(stopId));
    }

    public Set<T> getConnections(T node) {
        return connections.get(node.getStopId()).stream()
                .map(this::getNode)
                .collect(Collectors.toSet());
    }
}
