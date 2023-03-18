package com.isa.pl.redbugs.service;

import com.isa.pl.redbugs.model.Route;

import java.util.List;

public class RouteService {

    public void createRoute(long routeId, long numberVehicle, String nameRoute, long[] stops){
        new Route(routeId, numberVehicle, nameRoute, stops);
    }

    public void deleteRoute(){
        //delete route
    }

    public List<Route> findAllRoutes() {

        return null;
    }
}