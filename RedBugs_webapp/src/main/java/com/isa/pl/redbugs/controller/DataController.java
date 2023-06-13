package com.isa.pl.redbugs.controller;

import com.isa.pl.redbugs.model.Route;
import com.isa.pl.redbugs.model.Stop;
import com.isa.pl.redbugs.model.Vehicle;
import com.isa.pl.redbugs.repository.RouteRepository;
import com.isa.pl.redbugs.repository.StopRepository;
import com.isa.pl.redbugs.repository.VehicleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DataController {

    private final RouteRepository routeRepository;
    private final StopRepository stopRepository;
    private final VehicleRepository vehicleRepository;

    public DataController(RouteRepository routeRepository, StopRepository stopRepository, VehicleRepository vehicleRepository) {
        this.routeRepository = routeRepository;
        this.stopRepository = stopRepository;
        this.vehicleRepository = vehicleRepository;
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

}

