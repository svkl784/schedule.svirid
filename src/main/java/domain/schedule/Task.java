package domain.schedule;
import domain.enums.Category;
import domain.enums.Priority;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;


public abstract class Task implements TaskService, Comparable<Task> {
    private String taskName;
    private Priority priority;
    private Category category;
    private String dateLine;
    private boolean taskPerformed;

    public Task() {
    }

    public Task(String taskName, Priority priority, Category category, String dateLine) {

            this.taskName = taskName;
            this.priority = priority;
            this.category = category;
            this.dateLine = dateLine;
    }


    @Override
    public boolean performed() {
        if (!taskPerformed) {
            taskPerformed = true;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void dateLineNow() {
        try {
            Timer timer = new Timer();
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("dd/MM/yyyy");
            Date date = format.parse(dateLine);
            if (date.equals(new Date())) {
                System.out.println("Today is day of dateline!");
            }
        }
        catch (ParseException e){
            System.out.println("INCORRECT DATE FORMAT INTRODUCED!!!"+"Task name: "+getTaskName());
            System.exit(1);
        }
    }

    @Override
    public void showInfo() {
        StringBuilder string = new StringBuilder();
        System.out.println("-------------------------Your task-----------------------------");
        string.append("Name: ").append(getTaskName()).append("; Priority:").append(getPriority())
                .append("; Category:").append(getCategory()).append("; Dateline:").append(getDateLine());
        String newString = string.toString();
        System.out.println(newString);
    }

    @Override
    public int compareTo(Task task) {
        int result = this.taskName.compareTo(task.getTaskName());
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
        return  taskName != null && taskName.equals(otherTask.taskName)
                && priority == otherTask.priority
                && category == otherTask.category
                && dateLine != null && dateLine.equals(otherTask.dateLine);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((taskName == null) ? 0 : taskName.hashCode());
        result = prime * result + ((category == null) ? 0 : category.hashCode());
        result = prime * result + ((priority == null) ? 0 : priority.hashCode());
        result = prime * result + ((dateLine == null) ? 0 : dateLine.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "-------------------------Task-----------------------" +
                "Task name: "+taskName+"\n"+
                "Task priority: " + priority +"\n"+
                "Task category: " + category +"\n"+
                "Task dateLine: " + dateLine + "\n";
    }


    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String task) {
        this.taskName = task;
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



