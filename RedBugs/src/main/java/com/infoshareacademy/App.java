package com.infoshareacademy;

import Data.Schedule;
import Data.Stop;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static Data.Menu.menu;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("RedBugs");
        Stop stop1 = new Stop(1, "Przystanek1", new Schedule());
        Stop stop2 = new Stop(2, "Przystanek2", new Schedule());
        Stop stop3 = new Stop(3, "Przystanek3", new Schedule());
        List<Stop> stopList = new ArrayList<>();
        stopList.add(stop1);
        stopList.add(stop2);
        stopList.add(stop3);

        ObjectMapper objectMapper = new ObjectMapper();
        String stopsAsString = objectMapper.writeValueAsString(stopList);
        System.out.println(stopsAsString);

        Path path = Paths.get("stops.txt");

        Files.write(path, stopsAsString.getBytes());

        String readedStops = Files.readString(path);
        System.out.println(readedStops);

        List<Stop> stopsReadedFromFileAsPojo = objectMapper.readValue(readedStops, new TypeReference<List<Stop>>() {
        });

        stopsReadedFromFileAsPojo.add(new Stop(4, "Przystanek4", new Schedule()));
        String value = objectMapper.writeValueAsString(stopsReadedFromFileAsPojo);
        Files.write(path, value.getBytes());

        menu();
    }
}
