package com.isa.pl.redbugs.model;

/*import com.google.gson.Gson;*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Route {

    private long routeId;
    private long numberVehicle;
    private String nameRoute;
    private List<Object> stops;

    public Route(long routeId, long numberVehicle, String nameRoute, List<Object> stops) {
        this.routeId = routeId;
        this.numberVehicle = numberVehicle;
        this.nameRoute = nameRoute;
        this.stops = stops;
    }

    private static List<Stop> stopList = new ArrayList<>();

    public Route() {

    }

    public static List<Stop> getStopList() {
        return stopList;
    }

    public static void setStopList(List<Stop> stopList) {
        Route.stopList = stopList;
    }

    public long getRouteId() {
        return routeId;
    }

    public void setRouteId(long routeId) {
        this.routeId = routeId;
    }

    public long getNumberVehicle() {
        return numberVehicle;
    }

    public void setNumberVehicle(long numberVehicle) {
        this.numberVehicle = numberVehicle;
    }

    public String getNameRoute() {
        return nameRoute;
    }

    public void setNameRoute(String nameRoute) {
        this.nameRoute = nameRoute;
    }

    public List<Object> getStops() {
        return stops;
    }

    public void setStops(List<Object> stops) {
        this.stops = stops;
    }

  /*  public static void fromJson() throws IOException {
        Gson gson = new Gson();
        try (Reader reader = new FileReader("stops.txt")) {
            List<Stop> stop = gson.fromJson(reader, List.class);

            //wypisywanie przystankow linia po linii
            Path path = Paths.get("stops.txt");
            String readedStops = Files.readString(path);
            System.out.println(readedStops);

        }
    }*/
/*

    public static void routescreator() throws IOException {
        fromJson();
    }
*/

    public static void routesreader() throws IOException {
        Path path = Paths.get("stops.txt");
        String readedStops = Files.readString(path);
        System.out.println(readedStops);
    }
}

