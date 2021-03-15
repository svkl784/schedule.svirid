package domain.task.task_list;

import domain.task.Task;

import java.text.Collator;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public final class TaskList  {
    private static final List<Task> taskList = new LinkedList<>();

    public TaskList() {
    }

    public static void addList(Task task) {
        taskList.add(task);
    }

    public static void sortList() {
        Collections.sort(taskList, (o1, o2) -> Collator.getInstance().compare(o1, o2));
    }

    public static void deleteList(String taskName) {
        taskList.stream()
                .filter(task -> task.getTaskName().equals(taskName))
                .findFirst()
                .ifPresent(taskList::remove);
    }

    public static void printList() {
        System.out.println("----------------------TaskList------------------------");
        taskList.forEach(System.out::println);
        System.out.println("------------------------------------------------------");

    }

    public static void sortByListAndPrint() {
        taskList
                .stream()
                .sorted()
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public static void sortByTaskNameAndPriority() {
        taskList
                .stream()
                .map(task -> "Task name: " + task.getTaskName() + "; Priority task: " + task.getPriority())
                .forEach(System.out::println);
    }

    public static void sortByTaskNameAndCategory() {
        taskList
                .stream()
                .map(task -> "Task name: " + task.getTaskName() + "; Category task: " + task.getCategory())
                .forEach(System.out::println);
    }


    public static void filterByListLengthTaskName() {
        taskList
                .stream()
                .filter(task -> task.getTaskName().length() > 1)
                .forEach(System.out::println);
    }

    public static void timeDeadlines() {
        taskList
                .stream()
                .map(task -> task.getTaskName()+": "+task.getDeadline())
                .forEach(System.out::println);
    }

    public static List<Task> getTaskList() {
            return taskList;
        }

    }




