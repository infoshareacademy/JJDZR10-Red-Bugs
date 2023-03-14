package Data.InitData;

import Data.Route;
import Data.Stop;
import Data.Vehicle;

import java.util.ArrayList;
import java.util.List;

import static Data.InitData.InitData.*;

public class MethodsData {

    public static void main(String[] args) {
        InitData.initData();

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

        showAllStops();
        showAllVehicles();


    }
    // show all vehicles
    public static void showAllVehicles() {
        ArrayList<Vehicle> vehicleArrayList = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            vehicleArrayList.add(vehicle);
        }

        vehicleArrayList.forEach(vehicle -> System.out.println(vehicle));
    }

    // show all stops
    public static void showAllStops() {
        ArrayList<Stop> stopArrayList = new ArrayList<>();

        for (Stop stop : stops) {
            stopArrayList.add(stop);
        }

        stopArrayList.forEach(stop -> System.out.println(stop));
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

}
