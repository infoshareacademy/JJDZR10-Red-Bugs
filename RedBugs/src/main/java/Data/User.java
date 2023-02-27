package Data;

public class User {
    private String name;
    private String surname;
    private String login;
    private String password;
    private int id;

    //userRoute is unavilable at current moment, due to lack of data in class UserRoute
    private UserRoute userRoute;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public String setPassword(String password) {
        this.password = password;
        return password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserRoute getUserRoute() {
        return userRoute;
    }

    public void setUserRoute(UserRoute userRoute) {
        this.userRoute = userRoute;
    }
}
