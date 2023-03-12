package Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RoutePlanner {

    private static int beginningStop;
    private static int endingStop;
    private static String[] listOfStops;
    private static LocalDate dateOfJourney;
    private static LocalTime timeOfJourney;

    // metody na pewno do poprawki jak zrobimy już plik z dostępnymi przystankami, itd.
    public static void routePlanner(){
        chooseDateOfJourney();
        chooseTimeOfJourney();
        getStopList();
        chooseBeginningStop();
        chooseEndingStop();
        summarizeRoute();

    };

    public static LocalDate chooseDateOfJourney(){

        boolean dateIncorrect = true;

        while (dateIncorrect) {
            Scanner scanner = new Scanner(System.in);

            try {
                System.out.println("Enter departure date (day): ");
                int d = scanner.nextInt();

                System.out.println("Enter departure date (month): ");
                int m = scanner.nextInt();

                System.out.println("Enter departure date (year): ");
                int y = scanner.nextInt();

                dateOfJourney = LocalDate.of(y, m, d);
                if (dateOfJourney.isAfter(LocalDate.now())) {
                    dateIncorrect = false;
                } else {
                    System.out.println("Travel date cannot be earlier than today. Try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Please enter the correct details");
            } catch (DateTimeException f){
                System.out.println("Incorrect date, please re-enter the data.");
            }

        }
        return dateOfJourney;
    }

    public static LocalTime chooseTimeOfJourney(){

        boolean timeIncorrect = true;

        while (timeIncorrect) {
            Scanner scanner = new Scanner(System.in);

            try {
                System.out.println("\n" +
                        "Enter the departure time of departure (time): ");
                int h = scanner.nextInt();

                System.out.println("Enter departure time (minute): ");
                int m = scanner.nextInt();

                timeOfJourney = LocalTime.of(h, m);
                timeIncorrect = false;

            } catch (InputMismatchException e) {
                System.out.println("Please enter the correct details");
            } catch (DateTimeException f){
                System.out.println("Incorrect time, please re-enter.");
            }

        }
        return timeOfJourney;
    }
    public static void getStopList() {
        //Path pathToStopList = Path.of("src", "main", "java", "Data", "TestStops.txt");
        Path pathToStopList = Path.of("stops.txt");
        try {
            String content = Files.readString(pathToStopList);
            listOfStops = content.split("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < listOfStops.length; i++) {
            System.out.println(listOfStops[i]);
        }
    }

    public static int chooseBeginningStop() {

        boolean stopIncorrect = true;

        while (stopIncorrect) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select your starting stop from the list:\n");
            getStopList();
            try {
                beginningStop = scanner.nextInt() ; //usunalem -1
                stopIncorrect = false;
            } catch (InputMismatchException e) {
                System.out.println("Note: enter the number of the selected stop");
            }

        } return beginningStop;
    }

    public static int chooseEndingStop() {

        boolean stopIncorrect = true;

        while (stopIncorrect) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select the final stop from the list:\n");
            getStopList();
            try {
                endingStop = scanner.nextInt() ;//usunalem -1
                stopIncorrect = false;
            } catch (InputMismatchException e) {
                System.out.println("Note: enter the number of the selected stop");
            }

        } return endingStop;
    }

    public static void summarizeRoute() {

        System.out.println("Selected startimg stop: " + listOfStops[beginningStop]);
        System.out.println("Selected final stop: " + listOfStops[endingStop]);
        System.out.println("Selected travel time: " + dateOfJourney + " " + timeOfJourney);
    }

    public int getBeginningStop() {
        return beginningStop;
    }

    public void setBeginningStop(int beginningStop) {
        this.beginningStop = beginningStop;
    }

    public int getEndingStop() {
        return endingStop;
    }

    public void setEndingStop(int endingStop) {
        this.endingStop = endingStop;
    }

    public String[] getListOfStops() {
        return listOfStops;
    }

    public void setListOfStops(String[] listOfStops) {
        this.listOfStops = listOfStops;
    }

    public LocalDate getDateOfJourney() {
        return dateOfJourney;
    }

    public void setDateOfJourney(LocalDate dateOfJourney) {
        this.dateOfJourney = dateOfJourney;
    }

    public LocalTime getTimeOfJourney() {
        return timeOfJourney;
    }

    public void setTimeOfJourney(LocalTime timeOfJourney) {
        this.timeOfJourney = timeOfJourney;
    }
}
