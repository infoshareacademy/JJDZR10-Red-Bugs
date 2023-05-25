package com.isa.pl.redbugs.service;

import com.isa.pl.redbugs.model.Route;
import com.isa.pl.redbugs.model.Stop;
import com.isa.pl.redbugs.model.Vehicle;
import com.isa.pl.redbugs.model.VehicleType;
import com.isa.pl.redbugs.repository.RouteRepository;
import com.isa.pl.redbugs.repository.StopRepository;
import com.isa.pl.redbugs.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class InitDataService {

    private final StopRepository stopRepository;
    private final RouteRepository routeRepository;
    private final VehicleRepository vehicleRepository;

    @PostConstruct
    public void writeDataToDatabase() {
        stopsDataList();
        routesDataList();
        vehiclesDataList();
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

    private void routesDataList() {
        if (routeRepository.findById("4").isEmpty()) {
            routeRepository.save(createRoute("4", 4, "Dworzec Główny - Płocka", new ArrayList<>(Arrays.asList("1013", "1028", "14693", "1200", "1238", "1239", "1241", "1252", "130", "1247", "1717", "1861", "1863", "1865"))));
            routeRepository.save(createRoute("14", 14, "Dworzec Główny - Płocka", new ArrayList<>(Arrays.asList("1013", "1028", "1248", "1250", "1254", "1247", "1717", "1314", "1865"))));
        }
    }

    private void vehiclesDataList() {
        if (vehicleRepository.findById("4").isEmpty()) {
            vehicleRepository.save(createVehicle(4, "Dworzec Główny - Płocka", VehicleType.Bus));
            vehicleRepository.save(createVehicle(14, "Dworzec Główny - Płocka", VehicleType.Bus));
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

    private static Vehicle createVehicle(long vehicleId, String vehicleName, VehicleType type) {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleId(vehicleId);
        vehicle.setVehicleName(vehicleName);
        vehicle.setType(type);

        return vehicle;
    }

    private static Route createRoute(String routeId, long vehicleNumber, String routeName, List<String> stops) {
        Route route = new Route();
        route.setRouteId(routeId);
        route.setVehicleNumber(vehicleNumber);
        route.setRouteName(routeName);
        route.setStops(stops);

        return route;
    }

    public List<Stop> getStop() {
        return stopRepository.findAll();
    }
}
