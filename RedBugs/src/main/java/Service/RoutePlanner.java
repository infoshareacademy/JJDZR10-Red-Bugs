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
                System.out.println("Podaj dzień odjazdu: ");
                int d = scanner.nextInt();

                System.out.println("Podaj miesiąc odjazdu: ");
                int m = scanner.nextInt();

                System.out.println("Podaj rok odjazdu: ");
                int y = scanner.nextInt();

                dateOfJourney = LocalDate.of(y, m, d);
                if (dateOfJourney.isAfter(LocalDate.now())) {
                    dateIncorrect = false;
                } else {
                    System.out.println("Data podróży nie może być wcześniejsza niż dzisiejsza data. Spróbuj ponownie.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Podaj poprawne dane");
            } catch (DateTimeException f){
                System.out.println("Niepoprawna data, wprowadź ponownie.");
            }

        }
        return dateOfJourney;
    }

    public static LocalTime chooseTimeOfJourney(){

        boolean timeIncorrect = true;

        while (timeIncorrect) {
            Scanner scanner = new Scanner(System.in);

            try {
                System.out.println("\n" + "Podaj godzinę odjazdu: ");
                int h = scanner.nextInt();

                System.out.println("Podaj minutę odjazdu: ");
                int m = scanner.nextInt();

                timeOfJourney = LocalTime.of(h, m);
                timeIncorrect = false;

            } catch (InputMismatchException e) {
                System.out.println("Wprowadź poprawne dane");
            } catch (DateTimeException f){
                System.out.println("Niepoprawny czas, wprowadź ponownie");
            }

        }
        return timeOfJourney;
    }
    public static void getStopList() {
        Path pathToStopList = Path.of("stops.txt"); // plik txt do zmiany
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
            System.out.println("Wybierz przystanek początkowy:\n");
            getStopList();
            try {
                beginningStop = scanner.nextInt() ;
                stopIncorrect = false;
            } catch (InputMismatchException e) {
                System.out.println("Uwaga: podaj numer wybranego przystanku");
            }

        } return beginningStop;
    }

    public static int chooseEndingStop() {

        boolean stopIncorrect = true;

        while (stopIncorrect) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Podaj przystanek końcowy:\n");
            getStopList();
            try {
                endingStop = scanner.nextInt() ;
                stopIncorrect = false;
            } catch (InputMismatchException e) {
                System.out.println("Uwaga: podaj numer wybranego przystanku");
            }

        } return endingStop;
    }

    public static void summarizeRoute() {

        System.out.println("Z: " + listOfStops[beginningStop]);
        System.out.println("Do : " + listOfStops[endingStop]);
        System.out.println("Data odjazdu: " + dateOfJourney + " " + timeOfJourney);
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
