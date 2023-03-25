package com.isa.pl.redbugs.service;

import com.isa.pl.redbugs.model.Route;

import java.io.IOException;
import java.util.List;

public class RouteService {

//    public Route createRoute(long routeId, long numberVehicle, String nameRoute, long[] stops) {
//        return new Route(routeId, numberVehicle, nameRoute, stops); // should the created route be added to list in InitData?
//    }

    public static List<Route> deleteRoute(List<Route> listOfRoutes, long idOfRoute) {
        for (int i = 0; i < listOfRoutes.size(); i++) {
            if (listOfRoutes.get(i).getRouteId() == idOfRoute) {
                listOfRoutes.remove(i);
                i--;
            }
        } return listOfRoutes;
    }

    public List<Object> findAllRoutes() throws IOException {
        return ReadService.readJson("Routes.json");
    }
}