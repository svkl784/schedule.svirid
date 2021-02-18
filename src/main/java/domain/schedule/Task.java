package domain.schedule;
import domain.enums.Category;
import domain.enums.Priority;

import java.util.Objects;
import java.util.stream.DoubleStream;


public abstract class Task implements TaskService, Comparable<Task> {
    private String taskDescription;
    private Priority priority;
    private Category category;
    private String dateLine;
//    private boolean taskCompleted;



    public Task(String task, Priority priority, Category category, String dateLine) {
        this.taskDescription = task;
        this.priority = priority;
        this.category = category;
        this.dateLine = dateLine;
    }


    @Override
    public int compareTo(Task task) {
        int result = this.taskDescription.compareTo(task.getTaskDescription());
        result = result == 0 ? this.dateLine.compareTo(task.getDateLine()) : result;
        result = result == 0 ? this.category.compareTo(task.getCategory()) : result;
        result = result == 0 ? this.priority.compareTo(task.getPriority()) : result;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task otherTask = (Task) o;
        return  taskDescription != null && taskDescription.equals(otherTask.taskDescription)
                && priority == otherTask.priority
                && category == otherTask.category
                && dateLine != null && dateLine.equals(otherTask.dateLine);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((taskDescription == null) ? 0 : taskDescription.hashCode());
        result = prime * result + ((category == null) ? 0 : category.hashCode());
        result = prime * result + ((priority == null) ? 0 : priority.hashCode());
        result = prime * result + ((dateLine == null) ? 0 : dateLine.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "Task description='" + taskDescription + '\'' +
                ", priority=" + priority +
                ", category=" + category +
                ", dateLine='" + dateLine + '\'' +
                '}';
    }


    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String task) {
        this.taskDescription = task;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDateLine() {
        return dateLine;
    }

    public void setDateLine(String dateLine) {
        this.dateLine = dateLine;
    }

}



