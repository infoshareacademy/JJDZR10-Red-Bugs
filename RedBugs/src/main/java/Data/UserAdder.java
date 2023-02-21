package Data;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserAdder {
    public static User createUser() {

        User user = new User();
        int userChecker = 1;
        int anotherUser = 1;
        Scanner scanner = new Scanner(System.in);

        while (userChecker == anotherUser) {

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

                // ID should be generated automiaticly - work in progress
                System.out.println("Wprowadź ID użytkownika:");


                int id = scanner.nextInt();
                user.setId(id);

                System.out.println("Czy chcesz stworzyć kolejnego użytkownika? Jeżeli tak, wciśnij 'y' ");

                anotherUser = scanner.nextInt();

                if (anotherUser !=1) break;


            } catch (InputMismatchException e) {

                System.out.println("Podana przez Ciebie wartość nie jest prawidłowa. ");

            }

            System.out.println("Zakończono procedurę tworzenia uzytkownika");
        }
        return user;

    }
}







