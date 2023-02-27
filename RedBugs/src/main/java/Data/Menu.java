package Data;

import java.util.Scanner;


public class Menu {
    private static int numMenu;
    private static int numberExit;
    private static boolean in = false;

    public static void menu() throws Exception, Error {
        System.out.println(" ");
        System.out.println("Start Scan!");
        System.out.println(" ");

       do {
            try {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Menu");
                System.out.println(" ");
                System.out.println("1. Logowanie");
                System.out.println("2. Rejestracja");
                System.out.println("3. Rozkład jazdy");
                System.out.println("4. Bus stops");
                System.out.println("5. All routes");
                System.out.println("6. Exit");
                System.out.println(" ");
                System.out.print("Enter number: ");

                numMenu = scanner.nextInt();

                switch (numMenu) {
                    case 1:
                        System.out.println("Enter in Logowanie");
                        //Metods for Login
                        returnToMenu();
                        break;
                    case 2:
                        System.out.println("Enter in Rejestracja");
                        // Metods for Reastretion
                        returnToMenu();
                        break;
                    case 3:
                        System.out.println("Enter in Rozkład jazdy");
                        // Metods do rozdładu jazdy
                        //BookExcel.readListBusStop("myFile.xlt");
                        returnToMenu();
                        break;
                    case 4:
                        System.out.println("Enter in Bus stops");
                        // Metods for bus stops!
                        //BookExcel.readListBusOnStop("myFile.xlt");
                        returnToMenu();
                        break;
                    case 5:
                        System.out.println("All routes");
                        System.out.println("View all routes : 1");
                        System.out.println("Create new route : 2");
                        System.out.println("Exit : 3");
                        System.out.print("Enter number: ");
                        numMenu = scanner.nextInt();

                        switch (numMenu) {
                            case 1:
                                System.out.println("View all routes");
                                Data.Route.routesreader();
                                returnToMenu();
                                break;
                            case 2:
                                System.out.println("Create default route from file JSON");
                                Data.Route.routescreator();
                                returnToMenu();
                                break;
                            case 3:
                                System.out.println("Exit");
                                System.out.println("Goodbye!");
                                // Metods  for exit and goodbay!
                                break;

                        }
                        // Methods for All routes!
                        break;

                    case 6:
                        System.out.println("Exit");
                        System.out.println("Goodbye!");
                        // Metods  for exit and goodbay!
                        break;
                }
            } catch (Exception e) {
                System.out.println("Number can't be lass or equal zero!");
            } catch (Error b) {
                System.out.println("Number can't be more 6");
            }
        } while (getNumMenu() != 6);

        System.out.println("End Scan!");
    }

    public static void returnToMenu() throws Exception {

        do {
            try {
                Scanner scannerReturn = new Scanner(System.in);

                System.out.print("Enter number 1 for Exit: ");

                numberExit = scannerReturn.nextInt();

                switch (numberExit) {
                    case 1:

                        System.out.println("Enter in Menu.....");
                        //Metods for return menu
                        break;
                }
            } catch (Exception a) {
                System.out.println("Number must be one!");
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
