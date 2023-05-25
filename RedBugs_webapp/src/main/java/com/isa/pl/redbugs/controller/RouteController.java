package com.isa.pl.redbugs.controller;
import com.isa.pl.redbugs.repository.RouteRepository;
import com.isa.pl.redbugs.service.RouteService;
import com.isa.pl.redbugs.model.Route;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/templates")
public class RouteController {

    private final RouteRepository routeRepository;

    public RouteController(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }


    @GetMapping("/routes")
    public String getRoutes(){
        routeRepository.findAll();
        return "vehicle_form";
    }

    @GetMapping("/routes/details/{routeId}")
    public String getRouteDetailsById(@PathVariable("routeId") String routeId, Model model){
        Optional<Route> routeFound = routeRepository.findById(routeId);
        model.addAttribute("route", routeFound);

        String pageTitle = "Lista przystanków autobusu numer: " + routeId;
        model.addAttribute("pageTattle", pageTitle);

        List<String> stopList = routeRepository.findAllById(routeId);
        model.addAttribute("stops", stopList);


        return "details_of_route";
    }

    @GetMapping("/routes/edit/{routeId}")
    public String getEditRouteById(@PathVariable("routeId") String routeId, Model model) {
        Optional<Route> routeFound = routeRepository.findById(routeId);
        model.addAttribute("route", routeFound);

        String pageTitle = "Edycja trasy numer: " + routeId;
        model.addAttribute("pageTattle", pageTitle);

        List<String> stopsOnRouteName = routeRepository.findById(routeId).get().getStops();
        model.addAttribute("stops", stopsOnRouteName);

        List<String> stopsOnRouteId = routeFound.get().getStops();
        model.addAttribute("stopsOnRoute", stopsOnRouteId);

        return "edit_route";
    }

    @PostMapping("/routes/edit/{routeId}/edit")
    public String editRouteById(@PathVariable("routeId") Long routeId, @Valid @ModelAttribute Route route, Model model) throws IOException {
        routeService.editRouteById(routeId, route);
        return "redirect:/routes";
    }


}
