package com.isa.pl.redbugs.model;

import com.isa.pl.redbugs.service.ReadService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Route {

    private long routeId;
    private long numberVehicle;
    private String nameRoute;
    private long[] stops;

    public Route(long routeId, long numberVehicle, String nameRoute, long[] stops) {
        this.routeId = routeId;
        this.numberVehicle = numberVehicle;
        this.nameRoute = nameRoute;
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

    public long getNumberVehicle() {
        return numberVehicle;
    }

    public void setNumberVehicle(long numberVehicle) {
        this.numberVehicle = numberVehicle;
    }

    public String getNameRoute() {
        return nameRoute;
    }

    public void setNameRoute(String nameRoute) {
        this.nameRoute = nameRoute;
    }

    public long[] getStops() {
        return stops;
    }

    public void setStops(long[] stops) {
        this.stops = stops;
    }

    @Override
    public String toString() {
        return "Route{" +
                "routeId=" + routeId +
                ", numberVehicle=" + numberVehicle +
                ", nameRoute='" + nameRoute + '\'' +
                ", stops=" + Arrays.toString(stops) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        if (routeId != route.routeId) return false;
        if (numberVehicle != route.numberVehicle) return false;
        if (!Objects.equals(nameRoute, route.nameRoute)) return false;
        return Arrays.equals(stops, route.stops);
    }

    @Override
    public int hashCode() {
        int result = (int) (routeId ^ (routeId >>> 32));
        result = 31 * result + (int) (numberVehicle ^ (numberVehicle >>> 32));
        result = 31 * result + (nameRoute != null ? nameRoute.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(stops);
        return result;
    }
}

