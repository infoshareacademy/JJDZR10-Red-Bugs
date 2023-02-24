package Service;

import Data.Stop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RoutePlanner {
    private int beginningStop;
    private int endingStop;

    private String[] listOfStops;

    // metody na pewno do poprawki jak zrobimy już plik z dostępnymi przystankami, itd.
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
                beginningStop = scanner.nextInt();
                stopIncorrect = false;
            } catch (InputMismatchException e) {
                System.out.println("Uwaga: wprowadź numer wybranego przystanku");
            }

        } return beginningStop;
    }

}
