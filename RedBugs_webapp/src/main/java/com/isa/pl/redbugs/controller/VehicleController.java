package com.isa.pl.redbugs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.isa.pl.redbugs.service.VehicleService;

@Controller
public class VehicleController {

    private VehicleService vehicleService;

    @GetMapping("/vehicles")
    public String getVehicles(){
        vehicleService.findAllVehicles();
        return "vehicles";
    }
}
