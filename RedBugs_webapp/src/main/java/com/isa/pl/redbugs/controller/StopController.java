package com.isa.pl.redbugs.controller;

import com.isa.pl.redbugs.model.Stop;
import com.isa.pl.redbugs.repository.StopRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class StopController {
    public static final String HOMEPAGE_REDIRECTION = "redirect:/templates/data.html";
    private final StopRepository stopRepository;

    public StopController(StopRepository stopRepository) {
        this.stopRepository = stopRepository;
    }

    @GetMapping("/stops")
    public String getStops() {
        stopRepository.findAll();
        return "stops";
    }

    @GetMapping("/stops/{stopId}")
    public String getStopById(@PathVariable("stopId") String stopId, Model model) {
        Stop stop = stopRepository.findById(stopId).get();
        model.addAttribute("stop", stop);
        return "edit-stop";
    }

    @PostMapping("/stops/{stopId}/edit")
    public String editStopById(@PathVariable("stopId") Long stopId, @Valid @ModelAttribute Stop stop) {
        stopRepository.save(stop);
        return HOMEPAGE_REDIRECTION;
    }

    @GetMapping("stops/delete-stop/{id}")
    public String deleteStopById(@PathVariable String id) {
        stopRepository.deleteById(id);
        return HOMEPAGE_REDIRECTION;
    }

    @GetMapping("/stops/create")
    public String showCreateForm(Model model) {
        model.addAttribute("stop", new Stop());
        return "add-stop";
    }

    @PostMapping("/stops/add")
    public String createStop(@Valid @ModelAttribute Stop stop, BindingResult bindingResult) {
        String stopToAddId = stop.getStopId();
        if (stopRepository.findById(stopToAddId).isPresent()) {
            return "error/stop-id-exists";
        } else if (bindingResult.hasErrors()) {
            return "error/non-numeric-id";
        } else {
            stopRepository.save(stop);
            return HOMEPAGE_REDIRECTION;
        }
    }
}

