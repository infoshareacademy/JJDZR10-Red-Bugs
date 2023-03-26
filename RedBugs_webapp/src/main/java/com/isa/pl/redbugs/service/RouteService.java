package com.isa.pl.redbugs.service;

import com.isa.pl.redbugs.model.Route;
import java.io.IOException;
import java.util.List;


public class RouteService {

//    public Route createRoute(long routeId, long numberVehicle, String nameRoute, long[] stops) {
//        return new Route(routeId, numberVehicle, nameRoute, stops); // should the created route be added to list in InitData?
//    }

    public void deleteRoute(long idOfRoute) throws IOException {
        Route route = new Route();
        Route routeToDelete = route.findRouteById(idOfRoute);
        findAllRoutes().remove(routeToDelete);
        }


    public List<Object> findAllRoutes() throws IOException {
        ReadService rs = new ReadService();
        return rs.readJson("Routes.json", Route[].class);
    }
}