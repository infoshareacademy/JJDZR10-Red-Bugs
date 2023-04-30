package com.isa.pl.redbugs.controller;

import com.isa.pl.redbugs.model.Route;
import com.isa.pl.redbugs.model.Stop;
import com.isa.pl.redbugs.model.Vehicle;
import com.isa.pl.redbugs.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.isa.pl.redbugs.service.InitDataService;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.util.List;

@Controller
public class DataController {

    private DataController dataController;
    private RouteController routeController;


    @GetMapping("/templates/data.html")
    public String getInitDataServices(Model model) {
        List<Stop> stops = InitDataService.stopsDataList();
        model.addAttribute("stops", stops);

        List<Vehicle> vehicles = InitDataService.vehiclesDataList();
        model.addAttribute("vehicles", vehicles);

        List<Route> routes = InitDataService.routesDataList();
        model.addAttribute("routes", routes);
        model.addAttribute("stops", stops);
        model.addAttribute("vehicles", vehicles);
        return "data";
    }


}

