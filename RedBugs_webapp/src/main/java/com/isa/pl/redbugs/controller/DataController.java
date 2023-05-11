package com.isa.pl.redbugs.controller;
import com.isa.pl.redbugs.model.Stop;
import com.isa.pl.redbugs.service.RouteService;
import com.isa.pl.redbugs.service.StopService;
import com.isa.pl.redbugs.service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
public class DataController {
    private final RouteService routeService;
    private final StopService stopService;
    private final VehicleService vehicleService;

    public DataController(RouteService routeService, StopService stopService, VehicleService vehicleService) {
        this.routeService = routeService;
        this.stopService = stopService;
        this.vehicleService = vehicleService;
    }

    @GetMapping("/templates/data.html")
    public String getInitDataServices(Model model) throws IOException {
        model.addAttribute("routes", routeService.findAllRoutes());
        model.addAttribute("vehicles", vehicleService.findAllVehicles());

        Stop stop = new Stop();
        model.addAttribute("stop", stop);

        List<Stop> stops = stopService.findAllStops();
        model.addAttribute("stops", stops);
        try {
            stopService.deleteStop(stopId);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "data";
    }

    @GetMapping("/deleteStop/{stopId}")
    public String deleteStop(@PathVariable String stopId) {


        return "redirect:/templates/data.html";
    }
}





