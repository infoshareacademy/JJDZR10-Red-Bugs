package com.isa.pl.redbugs.service;

import com.isa.pl.redbugs.model.Route;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class RouteService {

//    public Route createRoute(long routeId, long numberVehicle, String nameRoute, long[] stops) {
//        return new Route(routeId, numberVehicle, nameRoute, stops); // should the created route be added to list in InitData?
//    }

    public void deleteRoute(long idOfRoute) throws IOException {
        Route routeToDelete = new Route().findRouteById(idOfRoute);
        List<Route> allRoutes = new ArrayList(findAllRoutes());
        allRoutes.remove(routeToDelete);
        WriteService ws = new WriteService();
        ws.writeToJson(allRoutes, "Routes.json");
    }


    public List<Route> findAllRoutes() throws IOException {
        ReadService rs = new ReadService();
        return rs.readJson("Routes.json", Route[].class);
    }
}