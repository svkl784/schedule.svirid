package application;

import domain.task.CriticalDeadline;
import domain.task.TaskRepeat;
import domain.task.enums.Category;
import domain.task.enums.Priority;
import domain.users.User;
import domain.task.serialization.SerializationTask;
import domain.task.task_list.TaskList;
import domain.users.UserList;
import domain.users.seralization.SerializationUsers;
import exception.PasswordException;


import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;

public class Application implements Serializable {
    public static final String FILENAME1 = "schedule.txt";
    public static final String FILENAME2 = "users.txt";

    public static void main(String[] args) {

        System.out.println("------------Welcome to Natalia's schedule--------------");
        System.out.println();
        try {
            TaskRepeat taskRepeat1 = new TaskRepeat(
                    "Event",
                    Priority.HIGH,
                    Category.WORK,
                    LocalDate.of(2021, 03, 18),
                    "Meeting with the boss in the office",
                    LocalDate.of(2021, 05, 16));
            TaskRepeat taskRepeat2 = new TaskRepeat(
                    "Personal",
                    Priority.MEDIUM,
                    Category.PERSONAL,
                    LocalDate.of(2021, 03, 18),
                    "JIM'S BIRTHDAY",
                    LocalDate.of(2021, 03, 17));
            TaskRepeat taskRepeat3 = new TaskRepeat(
                    "Exam",
                    Priority.HIGH,
                    Category.STUDY,
                    LocalDate.of(2021, 07, 18),
                    "Exam in philosophy",
                    LocalDate.of(2022, 12, 12));

            CriticalDeadline criticalDeadline1 = new CriticalDeadline(taskRepeat2, "2021-12-13");
            System.out.println(criticalDeadline1);
            criticalDeadline1.correctDateEntry();
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
            User<?> user1 = new User.Builder<>()
                    .enterName("Nataliya")
                    .enterLogin("svk")
                    .enterPassword(564465)
                    .enterId("556669rfg44")
                    .build();
            User<?> user2 = new User.Builder<>()
                    .enterName("Alexander")
                    .enterLogin("kim")
                    .enterPassword(8978899)
                    .enterId("457lf987tws")
                    .build();
            UserList.addList(user1);
            UserList.addList(user2);
            user1.userInfo();
            user2.userInfo();
            UserList.printList();
            SerializationTask.writeTasks(TaskList.getTaskList());
            SerializationTask.readTask(FILENAME1);
            SerializationUsers.writeUsers(UserList.getUsersList());
            SerializationUsers.readUsers(FILENAME2);

        } catch (DateTimeException e) {
            System.out.println("INCORRECT DATE INPUT!");
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("-------------------Good Bye--------------------------");
        }

    }
}
