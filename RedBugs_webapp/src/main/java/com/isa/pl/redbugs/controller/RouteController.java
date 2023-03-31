package com.isa.pl.redbugs.controller;

import com.isa.pl.redbugs.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class RouteController {
    private RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/routes")
    public String getRoutes() throws IOException {
        routeService.findAllRoutes();
        return "routes";
    }
}
