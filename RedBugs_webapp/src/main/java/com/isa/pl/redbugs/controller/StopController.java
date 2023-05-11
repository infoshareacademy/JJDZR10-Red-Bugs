package com.isa.pl.redbugs.controller;

import com.isa.pl.redbugs.model.Stop;
import com.isa.pl.redbugs.service.StopService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class StopController {

    private final StopService stopService;

    public StopController(StopService stopService) {
        this.stopService = stopService;
    }

    @GetMapping("/stops")
    public String getStops(Model model) throws IOException {
        List<Stop> stops = stopService.findAllStops();
        model.addAttribute("stops", stops);
        return "stops";
    }


    @GetMapping("/addStop")
    public String addStopForm(Model model) {
        model.addAttribute("stop", new Stop());
        return "addStop";
    }


    @PostMapping("/addStop")
    public String addStop(@ModelAttribute("stop") Stop stop) {
        try {
            stopService.saveStop(stop);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/stops";
    }
    @RequestMapping("/stops")
    public String showStops() {
        return "stops";
    }



}



