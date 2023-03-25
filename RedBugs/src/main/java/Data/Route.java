package Data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Route {

    private long routeId;
    private long numberVehicle;
    private String nameRoute;
    private long[] stops;

    public Route(long routeId, long numberVehicle, String nameRoute, long[] stops) {
        this.routeId = routeId;
        this.numberVehicle = numberVehicle;
        this.nameRoute = nameRoute;
        this.stops = stops;
    }

    private static List<Stop> stopList = new ArrayList<>();

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

    public long[] getStops() {
        return stops;
    }

    public Route() {

    }

    public void setStops(long[] stops) {
        this.stops = stops;
    }

    public static void fromJson() throws IOException {
        Gson gson = new Gson();
        try (Reader reader = new FileReader("stops.txt")) {
            List<Stop> stop = gson.fromJson(reader, List.class);

            //wypisywanie przystankow linia po linii
            Path path = Paths.get("stops.txt");
            String readedStops = Files.readString(path);
            System.out.println(readedStops);

        }
    }

    public static void routescreator() throws IOException {
        fromJson();
    }

    public static void routesreader() throws IOException {
        Path path = Paths.get("stops.txt");
        String readedStops = Files.readString(path);
        System.out.println(readedStops);
    }

    public static void routeDesplayer() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        File routeJsonFile = new File("Routes.json");
        ArrayList<Route> myRoute = objectMapper.readValue(routeJsonFile, new TypeReference<ArrayList<Route>>() {
        });
        for (int i = 0; i < myRoute.size(); i++) {
            System.out.println(myRoute.get(i).getNameRoute());
        }
    }
}

