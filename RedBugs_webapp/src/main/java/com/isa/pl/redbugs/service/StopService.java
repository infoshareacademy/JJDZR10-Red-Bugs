package com.isa.pl.redbugs.service;

import com.isa.pl.redbugs.model.Route;
import com.isa.pl.redbugs.model.Stop;
import com.isa.pl.redbugs.repository.RouteRepository;
import com.isa.pl.redbugs.repository.StopRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Component
public class StopService {
    private final StopRepository stopRepository;
    private final RouteRepository routeRepository;

    public StopService(StopRepository stopRepository, RouteRepository routeRepository) {
        this.stopRepository = stopRepository;
        this.routeRepository = routeRepository;
    }

    List<Optional<Stop>> findStope(Route route) {
        List<Optional<Stop>> stopList = new ArrayList<>();

        List<String> stringList = route.getStops();

        for (int i = 0; i < stringList.size(); i++) {
            if (i < stopList.size()) {
                stopList.add(stopRepository.findById(String.valueOf(stopList.get(i))));
            }
        }

        return  stopList;
    }






}