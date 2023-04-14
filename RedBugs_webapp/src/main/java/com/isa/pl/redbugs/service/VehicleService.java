package com.isa.pl.redbugs.service;

import com.isa.pl.redbugs.model.Vehicle;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class VehicleService {

    private final WriteService ws;
    private final ReadService rs;

    public VehicleService(WriteService ws, ReadService rs) {
        this.ws = ws;
        this.rs = rs;
    }

    public void createVehicle(Vehicle vehicle) throws IOException {
        List<Vehicle> allVehicles = findAllVehicles();
        allVehicles.add(vehicle);
        ws.writeToJson(allVehicles, "Vehicles.json");
    }

    public void deleteVehicle(long idOfVehicle) throws IOException {
        Vehicle vehicleToDelete = findVehicleById(idOfVehicle);
        List<Vehicle> allVehicles = findAllVehicles();
        allVehicles.remove(vehicleToDelete);
        ws.writeToJson(allVehicles, "Vehicles.json");
    }

    public List<Vehicle> findAllVehicles() throws IOException {
        return rs.readJson("Vehicles.json", Vehicle[].class);
    }

    public Vehicle findVehicleById(long id) throws IOException {
        List<Vehicle> allVehicles = findAllVehicles();

        return allVehicles.stream()
                .filter(route -> route.getVehicleId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Vehicle with id " + id + " not found"));
    }
}
