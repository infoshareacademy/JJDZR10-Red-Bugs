package com.isa.pl.redbugs.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Schedule {

    private Integer dateTime;
    private static String[] listOfStops;
    private static int chooseStop;
    private Vehicle vehicle;

    public Integer getDateTime() {
        return dateTime;
    }

    public void setDateTime(Integer dateTime) {
        this.dateTime = dateTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public static void getStopList() {

        Path pathToStopList = Path.of("stops.json");
        try {
            String content = Files.readString(pathToStopList);
            listOfStops = content.split("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String listOfStop : listOfStops) {
            System.out.println(listOfStop);
        }
    }

    public static int chooseStop() {

        boolean stopIncorrect = true;

        while (stopIncorrect) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose stop from the list:\n");
            getStopList();
            try {
                chooseStop = scanner.nextInt() ; //usunalem -1
                stopIncorrect = false;
            } catch (InputMismatchException e) {
                System.out.println("Note: enter the number of the selected stop");
            }
            System.out.println("Selected stop shedule: " + listOfStops[chooseStop] + " is: ");
        }
        return chooseStop;
    }
}
