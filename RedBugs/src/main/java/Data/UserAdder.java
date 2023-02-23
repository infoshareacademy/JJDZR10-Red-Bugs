package Data;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserAdder {
    public static User createUser() {

        User user = new User();
        int id = 1;

        String anotherUser = null;
        Scanner scanner = new Scanner(System.in);

        do {

            System.out.println("Rozpoczynasz procedurę wprowadzania nowego użytkownika. ");

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

        //temporarly values for program checkout
        String iPaswrod = createUser().getPassword();
        String iLogin = createUser().getLogin();

        System.out.println("Rozpocząłeś procedurę logowania.");
        System.out.printf("Podaj login użytkownika:");

        String currentLogin = scanner.nextLine().toLowerCase();

        try {

            if (currentLogin.equals(iLogin)) {

                System.out.println("Podaj hasło użytkownika:");

                String currentPassword = scanner.nextLine().toLowerCase();

                if (currentPassword.equals(iPaswrod)) {
                    System.out.println("Zostałeś zalogowany jako użytkownik:" + createUser().getName() + createUser().getSurname());
                } else {
                    System.out.println("Podałeś nieprawidłowe hasło.");
                }

            } else {
                System.out.println("podałeś nieprawidłowy login.");
            }
        } catch (InputMismatchException e) {

            System.out.println("Podana przez Ciebie wartość nie jest prawidłowa. ");

        }
    }
}







