package com.isa.pl.redbugs.controller;

import com.isa.pl.redbugs.repository.VehicleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class VehicleController {

    private final VehicleRepository vehicleRepository;

    public VehicleController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }
//    private final VehicleService vehicleService;

//    public VehicleController(VehicleService vehicleService) {
//        this.vehicleService = vehicleService;
//    }

    @GetMapping("/vehicles")
    public String getVehicles() {
        vehicleRepository.findAll();
        return "vehicles";
    }
}
