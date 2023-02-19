package com.infoshareacademy;

import Data.Schedule;
import Data.Stop;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

import static Data.Menu.menu;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws Exception {
        System.out.println( "RedBugs" );
        Stop stop1 = new Stop(1,"Przystanek1", new Schedule());
        Stop stop2 = new Stop(2,"Przystanek2", new Schedule());
        Stop stop3 = new Stop(3,"Przystanek3", new Schedule());
        List <Stop> stopList= new ArrayList<>();
        stopList.add(stop1);
        stopList.add(stop2);
        stopList.add(stop3);
        ObjectMapper objectMapper = new ObjectMapper();
        String stopsAsString = objectMapper.writeValueAsString(stopList);


        menu();
    }
}