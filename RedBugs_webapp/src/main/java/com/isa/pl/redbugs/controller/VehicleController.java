package com.isa.pl.redbugs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.isa.pl.redbugs.service.VehicleService;

import java.io.IOException;

@Controller
public class VehicleController {

    private VehicleService vehicleService;

    @GetMapping("/vehicles")
    public String getVehicles() throws IOException {
        vehicleService.findAllVehicles();
        return "vehicles";
    }
}
