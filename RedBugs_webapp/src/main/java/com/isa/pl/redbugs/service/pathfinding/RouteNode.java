package com.isa.pl.redbugs.service.pathfinding;

class RouteNode<T extends GraphNode> implements Comparable<RouteNode> {
    private final T current;
    private T previous;
    private double routeScore;
    private double estimatedScore;

    RouteNode(T current) {
        this(current, null, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    RouteNode(T current, T previous, double routeScore, double estimatedScore) {
        this.current = current;
        this.previous = previous;
        this.routeScore = routeScore;
        this.estimatedScore = estimatedScore;
    }

    T getCurrent() {
        return current;
    }

    T getPrevious() {
        return previous;
    }

    double getRouteScore() {
        return routeScore;
    }

    double getEstimatedScore() {
        return estimatedScore;
    }

    void setPrevious(T previous) {
        this.previous = previous;
    }

    void setRouteScore(double routeScore) {
        this.routeScore = routeScore;
    }

    void setEstimatedScore(double estimatedScore) {
        this.estimatedScore = estimatedScore;
    }

    @Override
    public int compareTo(RouteNode other) {
        if (this.estimatedScore > other.estimatedScore) {
            return 1;
        } else if (this.estimatedScore < other.estimatedScore) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "RouteNode{" +
                "current=" + current +
                ", previous=" + previous +
                ", routeScore=" + routeScore +
                ", estimatedScore=" + estimatedScore +
                '}';
    }
}
