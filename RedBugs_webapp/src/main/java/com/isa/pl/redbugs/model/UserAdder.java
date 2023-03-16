package com.isa.pl.redbugs.model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserAdder {
    public static User createUser() {

        User user = new User();
        int id = 0;

        String anotherUser = null;
        Scanner scanner = new Scanner(System.in);

        do {

            System.out.println("Registration. ");

            try {

                System.out.println("Please enter your username:");

                String name = scanner.nextLine().toLowerCase();
                user.setName(name);

                System.out.println("Please enter your surname:");

                String surname = scanner.nextLine().toLowerCase();
                user.setSurname(surname);

                System.out.println("Provide user login:");

                String login = scanner.nextLine().toLowerCase();
                user.setLogin(login);

                System.out.println("Provide user password:");

                String password = scanner.nextLine().toLowerCase();
                user.setPassword(password);

                user.setId(id + 1);

                System.out.println("Do you want to create another user? If so, press 'y'");

                anotherUser = scanner.nextLine();

                System.out.println("The user creation process has been completed");

            } catch (InputMismatchException e) {

                System.out.println("The value you entered is not valid. ");

            }
        } while (anotherUser.equals("y"));

        return user;
    }

    public static void logUser() {

        Scanner scanner = new Scanner(System.in);

        User user = createUser();
        //temporarly values for program checkout
        String iPassword = user.getPassword();
        String iLogin = user.getLogin();
        int iid = user.getId();


        //test
        System.out.println(user.getPassword());
        System.out.println(user.getLogin());

        System.out.println("Login");
        System.out.printf("Login:");

        String currentLogin = scanner.nextLine().toLowerCase();

        try {

            if (currentLogin.equals(iLogin)) {

                System.out.println("Password:");

                String currentPassword = scanner.nextLine().toLowerCase();

                if (currentPassword.equals(iPassword)) {
                    System.out.println("You have been logged in as user:" + iLogin);
                } else {
                    System.out.println("You have entered an incorrect password or login");
                }
            }


        } catch (Exception e) {
            System.out.println("The value you entered is not valid. ");
            throw new RuntimeException(e);
        }
    }
}













