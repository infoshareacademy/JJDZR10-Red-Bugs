package com.isa.pl.redbugs.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isa.pl.redbugs.model.Route;
import com.isa.pl.redbugs.model.Stop;
import com.isa.pl.redbugs.model.Vehicle;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadService {

    public List<Object> readJson(){
        //read json generic instatof
        return null;
    }

    public List<Stop> readFromJsonStops(String fileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Path path = Paths.get(fileName);

        String readFromJson = Files.readString(path);

        List<Stop> deserializedJson = objectMapper.readValue(readFromJson, new TypeReference<List<Stop>>() {
        });
        return deserializedJson;
    }

    public List<Vehicle> readFromJsonVehicles(String fileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Path path = Paths.get(fileName);

        String readFromJson = Files.readString(path);

        List<Vehicle> deserializedJson = objectMapper.readValue(readFromJson, new TypeReference<List<Vehicle>>() {
        });
        return deserializedJson;
    }

    public List<Route> readFromJsonRoutes(String fileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Path path = Paths.get(fileName);

        String readFromJson = Files.readString(path);

        List<Route> deserializedJson = objectMapper.readValue(readFromJson, new TypeReference<List<Route>>() {
        });
        return deserializedJson;
    }
}
