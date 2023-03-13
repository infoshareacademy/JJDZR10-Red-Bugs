package Data.InitData;

import Data.Route;
import Data.Stop;
import Data.Vehicle;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WriteReadJson {

    public static void main(String[] args) throws Exception {
        InitData.initData();
        writeToJsonStops(InitData.stops, "Stops.json");
        writeToJsonVehicels(InitData.vehicles, "Vehicles.json");
        writeToJsonRoutes(InitData.routes, "Routes.json");

        readFromJson("Stops.json").stream().forEach(stop -> System.out.println(stop));
    }

    public static void writeToJsonStops(ArrayList<Stop> arrayList, String fileName) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        String arrayListAsSting = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(arrayList);

        Path path = Paths.get(fileName);
        Files.write(path, arrayListAsSting.getBytes());
    }

    public static void writeToJsonVehicels(ArrayList<Vehicle> objectArrayList, String fileName) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        String arrayListAsSting = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectArrayList);

        Path path = Paths.get(fileName);
        Files.write(path, arrayListAsSting.getBytes());
    }

    public static void writeToJsonRoutes(ArrayList<Route> objectArrayList, String fileName) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        String arrayListAsSting = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectArrayList);

        Path path = Paths.get(fileName);
        Files.write(path, arrayListAsSting.getBytes());
    }



    public static List<Stop> readFromJson(String fileName) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Path path = Paths.get(fileName);

        String readFromJson = Files.readString(path);

        List<Stop> deserializedJson = objectMapper.readValue(readFromJson, new TypeReference<List<Stop>>() {
        });

        return deserializedJson;
    }



}
