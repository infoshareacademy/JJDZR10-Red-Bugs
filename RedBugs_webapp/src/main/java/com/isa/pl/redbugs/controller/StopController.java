package com.isa.pl.redbugs.controller;

import com.isa.pl.redbugs.service.StopService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class StopController {

    private StopService stopService;

    public StopController(StopService stopService) {
        this.stopService = stopService;
    }

    @GetMapping("/stops")
    public String getStops() throws IOException {
        stopService.findAllStops();
        return "stops";
    }
}
