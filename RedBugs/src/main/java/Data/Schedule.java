package Data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Schedule {

    private Integer dateTime;
    private static String[] listOfStops;
    private static int chosenStop;
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

        Path pathToStopList = Path.of("stops.txt");
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
            System.out.println("Wybierz przystanek z listy:\n");
            getStopList();
            try {
                chosenStop = scanner.nextInt() ;
                stopIncorrect = false;
            } catch (InputMismatchException e) {
                System.out.println("Uwaga: podaj numer wybranego przystanku");
            }
            System.out.println("Rozkład jazdy dla linii " + listOfStops[chosenStop] + ": ");
        }
        return chosenStop;
    }
}
