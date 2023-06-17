package com.isa.pl.redbugs.service;

import com.isa.pl.redbugs.model.Stop;
import com.isa.pl.redbugs.repository.StopRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class StopService {

    private final StopRepository stopRepository;

    public StopService(StopRepository stopRepository) {
        this.stopRepository = stopRepository;
    }

    public List<Stop> findAllStops() {
        return stopRepository.findAll();
    }

    public void saveStop(Stop stop) throws IOException {
        stopRepository.save(stop);
    }
}

