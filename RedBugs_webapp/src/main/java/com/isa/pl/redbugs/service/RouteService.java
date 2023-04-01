package com.isa.pl.redbugs.service;

import com.isa.pl.redbugs.model.Route;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class RouteService {

    private WriteService ws;
    private ReadService rs;

    public RouteService(WriteService ws, ReadService rs) {
        this.ws = ws;
        this.rs = rs;
    }

    public RouteService() {
    }

    public void createRoute(Route route) throws IOException {
        List<Route> allRoutes = new ArrayList(rs.readJson("Routes.json", Route[].class));
        allRoutes.add(route);
        ws.writeToJson(allRoutes, "Routes.json");
    }

    public void deleteRoute(long idOfRoute) throws IOException {
        Route routeToDelete = findRouteById(idOfRoute);
        List<Route> allRoutes = new ArrayList(findAllRoutes());
        allRoutes.remove(routeToDelete);
        ws.writeToJson(allRoutes, "Routes.json");
    }


    public List<Route> findAllRoutes() throws IOException {
        return rs.readJson("Routes.json", Route[].class);
    }

    public Route findRouteById(long id) throws IOException {
        List<Route> allRoutes = rs.readJson("Routes.json", Route[].class);

        return allRoutes.stream()
                .filter(route -> route.getRouteId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Route with id " + id + " not found"));
    }
}