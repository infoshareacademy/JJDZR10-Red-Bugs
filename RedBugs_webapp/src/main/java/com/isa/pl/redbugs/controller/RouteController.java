package com.isa.pl.redbugs.controller;

import com.isa.pl.redbugs.model.Route;
import com.isa.pl.redbugs.model.Stop;
import com.isa.pl.redbugs.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
public class RouteController {
    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/routes")
    public String getRoutes() throws IOException {
        routeService.findAllRoutes();
        return "vehicle_form";
    }

    @GetMapping("/routes/details/{routeId}")
    public String getRouteDetailsById(@PathVariable("routeId") Long routeId, Model model) throws IOException {
        Route routeFound = routeService.findRouteById(routeId);
        model.addAttribute("route", routeFound);

        String pageTitle = "Lista przystanków autobusu numer: " + routeId;
        model.addAttribute("pageTattle", pageTitle);

        List<String> stopList = routeService.findAllStopsOnRoute(routeId);
        model.addAttribute("stops", stopList);
        return "details_of_route";
    }

    @GetMapping("/routes/edit/{routeId}")
    public String getEditRouteById(@PathVariable("routeId") Long routeId, Model model) throws IOException {
        Route routeFound = routeService.findRouteById(routeId);
        model.addAttribute("route", routeFound);

        String pageTitle = "Edycja trasy numer: " + routeId;
        model.addAttribute("pageTattle", pageTitle);

        List<String> stopsOnRouteName = routeService.findAllStopsOnRoute(routeId);
        model.addAttribute("stops", stopsOnRouteName);

        String[] stopsOnRouteId = routeFound.getStops();
        model.addAttribute("stopsOnRoute", stopsOnRouteId);

        return "edit_route";
    }

    @PostMapping("/routes/edit/{routeId}/edit")
    public String editRouteById(@PathVariable("routeId") Long routeId, @Valid @ModelAttribute Route route, Model model) throws IOException {
        routeService.editRouteById(routeId, route);
        return "redirect:/routes";
    }


}
