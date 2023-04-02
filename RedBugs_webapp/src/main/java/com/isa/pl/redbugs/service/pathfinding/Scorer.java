package com.isa.pl.redbugs.service.pathfinding;

public interface Scorer<T extends GraphNode> {
    double computeCost(T from, T to);
}
