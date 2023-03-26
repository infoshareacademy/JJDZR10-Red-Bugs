package com.isa.pl.redbugs.model;

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
                System.out.println("1. Login");
                System.out.println("2. Register");
                System.out.println("3. Schedule");
                System.out.println("4. Bus stop list");
                System.out.println("5. Route");
                System.out.println("6. Exit");
                System.out.println(" ");
                System.out.print("Enter number: ");

                numMenu = scanner.nextInt();

                switch (numMenu) {
                    case 1:
                        System.out.println("Login");
                        UserAdder.logUser();
                        returnToMenu();
                        break;
                    case 2:
                        System.out.println("Register");
                        UserAdder.createUser();
                        returnToMenu();
                        break;
                    case 3:
                        System.out.println("Schedule");
                        Schedule.chooseStop();
                        returnToMenu();
                        break;
                    case 4:
                        System.out.println("Bus stop list");
                        System.out.println("View all stops : 1");
                        System.out.println("Create new stops : 2");
                        System.out.println("Exit : 3");
                        System.out.print("Enter number: ");
                        numMenu = scanner.nextInt();

                        switch (numMenu) {
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                System.out.println("Exit");
                                System.out.println("Goodbye!");
                                break;

                        }
                        break;
                    case 5:
                        System.out.println("Route");
                        break;

                    case 6:
                        System.out.println("Exit");
                        System.out.println("Goodbye!");
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
