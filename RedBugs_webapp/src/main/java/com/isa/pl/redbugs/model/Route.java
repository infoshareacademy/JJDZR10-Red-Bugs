package com.isa.pl.redbugs.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Route {

    private long routeId;
    private long vehicleNumber;
    private String routeName;
    private String[] stops;

    public Route(long routeId, long numberVehicle, String nameRoute, String[] stops) {
        this.routeId = routeId;
        this.vehicleNumber = numberVehicle;
        this.routeName = nameRoute;
        this.stops = stops;
    }

    public Route() {
    }

    private static List<Stop> stopList = new ArrayList<>();

    public static List<Stop> getStopList() {
        return stopList;
    }

    public static void setStopList(List<Stop> stopList) {
        Route.stopList = stopList;
    }

    public long getRouteId() {
        return routeId;
    }

    public void setRouteId(long routeId) {
        this.routeId = routeId;
    }

    public long getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(long vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String[] getStops() {
        return stops;
    }

    public void setStops(String[] stops) {
        this.stops = stops;
    }

    @Override
    public String toString() {
        return "Route{" +
                "routeId=" + routeId +
                ", numberVehicle=" + vehicleNumber +
                ", nameRoute='" + routeName + '\'' +
                ", stops=" + Arrays.toString(stops) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        if (routeId != route.routeId) return false;
        if (vehicleNumber != route.vehicleNumber) return false;
        if (!Objects.equals(routeName, route.routeName)) return false;
        return Arrays.equals(stops, route.stops);
    }

    @Override
    public int hashCode() {
        int result = (int) (routeId ^ (routeId >>> 32));
        result = 31 * result + (int) (vehicleNumber ^ (vehicleNumber >>> 32));
        result = 31 * result + (routeName != null ? routeName.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(stops);
        return result;
    }
}

