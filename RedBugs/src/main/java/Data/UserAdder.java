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

            System.out.println("Rejestracja użytkownika");

            try {

                System.out.println("Imię: ");

                String name = scanner.nextLine().toLowerCase();
                user.setName(name);

                System.out.println("Nazwisko: ");

                String surname = scanner.nextLine().toLowerCase();
                user.setSurname(surname);

                System.out.println("Login: ");

                String login = scanner.nextLine().toLowerCase();
                user.setLogin(login);

                System.out.println("Hasło: ");

                String password = scanner.nextLine().toLowerCase();
                user.setPassword(password);

                user.setId(id + 1);

                System.out.println("Czy chcesz stworzyć kolejnego użytkownika? Jeśli tak, wpisz 't'");

                anotherUser = scanner.nextLine();

                System.out.println("Użytkownik został utworzony");

            } catch (InputMismatchException e) {

                System.out.println("Niepoprawne dane");

            }
        } while (anotherUser.equals("t"));

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
        System.out.println("Login: ");

        String currentLogin = scanner.nextLine().toLowerCase();

        try {

            if (currentLogin.equals(iLogin)) {

                System.out.println("Hasło: ");

                String currentPassword = scanner.nextLine().toLowerCase();

                if (currentPassword.equals(iPassword)) {
                    System.out.println("Zostałeś zalogowany jako: " + iLogin);
                } else {
                    System.out.println("Wprowadzono niepoprawny login lub hasło");
                }
            }


        } catch (Exception e) {
            System.out.println("Wprowadzono niepoprawne dane");
            throw new RuntimeException(e);
        }
    }
}













