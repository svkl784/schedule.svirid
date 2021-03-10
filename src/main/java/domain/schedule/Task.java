package domain.schedule;
import domain.enums.Category;
import domain.enums.Priority;
import domain.interfaces.TaskService;
import exception.ParseExceptionDeadLine;


import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;


public abstract class Task implements TaskService, Comparable<Task>, Serializable {
    private static final long SERIAL_VERSION_UID = 1L;
    private String taskName;
    private Priority priority;
    private Category category;
    private String deadline;
    private boolean taskPerformed;

    public Task() {
    }

    public Task(String taskName, Priority priority, Category category, String deadline)  {
        try {

            this.taskName = taskName;
            this.priority = priority;
            this.category = category;
            this.deadline = deadline;

         if (!deadline.matches("^(0[1-9]|[12][0-9]|3[01])[/](0[1-9]|1[012])[/](19|20)\\d\\d$")) // сравниниваю верный ли введне формат даты (dd/mm/yyyy)
            { throw new ParseExceptionDeadLine(deadline);
            }
        } catch (ParseExceptionDeadLine e) {
            System.out.println(e);
            System.exit(1);
        }
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
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date date = format.parse(deadline);
            System.out.println("--------------------Deadline now----------------------");
            if ((format.format(date)).equals(new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime()))) {
                System.out.println("Today is day of deadline: \""+getTaskName()+"\"");
            } else {
                System.out.println("Today there is no deadline!");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate today = LocalDate.now();
                LocalDate timeUntilDeadline = LocalDate.parse(deadline,formatter);
                long oneDay  = Duration.between(today.atStartOfDay(), timeUntilDeadline.atStartOfDay()).toDays();
                System.out.println("The rest of the days \""+getTaskName()+ "\" before the deadline: "+oneDay+ " day/s");
//
            }
        }
        catch (ParseException e){
            System.out.println("INCORRECT DATE FORMAT INTRODUCED!!!"+"Task name: "+getTaskName());
            System.exit(1);
        }
        finally {
            System.out.println("------------------------------------------------------");
        }

    }

    @Override
    public void showTask() {
        StringBuilder string = new StringBuilder();
        System.out.println("-------------------------Your task---------------------------");
        string.append("Name: ").append(getTaskName()).append("; Priority:").append(getPriority())
                .append("; Category:").append(getCategory()).append("; Deadline:").append(getDeadline());
        String newString = string.toString();
        System.out.println(newString);
    }

    @Override
    public void createTask(String taskName, Priority priority, Category category, String deadline) {
        setTaskName(taskName);
        setPriority(priority);
        setCategory(category);
        setDeadline(deadline);
    }

    @Override
    public int compareTo(Task task) {
        int result = this.taskName.compareTo(task.getTaskName());
        result = result == 0 ? this.deadline.compareTo(task.getDeadline()) : result;
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
                && deadline != null && deadline.equals(otherTask.deadline);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((taskName == null) ? 0 : taskName.hashCode());
        result = prime * result + ((category == null) ? 0 : category.hashCode());
        result = prime * result + ((priority == null) ? 0 : priority.hashCode());
        result = prime * result + ((deadline == null) ? 0 : deadline.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "-------------------------Task-----------------------" +
                "Task name: "+taskName+"\n"+
                "Task priority: " + priority +"\n"+
                "Task category: " + category +"\n"+
                "Task deadLine: " + deadline + "\n";
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

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

}



