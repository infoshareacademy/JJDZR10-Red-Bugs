package com.isa.pl.redbugs.controller;

import com.isa.pl.redbugs.repository.StopRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class StopController {

    private final StopRepository stopRepository;

    public StopController(StopRepository stopRepository) {
        this.stopRepository = stopRepository;
    }
//    private final StopService stopService;

//    public StopController(StopService stopService) {
//        this.stopService = stopService;
//    }

    @GetMapping("/stops")
    public String getStops() throws IOException {
        stopRepository.findAll();
        return "stops";
    }
}
