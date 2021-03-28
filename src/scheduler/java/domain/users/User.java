package domain.users;



import exception.PasswordException;

import java.io.Serializable;
import java.util.Objects;

public class User<T> implements UserService, Serializable {
    private static final long SERIAL_VERSION_UID = 1L;
    public static final int PASSWORD_LENGTH = 5;
    private String name;
    private String login;
    private T password;
    private T id;


    public User(String name, String login, T password, T id) {
        try {
            this.name = name;
            this.login = login;
            this.password = password;
            this.id = id;
         if (password.toString().length() < PASSWORD_LENGTH) {
            throw new PasswordException();
        }}
     catch (PasswordException e){
         System.out.println(e);;
     }
}

    public User() {
    }



    @Override
    public void userInfo() {
        System.out.println(
                "---------------Information on user--------------------" + '\n' +
                        "Name: " + name + '\n' +
                        "Login: " + login + '\n' +
                        "Password: " + "******" + '\n' +
                        "-----------------------------------------------------");
    }

    public static class Builder<T> extends User {

        private User<T> userBuilder;

        public Builder() {
            userBuilder = new User<>();
        }

        public Builder<T> enterName(String name) {
            userBuilder.name = name;
            return this;
        }

        public Builder<T> enterLogin(String login) {
            userBuilder.login = login;
            return this;
        }

        public Builder<T> enterPassword(T password) {
            try {
                userBuilder.password = password;
                if (password.toString().length() < PASSWORD_LENGTH) {
                    throw new PasswordException();
                }} catch (PasswordException e) {
                System.out.println(e);
                System.exit(1);
            }
            return this;
        }

        public Builder<T> enterId(T id) {
            userBuilder.id = id;
            return this;
        }

        public User<T> build() {
            return userBuilder;
        }
    }

    @Override
    public String toString() {
            return "User " + "\n" +
                    "name:" + name + "\n" +
                    "login:" + login + "\n" +
                    "password:" + password + "\n" +
                    "id:" + id + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name != null && name.equals(user.name) &&
                login != null && login.equals(user.login) &&
                password == user.password &&
                id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, login, password, id);
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public T getPassword() {
        return password;
    }

    public T getId() {
        return id;
    }
}
