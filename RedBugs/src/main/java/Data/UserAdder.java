package Data;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserAdder {
    public static User createUser() {

        User user = new User();
        int id = 0;

        String anotherUser = null;
        Scanner scanner = new Scanner(System.in);

        do {

            System.out.println("Rejestracja. ");

            try {

                System.out.println("Wprowadź imię użytkownika:");

                String name = scanner.nextLine().toLowerCase();
                user.setName(name);

                System.out.println("Wprowadź nazwisko użytkownika:");

                String surname = scanner.nextLine().toLowerCase();
                user.setSurname(surname);

                System.out.println("Wprowadź login użytkownika:");

                String login = scanner.nextLine().toLowerCase();
                user.setLogin(login);

                System.out.println("Wprowadź hasło użytkownika:");

                String password = scanner.nextLine().toLowerCase();
                user.setPassword(password);

                user.setId(id + 1);

                System.out.println("Czy chcesz stworzyć kolejnego użytkownika? Jeżeli tak, wciśnij 'y' ");

                anotherUser = scanner.nextLine();

                System.out.println("Zakończono procedurę tworzenia uzytkownika");

            } catch (InputMismatchException e) {

                System.out.println("Podana przez Ciebie wartość nie jest prawidłowa. ");

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

        System.out.println("Logowanie");
        System.out.printf("login:");

        String currentLogin = scanner.nextLine().toLowerCase();

        try {

            if (currentLogin.equals(iLogin)) {

                System.out.println("hasło:");

                String currentPassword = scanner.nextLine().toLowerCase();

                if (currentPassword.equals(iPassword)) {
                    System.out.println("Zostałeś zalogowany jako użytkownik:" + iLogin);
                } else {
                    System.out.println("Podałeś nieprawidłowe hasło lub login");
                }
            }
        } catch (InputMismatchException e) {

            System.out.println("Podana przez Ciebie wartość nie jest prawidłowa. ");

        }
    }
}







