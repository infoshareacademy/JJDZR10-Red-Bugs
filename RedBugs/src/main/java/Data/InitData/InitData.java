package Data.InitData;

import Data.Route;
import Data.Stop;
import Data.Vehicle;
import Data.VehicleType;

import java.util.ArrayList;

public class InitData {
    static ArrayList<Stop> stops = new ArrayList<>();
    static ArrayList<Vehicle> vehicles = new ArrayList<>();
    static ArrayList<Route> routes = new ArrayList<>();

    public static void initData() {
        stops.add(new Stop(1, "Dąbrowa Centrum"));
        stops.add(new Stop(2, "Gdynia Kameliowa"));
        stops.add(new Stop(3, "Paprykowa"));
        stops.add(new Stop(4, "Szafranowa"));
        stops.add(new Stop(5, "Centrum Nadawcze RTV"));
        stops.add(new Stop(6, "Chwaszczyno"));
        stops.add(new Stop(7, "Gdynia Szafranowa"));
        stops.add(new Stop(8, "Dziewicza"));
        stops.add(new Stop(9, "Pogórze - Szkolna"));
        stops.add(new Stop(10, "Dąbka - Zielona"));

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

        routes.add(new Route(21, 11, "Siedlce - Stara Piła", new long[]{1, 3, 5, 7, 2, 8}));
        routes.add(new Route(22, 22, "Port Lotniczy - Sopot Kamienny", new long[]{4, 3, 7, 9, 10}));
        routes.add(new Route(23, 33, "Dworzec Główny - Pruszcz Matejki", new long[]{1, 2, 3, 8}));
        routes.add(new Route(24, 44, "Wrzeszcz PKP - Żukowo Urząd Gminy", new long[]{5, 7, 2, 8, 10}));
        routes.add(new Route(25, 55, "Dworzec Główny - Pruszcz Komarowo", new long[]{1, 7, 2, 8, 9, 4}));
        routes.add(new Route(26, 66, "Siedlce - Stara Piła 1", new long[]{1, 3, 7, 2, 8}));
        routes.add(new Route(27, 77, "Port Lotniczy - Sopot Kamienny 2", new long[]{2, 4, 3, 7, 9, 10}));
        routes.add(new Route(28, 88, "Dworzec Główny - Pruszcz Matejki 3", new long[]{1, 2, 3,9, 8}));
        routes.add(new Route(29, 99, "Wrzeszcz PKP - Żukowo Urząd Gminy 4", new long[]{5, 7, 2, 8, 10}));
        routes.add(new Route(30, 100, "Dworzec Główny - Pruszcz Komarowo 5", new long[]{1, 2, 8, 9, 4}));


    }
}
