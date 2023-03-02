package TransportApp2.writeAnsReadTxt;

import TransportApp2.writeAnsReadTxt.model.Root;
import TransportApp2.writeAnsReadTxt.model.Stops;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ParsingJson {

    public static void main(String[] args) {

        // extracting data from a file Json
        ParsingJson parser = new ParsingJson();

        Root root = parser.parse();

        System.out.println("Root " + root.toString());
    }


    public Root parse() {

        Root root = new Root();

        JSONParser parser = new JSONParser();


        try (FileReader reader = new FileReader("AllStops.json")) {

            JSONObject rootJsonObject = (JSONObject) parser.parse(reader);

            String fileJson = (String) rootJsonObject.get("fileJson");


            JSONArray stopsJsonArray = (JSONArray) rootJsonObject.get("stops");

            List<Stops> stopsList = new ArrayList<>();

            for (Object it : stopsJsonArray) {
                JSONObject stopsJsonObject = (JSONObject) it;

                String stopName = (String) stopsJsonObject.get("stopName");
                Long stopId = (Long) stopsJsonObject.get("stopId");

                Stops stops = new Stops(stopName, stopId);
                stopsList.add(stops);
            }

            root.setFileJson(fileJson);
            root.setStops(stopsList);

            return root;
        } catch (Exception e) {
            System.out.println("Parsing error" + e.toString());
        }

        return null;
    }

}
