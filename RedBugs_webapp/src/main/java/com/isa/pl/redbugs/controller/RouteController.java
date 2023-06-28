package com.isa.pl.redbugs.controller;

import com.isa.pl.redbugs.model.Route;
import com.isa.pl.redbugs.model.Stop;
import com.isa.pl.redbugs.repository.RouteRepository;
import com.isa.pl.redbugs.repository.StopRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class RouteController {

    public static final String HOMEPAGE_REDIRECTION = "redirect:/templates/data.html";
    private final RouteRepository routeRepository;
    private final StopRepository stopRepository;

    public RouteController(RouteRepository routeRepository, StopRepository stopRepository) {
        this.routeRepository = routeRepository;
        this.stopRepository = stopRepository;
    }

    @GetMapping("/routes")
    public String getRoutes(Model model) {
        List<Route> routes = routeRepository.findAll();
        model.addAttribute("routes", routes);
        return "routes";
    }

    @GetMapping("/routes/{routeId}")
    public String getRouteById(@PathVariable("routeId") String routeId, Model model) {
        Route route = routeRepository.findById(routeId).get();
        model.addAttribute("route", route);

        List<String> stopList = List.of(String.valueOf(route.getStops()));
        model.addAttribute("stopsOnRoute", stopList);

//        List<Stop> getStopsName =  stopRepository.findById(stopList.get())
        List<Optional<Stop>> getStopName = new ArrayList<>();
        stopList.stream()
                .map(stopRepository::findById)
                .forEach(getStopName::add);
        model.addAttribute("stopsNameList", getStopName);
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

    @GetMapping("/route/create")
    public String showCreateForm(Model model) {
        model.addAttribute("route", new Route());
        return "add-route";
    }

    @PostMapping("/routes/add")
    public String createVehicle(@Valid @ModelAttribute Route route, BindingResult bindingResult) {
        String routeRouteId = route.getRouteId();
        if (routeRepository.findById(routeRouteId).isPresent()) {
            return "error/vehicle-id-exists";
        }
        else if (bindingResult.hasErrors()) {
            return "error/non-numeric-id";
        }
        else {
            routeRepository.save(route);
            return HOMEPAGE_REDIRECTION;
        }
    }
}
