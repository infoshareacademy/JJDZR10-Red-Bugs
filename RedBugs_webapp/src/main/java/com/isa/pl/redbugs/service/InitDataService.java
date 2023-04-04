package com.isa.pl.redbugs.service;

import com.isa.pl.redbugs.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InitDataService {
    public static List<Stop> stopsDataList() {
        List<Stop> stops = new ArrayList<>();
        stops.add(new Stop("1013", "Dworzec Główny", new Schedule(), 54.35483, 18.64512));
        stops.add(new Stop("1028", "Brama Wyżynna", new Schedule(), 54.35037, 18.64631));
        stops.add(new Stop("14693", "Toruńska", new Schedule(), 54.34472, 18.64505));
        stops.add(new Stop("1200", "Zaroślak", new Schedule(), 54.34162, 18.64267));
        stops.add(new Stop("1238", "Cmentarna", new Schedule(), 54.34079, 18.63566));
        stops.add(new Stop("1239", "Stoczniowców", new Schedule(), 54.34325, 18.63179));
        stops.add(new Stop("1241", "Wronki", new Schedule(), 54.34225, 18.62831));
        stops.add(new Stop("1252", "Worcella", new Schedule(), 54.34113, 18.62638));
        stops.add(new Stop("130", "Chełm Cienista", new Schedule(), 54.33831, 18.627));
        stops.add(new Stop("1247", "Sikorskiego", new Schedule(), 54.33892, 18.61883));
        stops.add(new Stop("1717", "Cieszyńskiego", new Schedule(), 54.3384, 18.60993));
        stops.add(new Stop("1861", "Osiedle Jary", new Schedule(), 54.33549, 18.60115));
        stops.add(new Stop("1863", "Rogalińska", new Schedule(), 54.33107, 18.60045));
        stops.add(new Stop("1865", "Płocka", new Schedule(), 54.34842, 18.60002));
        stops.add(new Stop("1248", "Pohulanka", new Schedule(), 54.33892, 18.63687));
        stops.add(new Stop("1250", "Odrzańska", new Schedule(), 54.34515, 18.62554));
        stops.add(new Stop("1254", "Chałubińskiego", new Schedule(), 54.34221, 18.61793));
        stops.add(new Stop("1314", "Przemyska", new Schedule(), 54.33344, 18.59615));
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
