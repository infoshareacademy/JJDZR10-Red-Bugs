package com.isa.pl.redbugs.service;

import com.isa.pl.redbugs.model.Route;
import com.isa.pl.redbugs.model.Stop;
import com.isa.pl.redbugs.model.Vehicle;
import com.isa.pl.redbugs.repository.RouteRepository;
import com.isa.pl.redbugs.repository.StopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class InitDataService {

    private final StopRepository stopRepository;
    private final RouteRepository routeRepository;

    @PostConstruct
    public void writeInitializedDataToJson() throws IOException {
        stopsDataList();
        routesDataList();
//        WriteService ws = new WriteService();
//        ws.writeToJson(InitDataService.stopsDataList(),"Stops.json");
//        ws.writeToJson(InitDataService.vehiclesDataList(),"Vehicles.json");
//        ws.writeToJson(InitDataService.routesDataList(),"Routes.json");
    }

    private void stopsDataList() {
        if (stopRepository.findById("1013").isEmpty()) {
            stopRepository.save(createStop("1013", "Dworzec Główny", 54.35483, 18.64512));
            stopRepository.save(createStop("1028", "Brama Wyżynna", 54.35037, 18.64631));
            stopRepository.save(createStop("14693", "Toruńska", 54.34472, 18.64505));
            stopRepository.save(createStop("1200", "Zaroślak", 54.34162, 18.64267));
            stopRepository.save(createStop("1238", "Cmentarna", 54.34079, 18.63566));
            stopRepository.save(createStop("1239", "Stoczniowców", 54.34325, 18.63179));
            stopRepository.save(createStop("1241", "Wronki", 54.34225, 18.62831));
            stopRepository.save(createStop("1252", "Worcella", 54.34113, 18.62638));
            stopRepository.save(createStop("130", "Chełm Cienista", 54.33831, 18.627));
            stopRepository.save(createStop("1247", "Sikorskiego", 54.33892, 18.61883));
            stopRepository.save(createStop("1717", "Cieszyńskiego", 54.3384, 18.60993));
            stopRepository.save(createStop("1861", "Osiedle Jary", 54.33549, 18.60115));
            stopRepository.save(createStop("1863", "Rogalińska", 54.33107, 18.60045));
            stopRepository.save(createStop("1865", "Płocka", 54.34842, 18.60002));
            stopRepository.save(createStop("1248", "Pohulanka", 54.33892, 18.63687));
            stopRepository.save(createStop("1250", "Odrzańska", 54.34515, 18.62554));
            stopRepository.save(createStop("1254", "Chałubińskiego", 54.34221, 18.61793));
            stopRepository.save(createStop("1314", "Przemyska", 54.33344, 18.59615));
        }
    }

    private static Stop createStop(String id, String name, double latitude, double longitude) {
        Stop stop = new Stop();
        stop.setStopId(id);
        stop.setStopName(name);
        stop.setLatitude(latitude);
        stop.setLongitude(longitude);

        return stop;
    }

    public static List<Vehicle> vehiclesDataList() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle()); //FIXME

        return vehicles;
    }

    private static Route createRoute(String routeId, long vehicleNumber, String routeName, List<String> stops) {
        Route route = new Route();
        route.setRouteId(routeId);
        route.setVehicleNumber(vehicleNumber);
        route.setRouteName(routeName);
        route.setStops(stops);

        return route;
    }

    private void routesDataList() {
        if (routeRepository.findById("4").isEmpty()) {
            routeRepository.save(createRoute("4", 4, "Dworzec Główny - Płocka", new ArrayList<>(Arrays.asList("1013", "1028", "14693", "1200", "1238", "1239", "1241", "1252", "130", "1247", "1717", "1861", "1863", "1865"))));
            routeRepository.save(createRoute("14", 14, "Dworzec Główny - Płocka", new ArrayList<>(Arrays.asList("1013", "1028", "1248", "1250", "1254", "1247", "1717", "1314", "1865"))));
        }
    }


    public List<Stop> getStop() {
        return stopRepository.findAll();
    }
}
