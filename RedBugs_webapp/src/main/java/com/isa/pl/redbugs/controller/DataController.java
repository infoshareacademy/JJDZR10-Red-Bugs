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

    @GetMapping("/templates/trip-finder")
    public String getTripFInder(Model model, @RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue = "10") int size) {
        Page<Stop> stopsPage = stopRepository.findAll(PageRequest.of(page, size));
        model.addAttribute("stops", stopsPage.getContent());
        Stop startId = new Stop();
        Stop endId = new Stop();
        model.addAttribute("startId", startId);
        model.addAttribute("endId", endId);
        return "trip-finder";
    }

//    @PostMapping("/templates/trip-finder-process")
//    public String getTripFinder(@RequestParam("startId") Stop start , @RequestParam("endId") Stop end) {
//        String strartId = start.getStopId();
//        String endId = end.getStopId();
//
////        return "redirect:/trip-result?trip-finder-result?startId=" + startId + "&endId=" + endId;
////    return "redirect:/trip-result";
//        return "trip-result";
//    }

    @PostMapping("/templates/trip-finder-result")
    public String getResult( @RequestParam("startId") Stop startId, @RequestParam("endId") Stop endId, Model model) {
        model.addAttribute("startId", startId);
        model.addAttribute("endId", endId);

        return "redirect:/templates/result";
    }

    @GetMapping("/templates/result")
    public String resultPage(@ModelAttribute("startId") Stop start, @ModelAttribute("endId") Stop end , Model model) throws Exception {
        Set<Route> routes = new HashSet<>(routeRepository.findAll());
        Set<Stop> stops = new HashSet<>(stopRepository.findAll());

        String startId = start.getStopId();
        String endId = end.getStopId();

        List<Stop> listOfResult = pathFindingService.calculateShortestRoute(stops, routes, startId, endId);
        model.addAttribute("listOfResult", listOfResult);
        return "trip-result";
    }

}

