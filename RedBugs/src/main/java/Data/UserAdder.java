package Data;

import java.util.Scanner;

public class UserAdder {
    public static User createUser() {

        Scanner scanner = new Scanner(System.in);

        User user = new User();

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

        return user;
    }


}

