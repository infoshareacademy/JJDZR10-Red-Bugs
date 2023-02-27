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

    private int beginningStop;
    private int endingStop;
    private String[] listOfStops;
    private LocalDate dateOfJourney;
    private LocalTime timeOfJourney;

    // metody na pewno do poprawki jak zrobimy już plik z dostępnymi przystankami, itd.
    public LocalDate chooseDateOfJourney(){

        boolean dateIncorrect = true;

        while (dateIncorrect) {
            Scanner scanner = new Scanner(System.in);

            try {
                System.out.println("Podaj datę odjazdu (dzień): ");
                int d = scanner.nextInt();

                System.out.println("Podaj datę odjazdu (miesiąc): ");
                int m = scanner.nextInt();

                System.out.println("Podaj datę odjazdu (rok): ");
                int y = scanner.nextInt();

                dateOfJourney = LocalDate.of(y, m, d);
                if (dateOfJourney.isAfter(LocalDate.now())) {
                    dateIncorrect = false;
                } else {
                    System.out.println("Data podróży nie może być wcześniejsza niż dziś. Spróbuj ponownie.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Wprowadź poprawne dane.");
            } catch (DateTimeException f){
                System.out.println("Niepoprawna data, wprowadź dane ponownie.");
            }

        }
        return dateOfJourney;
    }

    public LocalTime chooseTimeOfJourney(){

        boolean timeIncorrect = true;

        while (timeIncorrect) {
            Scanner scanner = new Scanner(System.in);

            try {
                System.out.println("Podaj czas odjazdu odjazdu (godzina): ");
                int h = scanner.nextInt();

                System.out.println("Podaj czas odjazdu (minuta): ");
                int m = scanner.nextInt();

                timeOfJourney = LocalTime.of(h, m);
                timeIncorrect = false;

            } catch (InputMismatchException e) {
                System.out.println("Wprowadź poprawne dane");
            } catch (DateTimeException f){
                System.out.println("Niepoprawny czas, wprowadź dane ponownie.");
            }

        }
        return timeOfJourney;
    }
    public void getStopList() {
        Path pathToStopList = Path.of("src", "main", "java", "Data", "TestStops.txt");

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

    public int chooseBeginningStop() {

        boolean stopIncorrect = true;

        while (stopIncorrect) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Wybierz przystanek początkowy z listy:\n");
            getStopList();
            try {
                beginningStop = scanner.nextInt() - 1;
                stopIncorrect = false;
            } catch (InputMismatchException e) {
                System.out.println("Uwaga: wprowadź numer wybranego przystanku");
            }

        } return beginningStop;
    }

    public int chooseEndingStop() {

        boolean stopIncorrect = true;

        while (stopIncorrect) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Wybierz przystanek końcowy z listy:\n");
            getStopList();
            try {
                endingStop = scanner.nextInt() -  1;
                stopIncorrect = false;
            } catch (InputMismatchException e) {
                System.out.println("Uwaga: wprowadź numer wybranego przystanku");
            }

        } return endingStop;
    }

    public void summarizeRoute() {

        System.out.println("Wybrany przystanek początkowy: " + listOfStops[beginningStop]);
        System.out.println("Wybrany przystanek końcowy: " + listOfStops[endingStop]);
        System.out.println("Wybrany czas podróży: " + dateOfJourney + " " + timeOfJourney);
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
