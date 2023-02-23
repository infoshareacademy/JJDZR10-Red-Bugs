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

                String name = scanner.nextLine();
                user.setName(name);

                System.out.println("Wprowadź nazwisko użytkownika:");

                String surname = scanner.nextLine();
                user.setSurname(surname);

                System.out.println("Wprowadź login użytkownika:");

                String login = scanner.nextLine();
                user.setLogin(login);

                System.out.println("Wprowadź hasło użytkownika:");

                String password = scanner.nextLine();
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
}







