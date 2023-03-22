package com.isa.pl.redbugs.service.CreateData;

import com.isa.pl.redbugs.model.Stop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateRandomStops {
    private final Random random = new Random();

    public List<Object> createRandomStops(int amount) {
        List<Object> stopList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            stopList.add(createRandomStop());
        }

        return stopList;
    }
    public Stop createRandomStop() {
        Stop stop = new Stop();
        stop.setStopId(generateId(10, 100, 2));
        stop.setStopName(generateStopName());
        return stop;
    }

    private String generateStopName() {
        String[] name = {"Dąbrowa Centrum", "Gdynia Kameliowa", "Paprykowa",
                "Szafranowa", "Centrum Nadawcze RTV", "Chwaszczyno", "Gdynia Szafranowa",
                "Dziewicza", "Pogórze - Szkolna", "Dąbka - Zielona"};
        return name[random.nextInt(name.length)];
    }

    private long generateId(long min, long max, long step) {
        return random.longs(min / step, max / step)
                .findFirst()
                .getAsLong() * step;
    }
}
