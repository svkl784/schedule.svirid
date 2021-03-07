package domain.interfaces;

import domain.enums.Category;
import domain.enums.Priority;

import java.text.ParseException;

public interface TaskService {
        void showTask();
        void dateLineNow() throws ParseException;
        void createTask(String taskName, Priority priority, Category category, String deadline);
        boolean performed();
}
