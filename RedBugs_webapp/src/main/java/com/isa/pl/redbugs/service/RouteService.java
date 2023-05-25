package com.isa.pl.redbugs.service;

import com.isa.pl.redbugs.model.Route;
import com.isa.pl.redbugs.service.exception.RouteNotFoundException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class RouteService {

//    private final WriteService ws;
//    private final ReadService rs;

//    public RouteService(WriteService ws, ReadService rs) {
//        this.ws = ws;
//        this.rs = rs;
//    }

//    public List<Route> findAllRoutes() throws IOException {
//        return rs.readJson("Routes.json", Route[].class);
//    }

//    public Route findRouteById(String id) throws IOException {
//        List<Route> allRoutes = findAllRoutes();
//
//        return allRoutes.stream()
//                .filter(route -> route.getRouteId() == id)
//                .findFirst()
//                .orElseThrow(() -> new RouteNotFoundException(String.format("Route with id %s not found", id)));
//    }

//    public List<String> findAllStopsOnRoute(String routeId) throws IOException {
//        List<String> stopsOnRoute = new ArrayList<>();
//        Route route = findRouteById(routeId);
//
//        for (int i = 0; i < route.getStops().size(); i++) {
//            int finalI = i;
//            new StopService(ws, rs).findAllStops().forEach(stop -> {
//                if (route.getStops().get(finalI).equals(stop.getStopId())) {
//                    stopsOnRoute.add(stop.getStopName());
//                }
//            });
//        }
//        return stopsOnRoute;
//    }

//    public void editRouteById(String routeId, Route route) throws IOException {
//        Route routeToEdit = findRouteById(routeId);
//
//        routeToEdit.setRouteId(route.getRouteId());
//        routeToEdit.setRouteName(route.getRouteName());
//        routeToEdit.setVehicleNumber(route.getVehicleNumber());
//        routeToEdit.setStops(route.getStops());
//    }

}