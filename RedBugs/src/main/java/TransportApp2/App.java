package TransportApp2;



import TransportApp2.model.Route;
import TransportApp2.model.Stop;
import TransportApp2.model.Vehicle;
import TransportApp2.model.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class App {
    static ArrayList<Stop> stops = new ArrayList<>();
    static ArrayList<Vehicle> vehicles = new ArrayList<>();
    static ArrayList<Route> routes = new ArrayList<>();

    public static void main(String[] args) {
        initData();

        System.out.println(getStopById(1));
        System.out.println(getStopById(3));

        System.out.println(getVehicleById(11));
        System.out.println(getVehicleById(33));

        System.out.println(getStopsOnTheRoute(routes.get(0)));


        ArrayList<Stop> listBusOnStop = getStopsOnTheRoute(routes.get(3));
        listBusOnStop.forEach(stop -> System.out.println(stop));

        System.out.println(getVehicleOnThisStop(getStopById(2)));


        List<String> stringListStops = getVehicleOnThisStop(getStopById(2));
        stringListStops.forEach(s -> System.out.println(s));

    }

    // found all vehicle on this Stop
    public static ArrayList<String> getVehicleOnThisStop(Stop stop) {
        ArrayList<String> result = new ArrayList<>();

        for (Route route : routes) {
            for (long stopId : route.getStops())
                if (stop.getStopId() == stopId) {
                    result.add(route.getNameRoute());
                }
        }

        return result;
    }

    // found stops on the rout
    public static ArrayList<Stop> getStopsOnTheRoute(Route route) {
        ArrayList<Stop> result = new ArrayList<>();

        for (long stopId : route.getStops()) {
            Stop stop = getStopById(stopId);
            if (stop != null ) {
                result.add(getStopById(stopId));
            }
        }

        return result;
    }


    //search for a Vehicle by its number
    public static Vehicle getVehicleById (long id) {
        Vehicle vehicleFound = null;

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleId() == id) {
                vehicleFound = vehicle;
                break;
            }
        }
        return vehicleFound;
    }

    //search for a stop by its number
    public static Stop getStopById(long id) {
        Stop stopFound = null;

        for (Stop stop : stops) {
            if (stop.getStopId() == id) {
                stopFound = stop;
                break;
            }
        }
        return stopFound;
    }

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

        routes.add(new Route(21, 11, "Siedlce - Stara Piła", new long[]{1, 3, 5, 7, 2, 8}));
        routes.add(new Route(22, 22, "Port Lotniczy - Sopot Kamienny", new long[]{4, 3, 7, 9, 10}));
        routes.add(new Route(23, 33, "Dworzec Główny - Pruszcz Matejki", new long[]{1, 2, 3, 8}));
        routes.add(new Route(24, 44, "Wrzeszcz PKP - Żukowo Urząd Gminy", new long[]{5, 7, 2, 8, 10}));
        routes.add(new Route(25, 55, "Dworzec Główny - Pruszcz Komarowo", new long[]{1, 7, 2, 8, 9, 4}));


    }
}

