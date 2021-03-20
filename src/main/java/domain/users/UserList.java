package domain.users;

import java.text.Collator;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class UserList {
    private static List<User> usersList = new LinkedList<>();

    public UserList() {
    }

    public static void addList(User user) {
        usersList.add(user);
    }

    public static void sortList() {
        Collections.sort(usersList, (o1, o2) -> Collator.getInstance().compare(o1, o2));
    }

    public static void deleteUser(String name) {
        usersList.stream()
                .filter(task -> task.getName().equals(name))
                .findFirst()
                .ifPresent(usersList::remove);
    }
    public static void printList() {
        System.out.println("----------------------Users List------------------------");
        usersList.forEach(System.out::println);
        System.out.println("------------------------------------------------------");

    }

    public static List<User> getUsersList() {
        return usersList;
    }
}