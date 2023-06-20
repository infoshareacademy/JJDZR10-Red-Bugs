package com.isa.pl.redbugs.controller;

import com.isa.pl.redbugs.model.Vehicle;
import com.isa.pl.redbugs.repository.VehicleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class VehicleController {

    private final VehicleRepository vehicleRepository;

    public VehicleController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @GetMapping("/vehicles")
    public String getVehicles(Model model) {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        model.addAttribute("vehicles", vehicles);
        return "vehicles";
    }


    @GetMapping("/vehicles/{vehicleId}")
    public String getVehicleById(@PathVariable("vehicleId") Long vehicleId, Model model) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).get();
        model.addAttribute("vehicle", vehicle);
        return "edit-vehicle";
    }


    @PostMapping("/vehicles/{vehicleId}/edit")
    public String editVehicle(@PathVariable("vehicleId") Long vehicleId, @Valid @ModelAttribute Vehicle vehicle, Model model) {
        vehicleRepository.save(vehicle);
        return "redirect:/templates/data.html";
    }


}
