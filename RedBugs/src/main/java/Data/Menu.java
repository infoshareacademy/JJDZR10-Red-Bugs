package Data;

import Service.RoutePlanner;

import java.util.Scanner;


public class Menu {
    private static int numMenu;
    private static int numberExit;
    private static boolean in = false;

    public static void menu() throws Exception, Error {
        System.out.println(" ");
        System.out.println("Witaj!");
        System.out.println(" ");

        do {
            try {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Menu");
                System.out.println(" ");
                System.out.println("1. Logowanie");
                System.out.println("2. Rejestracja");
                System.out.println("3. Rozkład jazdy");
                System.out.println("4. Lista przystanków");
                System.out.println("5. Trasa");
                System.out.println("6. Wyjście");
                System.out.println(" ");
                System.out.print("Wpisz numer: ");

                numMenu = scanner.nextInt();

                switch (numMenu) {
                    case 1:
                        System.out.println("Logowanie");
                        UserAdder.logUser();
                        returnToMenu();
                        break;
                    case 2:
                        System.out.println("Rejestracja");
                        UserAdder.createUser();
                        returnToMenu();
                        break;
                    case 3:
                        System.out.println("Rozkład jazdy");
                        Schedule.chooseStop();
                        //BookExcel.readListBusStop("myFile.xlt");
                        returnToMenu();
                        break;
                    case 4:
                        System.out.println("Lista przystanków");
                        System.out.println("1. Pokaż wszystkie przystanki");
                        System.out.println("2. Dodaj nowy przystanek");
                        System.out.println("3. Wyjście");
                        System.out.print("Wpisz numer: ");
                        numMenu = scanner.nextInt();

                        switch (numMenu) {
                            case 1:
                                Data.Route.routesreader();
                                returnToMenu();
                                break;
                            case 2:
                                Data.Route.routescreator();
                                returnToMenu();
                                break;
                            case 3:
                                System.out.println("Wyjście");
                                break;

                        }
                        break;
                    case 5:
                        System.out.println("Trasa");
                        RoutePlanner.routePlanner();
                        break;

                    case 6:
                        System.out.println("Wyjście");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Podaj numer większy od 0");
            } catch (Error b) {
                System.out.println("Numer nie może być większy niż 6");
            }
        } while (getNumMenu() != 6);

    }

    public static void returnToMenu() throws Exception {

        do {
            try {
                Scanner scannerReturn = new Scanner(System.in);

                System.out.print("Wpisz 1 aby wyjść: ");

                numberExit = scannerReturn.nextInt();

                switch (numberExit) {
                    case 1:

                        System.out.println("Powrót do menu");
                        break;
                }
            } catch (Exception a) {
                System.out.println("Wpisz poprawny numer: ");
            }
        } while (getNumberExit() != 1);
    }

    public static int getNumberExit() {
        return numberExit;
    }

    public static int getNumMenu() {
        return numMenu;


    }
}
