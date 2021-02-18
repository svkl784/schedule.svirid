package domain.task_list;

import domain.schedule.Task;

import java.text.Collator;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public final class TaskList {
    private static final List<Task> taskList = new LinkedList<>();

    private TaskList() {
    }

    public static void addList(Task task) {
        taskList.add(task);
    }

    public static void sortList() {
        Collections.sort(taskList, (o1, o2) -> Collator.getInstance().compare(o1, o2));
    }

    public static void deleteList(String taskDescription) {
        taskList.stream()
                .filter(task -> task.getTaskDescription().equals(taskDescription))
                .findFirst()
                .ifPresent(taskList::remove);
    }

    public static void printList() {
        System.out.println("------------------TaskList----------------------");
        taskList.forEach(System.out::println);

    }

    public static void sortByListAndPrint() {
        taskList.stream()
//                .filter(taskList -> taskList.length() > 1)
                .sorted()
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}



