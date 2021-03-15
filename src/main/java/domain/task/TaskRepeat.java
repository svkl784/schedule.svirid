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


//    @Override
//    public void correctDateEntry() {
//        super.correctDateEntry();
//       try {
//           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
//           String repeatDateTaskToString = repeatDateTask.format(formatter);
//        String notRepeat = "00/00/0000";
//        if (repeatDateTaskToString.equals(notRepeat)) {
//            System.out.println("NOT REPEAT");
//            return;
//        } else {
//            Timer timer = new Timer();
//            SimpleDateFormat format = new SimpleDateFormat();
//            format.applyPattern("dd/MM/yyyy");
//            Date date = format.parse(repeatDateTaskToString);
//            timer.schedule(new TimerTask() {
//                public void run() {
//                    if ((format.format(date)).equals(new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime()))) {
//                        System.out.println("Today task \""+getTaskName() +"\" repeat! " + new Date());
//                    }}
//            }, date);
//        }
//    }
//        catch (ParseException e){
//        System.out.println("INCORRECT TASK_REPEAT_DATE FORMAT INTRODUCED!!!"+"Task name: "+getTaskName());
//        System.exit(1);
//    }
//    }

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
