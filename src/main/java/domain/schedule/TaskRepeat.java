package domain.schedule;

import domain.enums.Category;
import domain.enums.Priority;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TaskRepeat extends Task{
    String taskDescription;
    String repeatDateTask;

    public TaskRepeat(String task, Priority priority, Category category, String dateLine,
                      String taskDescription, String repeatDateTask) throws ParseException {
        super(task, priority, category, dateLine);
        this.taskDescription = taskDescription;
        this.repeatDateTask = repeatDateTask;
        Timer timer = new Timer();
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd.MM.yyyy");
        Date date= format.parse(repeatDateTask);
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("Task repeat! "+ new Date());
            }
        }, date);
    }

    @Override
    public String toString() {
        return "Task description='" + taskDescription + '\'' +
                "RepeatDateTask='" + repeatDateTask + '\'';
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getRepeatDateTask() {
        return repeatDateTask;
    }

    public void setRepeatDateTask(String repeatDateTask) {
        this.repeatDateTask = repeatDateTask;
    }
}