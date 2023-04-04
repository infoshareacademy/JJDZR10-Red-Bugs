package com.isa.pl.redbugs.service;

import com.isa.pl.redbugs.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InitDataService {
    public static List<Stop> stopsDataList() {
        List<Stop> stops = new ArrayList<>();
        stops.add(new Stop("1", "Dąbrowa Centrum", new Schedule(), 54.35483, 54.35483 ));

        return stops;
    }

    public static List<Vehicle> vehiclesDataList() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle(11, "Siedlce - Stara Piła", VehicleType.Bus));
        vehicles.add(new Vehicle(22, "Dworzec Główny - Pruszcz Komarowo", VehicleType.Bus));
        vehicles.add(new Vehicle(33, "Dworzec Główny - Pruszcz Matejki", VehicleType.Bus));
        vehicles.add(new Vehicle(44, "Port Lotniczy - Sopot Kamienny", VehicleType.Bus));
        vehicles.add(new Vehicle(55, "Wrzeszcz PKP - Żukowo Urząd Gminy", VehicleType.Bus));
        vehicles.add(new Vehicle(66, "Siedlce - Stara Piła", VehicleType.Tram));
        vehicles.add(new Vehicle(77, "Dworzec Główny - Pruszcz Komarowo", VehicleType.Tram));
        vehicles.add(new Vehicle(88, "Dworzec Główny - Pruszcz Matejki", VehicleType.Tram));
        vehicles.add(new Vehicle(99, "Port Lotniczy - Sopot Kamienny", VehicleType.Tram));
        vehicles.add(new Vehicle(10, "Wrzeszcz PKP - Żukowo Urząd Gminy", VehicleType.Tram));
        return vehicles;
    }

    public static List<Route> routesDataList() {
        List<Route> routes = new ArrayList<>();
        routes.add(new Route(21, 11, "Siedlce - Stara Piła", new long[]{1, 3, 5, 7, 2, 8}));
        routes.add(new Route(22, 22, "Port Lotniczy - Sopot Kamienny", new long[]{4, 3, 7, 9, 10}));
        routes.add(new Route(23, 33, "Dworzec Główny - Pruszcz Matejki", new long[]{1, 2, 3, 8}));
        routes.add(new Route(24, 44, "Wrzeszcz PKP - Żukowo Urząd Gminy", new long[]{5, 7, 2, 8, 10}));
        routes.add(new Route(25, 55, "Dworzec Główny - Pruszcz Komarowo", new long[]{1, 7, 2, 8, 9, 4}));
        routes.add(new Route(26, 66, "Siedlce - Stara Piła 1", new long[]{1, 3, 7, 2, 8}));
        routes.add(new Route(27, 77, "Port Lotniczy - Sopot Kamienny 2", new long[]{2, 4, 3, 7, 9, 10}));
        routes.add(new Route(28, 88, "Dworzec Główny - Pruszcz Matejki 3", new long[]{1, 2, 3, 9, 8}));
        routes.add(new Route(29, 99, "Wrzeszcz PKP - Żukowo Urząd Gminy 4", new long[]{5, 7, 2, 8, 10}));
        routes.add(new Route(30, 100, "Dworzec Główny - Pruszcz Komarowo 5", new long[]{1, 2, 8, 9, 4}));
        return routes;
    }

    public void writeInitializedDataToJson() throws IOException {
        WriteService ws = new WriteService();
        ws.writeToJson(InitDataService.stopsDataList(),"Stops.json");
        ws.writeToJson(InitDataService.vehiclesDataList(),"Vehicles.json");
        ws.writeToJson(InitDataService.routesDataList(),"Routes.json");
    }
}
