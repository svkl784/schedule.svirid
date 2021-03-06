package application;

import domain.enums.Category;
import domain.enums.Priority;
import domain.schedule.*;
import domain.schedule.User;
import domain.task_list.TaskList;

import java.io.File;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Application implements Serializable {
    public static void main(String[] args) {

        System.out.println("------------Welcome to Natalia's schedule--------------");
        System.out.println();
//        Scanner scanner = new Scanner(System.in);
//        File file = new File("schedule.txt");
        try {
            TaskRepeat taskRepeat1 = new TaskRepeat(
                    "Event",
                    Priority.HIGH,
                    Category.WORK,
                    "07/03/2021",
                    "Meeting with the boss in the office",
                    "15/03/2021");
            TaskRepeat taskRepeat2 = new TaskRepeat(
                    "Personal",
                    Priority.MEDIUM,
                    Category.PERSONAL,
                    "01/03/2021",
                    "JIM'S BIRTHDAY",
                    "09/03/2021");
            TaskRepeat taskRepeat3 = new TaskRepeat(
                    "Exam",
                    Priority.HIGH,
                    Category.STUDY,
                    "04/03/2021",
                    "Exam in philosophy",
                    "NOT REPEAT");

            CriticalDeadline criticalDeadline1 = new CriticalDeadline(taskRepeat2, "28/02/2021");
            System.out.println(criticalDeadline1);
            taskRepeat1.dateLineNow();
            taskRepeat2.dateLineNow();
            taskRepeat3.dateLineNow();
            TaskList.addList(taskRepeat1);
            TaskList.addList(taskRepeat2);
            TaskList.addList(taskRepeat3);
            TaskList.printList();
            TaskList.sortByTaskNameAndCategory();
            TaskList.printList();
            TaskList.filterByListLengthTaskName();
            TaskList.printList();
            User.Builder<String, Integer> user = new User.Builder<>(
                    "Nataliya",
                    "svk",
                    465455);
            user.userInfo();

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("-------------------Good Bye--------------------------");
        }

    }
}
