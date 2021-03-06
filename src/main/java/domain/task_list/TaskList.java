package domain.task_list;

import domain.schedule.Task;

import java.text.Collator;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

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

    public static void timeUntilDeadline() {
        taskList
                .stream()
                .map(task -> task.getDeadline())
                .forEach(System.out::println);

    }



    public static List<Task> getTaskList() {
            return taskList;
        }

    }




