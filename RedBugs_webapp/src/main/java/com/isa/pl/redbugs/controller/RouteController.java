package com.isa.pl.redbugs.controller;

import com.isa.pl.redbugs.model.Route;
import com.isa.pl.redbugs.model.Stop;
import com.isa.pl.redbugs.model.Vehicle;
import com.isa.pl.redbugs.repository.RouteRepository;
import com.isa.pl.redbugs.repository.StopRepository;
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
public class RouteController {

    public static final String HOMEPAGE_REDIRECTION = "redirect:/templates/data.html";
    private final RouteRepository routeRepository;
    private final StopRepository stopRepository;
    private final VehicleRepository vehicleRepository;
    public RouteController(RouteRepository routeRepository, StopRepository stopRepository, VehicleRepository vehicleRepository) {
        this.routeRepository = routeRepository;
        this.stopRepository = stopRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @GetMapping("/routes")
    public String getRoutes(Model model) {
        List<Route> routes = routeRepository.findAll();
        model.addAttribute("routes", routes);
        return "routes";
    }

    @GetMapping("/routes/details/{routeId}")
    public String getStopsOnRoute(@PathVariable("routeId") String routeId, Model model) {
        Route route = routeRepository.findById(routeId).get();
        model.addAttribute("route", route);

        List<String> stopList = route.getStops();
        model.addAttribute("stopsOnRoute", stopList);
        return "details-of-route";
    }

    @GetMapping("/routes/{routeId}")
    public String getRouteById(@PathVariable("routeId") String routeId, Model model) {
        Route route = routeRepository.findById(routeId).get();
        model.addAttribute("route", route);

        List<String> stopList = route.getStops();
        model.addAttribute("stopsOnRoute", stopList);
        return "edit-route";
    }

    @PostMapping("/routes/{routeId}/edit")
    public String editRouteById(@PathVariable("routeId") String routeId, @Valid @ModelAttribute Route route) {
        routeRepository.save(route);
        return HOMEPAGE_REDIRECTION;
    }

    @GetMapping("/routes/delete-route/{id}")
    public String deleteVehicleById(@PathVariable String id) {
        routeRepository.deleteById(id);
        return HOMEPAGE_REDIRECTION;
    }

    @GetMapping("/routes/create")
    public String showCreateForm(Model model) {
        model.addAttribute("route", new Route());

        List<Stop> stopList = stopRepository.findAll();
        model.addAttribute("stopList", stopList);

        List<Vehicle> vehicleList = vehicleRepository.findAll();
        model.addAttribute("vehicleList", vehicleList);
        return "add-route";
    }

    @PostMapping("/routes/add")
    public String createVehicle(@Valid @ModelAttribute Route route, BindingResult bindingResult) {
        String routeRouteId = route.getRouteId();
        if (routeRepository.findById(routeRouteId).isPresent()) {
            return "error/route-id-exists";
        }
        else if (bindingResult.hasErrors()) {
            return "error/non-numeric-id-route";
        }
        else {
            routeRepository.save(route);
            return HOMEPAGE_REDIRECTION;
        }
    }
}
