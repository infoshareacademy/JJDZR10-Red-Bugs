package com.isa.pl.redbugs.controller;

import com.isa.pl.redbugs.model.Route;
import com.isa.pl.redbugs.model.Stop;
import com.isa.pl.redbugs.repository.RouteRepository;
import com.isa.pl.redbugs.repository.StopRepository;
import com.isa.pl.redbugs.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

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

        List<String> stopList = route.getStops();
        model.addAttribute("stopsOnRoute", stopList);

        Stop entyStop = new Stop();
        model.addAttribute("stop", entyStop);


        RouteService routeService = new RouteService(stopRepository, routeRepository);
        model.addAttribute("stopsNameList", routeService.stopsOnRoute(routeId));

//        Map<String, Optional<Stop>> stopMap = new HashMap<>();
//        for (int i = 0; i < stopList.size(); i++) {
//            if (i < stopList.size()) {
//                stopMap.put(stopList.get(i), stopRepository.findById(stopList.get(i)));
//            }
//        }
//        model.addAttribute("stopsNameList", stopMap);

//        List<Stop> stopList1 = new ArrayList<>();
//        for (int i = 0; i < stopList.size(); i++) {
//            if (i < stopList.size()) {
//                stopList1.add(stopRepository.findById(stopList.get(i)));
//            }
//        }
//        model.addAttribute("stopsNameList", stopMap);
//


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
