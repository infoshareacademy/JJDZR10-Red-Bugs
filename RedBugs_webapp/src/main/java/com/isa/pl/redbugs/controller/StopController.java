package com.isa.pl.redbugs.controller;

import com.isa.pl.redbugs.repository.StopRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StopController {

    private final StopRepository stopRepository;

    public StopController(StopRepository stopRepository) {
        this.stopRepository = stopRepository;
    }

    @GetMapping("/stops")
    public String getStops() {
        stopRepository.findAll();
        return "stops";
    }
}
