package com.isa.pl.redbugs.service;

import com.isa.pl.redbugs.model.Route;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public class RouteService {

    public void createRoute(Route route) throws IOException {
        ReadService rs = new ReadService();
        List<Route> allRoutes = new ArrayList(rs.readJson("Routes.json", Route[].class));
        allRoutes.add(route);
        WriteService ws = new WriteService();
        ws.writeToJson(allRoutes, "Routes.json");
    }

    public void deleteRoute(long idOfRoute) throws IOException {
        Route routeToDelete = new RouteService().findRouteById(idOfRoute);
        List<Route> allRoutes = new ArrayList(findAllRoutes());
        allRoutes.remove(routeToDelete);
        WriteService ws = new WriteService();
        ws.writeToJson(allRoutes, "Routes.json");
    }


    public List<Route> findAllRoutes() throws IOException {
        ReadService rs = new ReadService();
        return rs.readJson("Routes.json", Route[].class);
    }

    public Route findRouteById(long id) throws IOException {
        ReadService rs = new ReadService();
        List<Route> allRoutes = rs.readJson("Routes.json", Route[].class);

        return allRoutes.stream()
                .filter(route -> route.getRouteId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Route with id " + id + " not found"));
    }
}