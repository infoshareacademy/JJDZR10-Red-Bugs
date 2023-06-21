package com.isa.pl.redbugs.controller;

import com.isa.pl.redbugs.model.Vehicle;
import com.isa.pl.redbugs.repository.VehicleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String editVehicleById(@PathVariable("vehicleId") @Valid @ModelAttribute Vehicle vehicle) {
        vehicleRepository.save(vehicle);
        return "redirect:/templates/data.html";
    }

    @GetMapping("vehicles/delete-vehicle/{id}")
    public String deleteVehicleById(@PathVariable long id) {
        vehicleRepository.deleteById(id);
        return "redirect:/templates/data.html";
    }

    @GetMapping("/vehicles/create")
    public String showCreateForm(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        return "add-vehicle";
    }

    @PostMapping("/vehicles/add")
    public String createVehicle(@Valid @ModelAttribute Vehicle vehicle) {
        vehicleRepository.save(vehicle);
        return "add-vehicle";
    }


}
