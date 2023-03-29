package com.isa.pl.redbugs.service.CreateData;

import com.isa.pl.redbugs.model.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateRandomVehicle {
    private final Random random = new Random();

    public List<Object> createRandomVehicles(int amount) {
        List<Object> stopList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            stopList.add(createRandomVehicle());
        }
        return stopList;
    }

    public Vehicle createRandomVehicle() {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleId(generateId(10, 100, 2));
        vehicle.setVehicleName(generateVehiclesName());
        return vehicle;
    }

    private String generateVehiclesName() {
        String[] name = {"Siedlce - Stara Piła",
                "Port Lotniczy - Sopot Kamienny",
                "Dworzec Główny - Pruszcz Matejki",
                "Wrzeszcz PKP - Żukowo Urząd Gminy",
                "Dworzec Główny - Pruszcz Komarowo",
                "Siedlce - Stara Piła 1",
                "Port Lotniczy - Sopot Kamienny 2",
                "Dworzec Główny - Pruszcz Matejki 3",
                "Wrzeszcz PKP - Żukowo Urząd Gminy 4",
                "Dworzec Główny - Pruszcz Komarowo 5"};
        return name[random.nextInt(name.length)];
    }

    private long generateId(long min, long max, long step) {
        return random.longs(min / step, max / step)
                .findFirst()
                .getAsLong() * step;
    }
}
