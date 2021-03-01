package domain.schedule;

import domain.enums.Category;
import domain.enums.Priority;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TaskRepeat extends Task {
    String taskDescription;
    String repeatDateTask;

    public TaskRepeat(String task, Priority priority, Category category, String dateLine,
                      String taskDescription, String repeatDateTask)  {
        super(task, priority, category, dateLine);
        try {
            this.taskDescription = taskDescription;
            this.repeatDateTask = repeatDateTask;
            String notRepeat = "NOT REPEAT";
            if (repeatDateTask.equals(notRepeat)) {
                return;
            } else {
                Timer timer = new Timer();
                SimpleDateFormat format = new SimpleDateFormat();
                format.applyPattern("dd/MM/yyyy");
                Date date = format.parse(repeatDateTask);
                timer.schedule(new TimerTask() {
                    public void run() {
                        System.out.println("Today task \""+getTaskName() +"\" repeat! " + new Date());
                    }
                }, date);
            }
        }
        catch (ParseException e){
            System.out.println("INCORRECT DATE FORMAT INTRODUCED!!!"+"Task name: "+getTaskName());
            System.exit(1);
        }
    }

    @Override
    public String toString() {
        return "Task name: " + getTaskName() + '\n' +
                "Task priority: " + getPriority() + '\n' +
                "Task category: " + getCategory() + '\n' +
                "Task dateline: " + getDeadline() + '\n' +
                "Task description: " + taskDescription + '\n' +
                "RepeatDateTask: " + repeatDateTask + '\n';
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
