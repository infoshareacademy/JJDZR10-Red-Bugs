package com.isa.pl.redbugs.controller;

import com.isa.pl.redbugs.repository.RouteRepository;
import com.isa.pl.redbugs.repository.StopRepository;
import com.isa.pl.redbugs.repository.VehicleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
    public String getInitDataServices(Model model) {
        model.addAttribute("routes", routeRepository.findAll());
        model.addAttribute("stops", stopRepository.findAll());
        model.addAttribute("vehicles", vehicleRepository.findAll());
        return "data";
    }

}

