package com.isa.pl.redbugs.model;

import com.isa.pl.redbugs.service.ReadService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public static Route findRouteById(long id) throws IOException {
        ReadService rs = new ReadService();
        List<Route> castedRoutes = rs.readJson("Routes.json", Route[].class);
//        List<Route> castedRoutes = new ArrayList<>();
//        allRoutes.forEach(o -> {
////            if (o instanceof Route) {
//                Route route = (Route) o;
//                castedRoutes.add(route);
////            }
//        });
        for (int i = 0; i < castedRoutes.size(); i++) {
            if (castedRoutes.get(i).getRouteId() == id) {
                Route foundRoute = castedRoutes.get(i);
                return foundRoute;
            }
        }
        throw new RuntimeException("No route found");
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
}

