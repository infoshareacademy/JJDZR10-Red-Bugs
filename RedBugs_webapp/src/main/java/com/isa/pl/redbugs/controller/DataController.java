package com.isa.pl.redbugs.controller;

import com.isa.pl.redbugs.repository.RouteRepository;
import com.isa.pl.redbugs.repository.StopRepository;
import com.isa.pl.redbugs.repository.VehicleRepository;
import com.isa.pl.redbugs.service.RouteService;
import com.isa.pl.redbugs.service.StopService;
import com.isa.pl.redbugs.service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DataController {

    private final RouteService routeService;
    private final StopService stopService;
    private final VehicleService vehicleService;
    private final RouteRepository routeRepository;
    private final StopRepository stopRepository;
    private final VehicleRepository vehicleRepository;

    public DataController(RouteService routeService, StopService stopService, VehicleService vehicleService, RouteRepository routeRepository, StopRepository stopRepository, VehicleRepository vehicleRepository) {
        this.routeService = routeService;
        this.stopService = stopService;
        this.vehicleService = vehicleService;
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

