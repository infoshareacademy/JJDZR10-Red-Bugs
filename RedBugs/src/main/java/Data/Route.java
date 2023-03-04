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
}





