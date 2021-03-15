package domain.users;

import java.util.LinkedList;
import java.util.List;

public class UserList {
    private static List<User> usersList = new LinkedList<>();

    public UserList() {
    }

    public static void addList(User user) {
        usersList.add(user);
    }

    public static List<User> getUsersList() {
        return usersList;
    }
}
