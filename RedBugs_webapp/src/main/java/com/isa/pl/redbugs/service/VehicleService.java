package com.isa.pl.redbugs.service;

import com.isa.pl.redbugs.model.Vehicle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VehicleService {

    public void createVehicle(Vehicle vehicle) throws IOException {
        ReadService rs = new ReadService();
        List<Vehicle> allVehicles = new ArrayList(rs.readJson("Vehicles.json", Vehicle[].class));
        allVehicles.add(vehicle);
        WriteService ws = new WriteService();
        ws.writeToJson(allVehicles, "Vehicles.json");
    }

    public void deleteVehicle(long idOfVehicle) throws IOException {
        Vehicle vehicleToDelete = new VehicleService().findVehicleById(idOfVehicle);
        List<Vehicle> allVehicles = new ArrayList(findAllVehicles());
        allVehicles.remove(vehicleToDelete);
        WriteService ws = new WriteService();
        ws.writeToJson(allVehicles, "Vehicles.json");
    }

    public List<Vehicle> findAllVehicles() throws IOException {
        ReadService rs = new ReadService();
        return rs.readJson("Vehicles.json", Vehicle[].class);
    }

    public Vehicle findVehicleById(long id) throws IOException {
        ReadService rs = new ReadService();
        List<Vehicle> allVehicles = rs.readJson("Vehicles.json", Vehicle[].class);
        for (int i = 0; i < allVehicles.size(); i++) {
            if (allVehicles.get(i).getVehicleId() == id) {
                Vehicle foundVehicle = allVehicles.get(i);
                return foundVehicle;
            }
        }
        throw new RuntimeException("No vehicle found");
    }
}
