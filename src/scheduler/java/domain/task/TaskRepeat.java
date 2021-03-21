package domain.task;

import domain.task.Task;
import domain.task.enums.Category;
import domain.task.enums.Priority;

import java.time.LocalDate;

public class TaskRepeat extends Task {
    private String taskDescription;
    private LocalDate repeatDateTask;

    public TaskRepeat() {
    }

    public TaskRepeat(String task, Priority priority, Category category, LocalDate dateLine,
                      String taskDescription, LocalDate repeatDateTask)  {
        super(task, priority, category, dateLine);
            this.taskDescription = taskDescription;
            this.repeatDateTask = repeatDateTask;
    }


    @Override
    public String toString() {
        return "Task name: " + getTaskName() + '\n' +
                "Task priority: " + getPriority() + '\n' +
                "Task category: " + getCategory() + '\n' +
                "Task deadline: " +getDeadline() + '\n' +
                "Task description: " + taskDescription + '\n' +
                "RepeatDateTask: " + repeatDateTask + '\n';
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }


}
