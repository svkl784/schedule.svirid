package application;

import domain.enums.Category;
import domain.enums.Priority;
import domain.schedule.*;
import domain.schedule.User;
import domain.task_list.TaskList;

import java.text.ParseException;

public class Application {
    public static void main(String[] args) throws ParseException  {
        System.out.println();
        TaskRepeat taskRepeat1 = new TaskRepeat(
                "Event",
                Priority.HIGH,
                Category.WORK,
                "21/02/2021",
                "Meeting with the boss in the office",
                "05/03/2021");
        TaskRepeat taskRepeat2 = new TaskRepeat(
                "Personal",
                Priority.MEDIUM,
                Category.PERSONAL,
                "01/03/2021",
                "JIM'S BIRTHDAY",
                "01/03/2021");
        TaskRepeat taskRepeat3 = new TaskRepeat(
                "Exam",
                Priority.HIGH,
                Category.STUDY,
                "04/03/2021",
                "Exam in philosophy",
                "NOT REPEAT");
        CriticalDeadline criticalDeadline1 = new CriticalDeadline(taskRepeat2,"28/02/2021");
        System.out.println(criticalDeadline1);
        TaskList.addList(taskRepeat1);
        TaskList.addList(taskRepeat2);
        TaskList.addList(taskRepeat3);
        TaskList.printList();
        TaskList.sortByTaskNameAndCategory();
        TaskList.printList();
        TaskList.filterByListLengthTaskName();
        TaskList.printList();
        User.Builder <String, Integer> user = new User.Builder<>(
                "Nataliya",
                "svk",
                465455);
        user.userInfo();

    }
}
