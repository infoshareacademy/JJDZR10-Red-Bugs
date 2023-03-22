package com.isa.pl.redbugs.service.CreateData;

import com.isa.pl.redbugs.model.Route;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateRandomRoutes {
    private final Random random = new Random();

    public List<Object> createRandomRoutes(int amount, int amountStops) {
        List<Object> routes = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            routes.add(createRandomRoute(amountStops));
        }
        return routes;
    }

    public Route createRandomRoute(int amountStops) {
        CreateRandomStops createStops = new CreateRandomStops();

        Route route = new Route();
        route.setRouteId(new Random().nextLong(100));
        route.setNumberVehicle(new Random().nextLong(10));
        route.setNameRoute(generateRouteName());
        route.setStops(createStops.createRandomStops(30));

        return route;
    }

    private String generateRouteName() {
        String[] names = {"Siedlce - Stara Piła",
                "Port Lotniczy - Sopot Kamienny",
                "Dworzec Główny - Pruszcz Matejki",
                "Wrzeszcz PKP - Żukowo Urząd Gminy",
                "Dworzec Główny - Pruszcz Komarowo"};
        return names[random.nextInt(names.length)];
    }

    private long generateId(long min, long max, long step) {
        return random.longs(min / step, max / step)
                .findFirst()
                .getAsLong() * step;
    }

}
