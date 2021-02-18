package domain.schedule;

interface UserService {
    void printUserInfo();

}

public class User implements UserService{
    private String userName;
    private UserId idString;
    private UserId idInteger;

    public User() {
    }


    public User(String userName, UserId idString, UserId idInteger) {
        this.userName = userName;
        this.idString = idString;
        this.idInteger = idInteger;
    }

    public User(UserId.UserBuilder userBuilder) {
        this.userName = userBuilder.userName;
        this.idString = userBuilder.idString;
        this.idInteger = userBuilder.idInteger;
    }


    public String getUserName() {
        return userName;
    }

    public UserId getIdString() {
        return idString;
    }

    public UserId getIdInteger() {
        return idInteger;
    }


    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", idString=" + idString +
                ", idInteger=" + idInteger +
                '}';
    }



    @Override
    public void printUserInfo() {
        System.out.println("------------------User info----------------------");
        System.out.println("userName: "+userName+", Id String: "+idString+", Id Integer: "+idInteger);

    }



    static class UserId<T> {
        private T id;

        public UserId() {
        }

        public UserId(T id) {
            this.id = id;
        }

        public T getId() {
            return id;
        }

        public void setId(T id) {
            this.id = id;
        }


        static class UserBuilder {
            protected String userName;
            protected UserId<String> idString;
            protected UserId<Integer> idInteger;

            public UserBuilder() {
            }

            public UserBuilder(String userName) {
                this.userName = userName;
            }

            public UserId<String> getIdString() {
                return idString;
            }

            public UserBuilder setIdString(UserId<String> idString) {
                this.idString = idString;
                return this;
            }

            public UserId<Integer> getIdInteger() {
                return idInteger;
            }

            public UserBuilder setIdInteger(UserId<Integer> idInteger) {
                this.idInteger = idInteger;
                return this;
            }

            public User userBuilder() {
                return new User(this);
            }
        }
    }
}
