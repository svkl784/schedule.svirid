package domain.task.interfaces;

import domain.task.enums.Category;
import domain.task.enums.Priority;

import java.text.ParseException;

public interface TaskService {
        void showTask();
//        void correctDateEntry();
        void dateLineNow() throws ParseException;
        void createTask(String taskName, Priority priority, Category category);
        boolean performed();
}
