package com.isa.pl.redbugs.controller;

import com.isa.pl.redbugs.model.Route;
import com.isa.pl.redbugs.model.Stop;
import com.isa.pl.redbugs.model.Vehicle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.isa.pl.redbugs.service.InitDataService;

import java.util.List;


@Controller
public class InitDataServiceController {

    private InitDataServiceController initDataServiceController;


    @GetMapping("/data")
    public String getInitDataServices(Model model) {
        List<Stop>  stops = InitDataService.stopsDataList();
        model.addAttribute("stops", stops);

        List<Vehicle> vehicles = InitDataService.vehiclesDataList();
        model.addAttribute("vehicles", vehicles);

        List<Route> routes = InitDataService.routesDataList();
        model.addAttribute("routes", routes);
      return "data";
    }
}
