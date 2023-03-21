package com.isa.pl.redbugs.service;

import com.isa.pl.redbugs.model.Route;

import java.util.List;

public class RouteService {

    public Route createRoute(long routeId, long numberVehicle, String nameRoute, long[] stops) {
        return new Route(routeId, numberVehicle, nameRoute, stops);
    }

    public void deleteRoute() {
        //delete route
    }

    public List<Route> findAllRoutes() {
        return InitDataService.routesDataList();
    }
}