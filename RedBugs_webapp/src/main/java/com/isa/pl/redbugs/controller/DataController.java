package com.isa.pl.redbugs.controller;

import com.isa.pl.redbugs.service.RouteService;
import com.isa.pl.redbugs.service.StopService;
import com.isa.pl.redbugs.service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;


@Controller
public class DataController {

    private final RouteService routeService;
    private final StopService stopService;
    private final VehicleService vehicleService;

    public DataController(RouteService routeService, StopService stopService, VehicleService vehicleService) {
        this.routeService = routeService;
        this.stopService = stopService;
        this.vehicleService = vehicleService;
    }


    @GetMapping("/templates/data.html")
    public String getInitDataServices(Model model) throws IOException {
        model.addAttribute("routes", routeService.findAllRoutes());
        model.addAttribute("stops", stopService.findAllStops());
        model.addAttribute("vehicles", vehicleService.findAllVehicles());
        return "data";
    }


}

