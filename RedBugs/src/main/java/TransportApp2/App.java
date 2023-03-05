package TransportApp2;



import Data.Route;
import TransportApp2.model.Stop;
import Data.Vehicle;
import Data.VehicleType;

import java.util.ArrayList;
import java.util.List;
public class App {


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

        for (Data.Route.Route route : routes) {
            for (long stopId : route.getStops())
                if (stop.getStopId() == stopId) {
                    result.add(route.getNameRoute());
                }
        }

        return result;
    }

    // found stops on the rout
    public static ArrayList<Stop> getStopsOnTheRoute(Data.Route.Route route) {
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


