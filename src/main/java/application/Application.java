package application;

import domain.enums.Category;
import domain.enums.Priority;
import domain.schedule.Task;
import domain.schedule.TaskRepeat;
import domain.task_list.TaskList;

import java.text.ParseException;

public class Application {
    public static void main(String[] args) throws ParseException {
        TaskRepeat taskRepeat1 = new TaskRepeat(
                "Event",
                Priority.HIGH,
                Category.WORK,
                "25/02/2021",
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
        TaskList.addList(taskRepeat1);
        TaskList.addList(taskRepeat2);
        TaskList.addList(taskRepeat3);
        System.out.println(taskRepeat3);
        TaskList.printList();
        TaskList.sortByTaskNameAndCategory();
        TaskList.printList();
        TaskList.filterByListLengthTaskName();
        TaskList.printList();

    }
}
