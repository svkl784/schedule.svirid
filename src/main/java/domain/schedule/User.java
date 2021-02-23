package domain.schedule;


public class User  {
    private final String name;
    private final String login;
    private final int password;

    public User(Builder builder) {
        name = builder.name;
        login = (String) builder.login;
        password = (int) builder.password;
    }


    public static class Builder<T, V> {
        private final String name;
        private final T login;
        private final V password;

        public Builder(String name, T login, V password) {
            this.name = name;
            this.login = login;
            this.password = password;
        }

        public User build() {
            return new User(this);
        }

        @Override
        public String toString() {
            return "---------------Information on user--------------------" + '\n' +
                    "Name: " + name + '\n' +
                    "Login: " + login + '\n' +
                    "Password: " + "******" + '\n' +
                    "-----------------------------------------------------";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder<String, Integer> user = (Builder) o;
            return name != null && name.equals(user.name) &&
                    login != null && login.equals(user.login)
                    && password == user.password;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            result = prime * result + ((login == null) ? 0 : login.hashCode());
            result = prime * result + (int) password;
            return result;
        }

    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public int getPassword() {
        return password;
    }
}
