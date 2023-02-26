package Data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.*;

public class Route {

    private static List<Stop> stopList = new ArrayList<>();

    private static Integer idRoute;
    Route route1 = new Route();



    public static List<Stop> getStopList() {
        return stopList;
    }

    public static void setStopList(List<Stop> stopList) {
        Route.stopList = stopList;
    }

    public static Integer getIdRoute() {
        return idRoute;
    }

    public static void setIdRoute(Integer idRoute) {
        Route.idRoute = idRoute;
    }

    public static void fromJson() throws IOException {
        Gson gson = new Gson();
        try (Reader reader = new FileReader("stops.txt")){
            List <Stop> stop = gson.fromJson(reader,List.class);


            //Path path = Paths.get("stops.txt");
            //String readedStops = Files.readString(path);
            System.out.println("All stops taken from the file stops.txt");
            //System.out.println(readedStops);
            System.out.println(stop.toString());

        }


    }

    public static void routescreator() throws IOException {
        fromJson();
        /* - Stara wersja z Object Mapper
        Stop stop1 = new Stop(1, "Przystanek1", new Schedule());
        Stop stop2 = new Stop(2, "Przystanek2", new Schedule());
        Stop stop3 = new Stop(3, "Przystanek3", new Schedule());
        Stop stop4 = new Stop(4, "Przystanek4", new Schedule());
        List<Stop> stopList = new ArrayList<>();
        stopList.add(stop1);
        stopList.add(stop2);
        stopList.add(stop3);
        stopList.add(stop4);
        ObjectMapper objectMapper = new ObjectMapper();
        String stopsAsString = objectMapper.writeValueAsString(stopList);
        System.out.println(stopsAsString);
        Path path = Paths.get("stops.txt");
        Files.write(path, stopsAsString.getBytes());
        String readedStops = Files.readString(path);

        //List<Stop> stopsReadedFromFileAsPojo = objectMapper.readValue(readedStops, new TypeReference<List<Stop>>() {
        //});

         */
    }

    public static void routesreader() throws IOException {
        Path path = Paths.get("stops.txt");
        String readedStops = Files.readString(path);
        System.out.println("All stops list taken from the file stops.txt");
        System.out.println(readedStops);
    }
}





