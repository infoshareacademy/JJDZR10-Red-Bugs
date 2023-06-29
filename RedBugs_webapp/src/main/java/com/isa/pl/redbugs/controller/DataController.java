package com.isa.pl.redbugs.controller;

import com.isa.pl.redbugs.model.Route;
import com.isa.pl.redbugs.model.Stop;
import com.isa.pl.redbugs.model.Vehicle;
import com.isa.pl.redbugs.repository.RouteRepository;
import com.isa.pl.redbugs.repository.StopRepository;
import com.isa.pl.redbugs.repository.VehicleRepository;
import com.isa.pl.redbugs.service.PathFindingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class DataController {

    private final RouteRepository routeRepository;
    private final StopRepository stopRepository;
    private final VehicleRepository vehicleRepository;
    private final PathFindingService pathFindingService;

    public DataController(RouteRepository routeRepository, StopRepository stopRepository, VehicleRepository vehicleRepository, PathFindingService pathFindingService) {
        this.routeRepository = routeRepository;
        this.stopRepository = stopRepository;
        this.vehicleRepository = vehicleRepository;
        this.pathFindingService = pathFindingService;
    }


    @GetMapping("/templates/data.html")
    public String getInitDataServices(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        // Pobierz stronę danych z repozytorium, używając parametrów paginacji
        Page<Route> routesPage = routeRepository.findAll(PageRequest.of(page, size));
        Page<Stop> stopsPage = stopRepository.findAll(PageRequest.of(page, size));
        Page<Vehicle> vehiclesPage = vehicleRepository.findAll(PageRequest.of(page, size));

        // Przekaż informacje dotyczące paginacji i fragmentu danych do modelu
        model.addAttribute("routes", routesPage.getContent());
        model.addAttribute("stops", stopsPage.getContent());
        model.addAttribute("vehicles", vehiclesPage.getContent());
        model.addAttribute("currentPage", routesPage.getNumber());
        model.addAttribute("totalPages", routesPage.getTotalPages());

        return "data";
    }

    @GetMapping("/templates/trip-finder.html")
    public String getTripFInder(Model model, @RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue = "10") int size) {
        Page<Stop> stopsPage = stopRepository.findAll(PageRequest.of(page, size));
        model.addAttribute("stops", stopsPage.getContent());
        return "trip-finder";
    }

    @PostMapping("/templates/result")
    public String resultPage(@ModelAttribute("startId") String startId, @ModelAttribute("endId") String endId , Model model) throws Exception {
        Set<Route> routes = new HashSet<>(routeRepository.findAll());
        Set<Stop> stops = new HashSet<>(stopRepository.findAll());

        List<Stop> listOfResult = pathFindingService.calculateShortestRoute(stops, routes, startId, endId);
        model.addAttribute("listOfResult", listOfResult);
        return "trip-result";
    }

}

