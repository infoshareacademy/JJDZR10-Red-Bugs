package com.isa.pl.redbugs.service;

import com.isa.pl.redbugs.model.*;
import org.springframework.stereotype.Service;

import javax.persistence.GeneratedValue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service

public class InitDataService {
    public static List<Stop> stopsDataList() {
        List<Stop> stops = new ArrayList<>();
        stops.add(createStop("1013", "Dworzec Główny", 54.35483, 18.64512));
        stops.add(createStop("1028", "Brama Wyżynna", 54.35037, 18.64631));
        stops.add(createStop("14693", "Toruńska", 54.34472, 18.64505));
        stops.add(createStop("1200", "Zaroślak", 54.34162, 18.64267));
        stops.add(createStop("1238", "Cmentarna", 54.34079, 18.63566));
        stops.add(createStop("1239", "Stoczniowców", 54.34325, 18.63179));
        stops.add(createStop("1241", "Wronki", 54.34225, 18.62831));
        stops.add(createStop("1252", "Worcella", 54.34113, 18.62638));
        stops.add(createStop("130", "Chełm Cienista", 54.33831, 18.627));
        stops.add(createStop("1247", "Sikorskiego", 54.33892, 18.61883));
        stops.add(createStop("1717", "Cieszyńskiego", 54.3384, 18.60993));
        stops.add(createStop("1861", "Osiedle Jary", 54.33549, 18.60115));
        stops.add(createStop("1863", "Rogalińska", 54.33107, 18.60045));
        stops.add(createStop("1865", "Płocka", 54.34842, 18.60002));
        stops.add(createStop("1248", "Pohulanka", 54.33892, 18.63687));
        stops.add(createStop("1250", "Odrzańska", 54.34515, 18.62554));
        stops.add(createStop("1254", "Chałubińskiego", 54.34221, 18.61793));
        stops.add(createStop("1314", "Przemyska", 54.33344, 18.59615));
        return stops;
    }

    private static Stop createStop(String s, String name, double v, double v1) {
   Stop stop = new Stop();
   stop.setStopId(s);
   stop.setStopName(name);
   stop.setLatitude(v);
   stop.setLongitude(v1);

   return stop;





    }

    public static List<Vehicle> vehiclesDataList() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle()); //FIXME

        return vehicles;
    }

    public static List<Route> routesDataList() {
        List<Route> routes = new ArrayList<>();
        routes.add(new Route(4, 4, "Dworzec Główny - Płocka", new String[]{"1013", "1028", "14693", "1200", "1238", "1239", "1241", "1252", "130", "1247", "1717", "1861", "1863", "1865"}));
        routes.add(new Route(14, 14, "Dworzec Główny - Płocka", new String[]{"1013", "1028", "1248", "1250", "1254", "1247", "1717", "1314", "1865"}));
        return routes;
    }

    public void writeInitializedDataToJson() throws IOException {
        WriteService ws = new WriteService();
        ws.writeToJson(InitDataService.stopsDataList(),"Stops.json");
        ws.writeToJson(InitDataService.vehiclesDataList(),"Vehicles.json");
        ws.writeToJson(InitDataService.routesDataList(),"Routes.json");
    }
}
