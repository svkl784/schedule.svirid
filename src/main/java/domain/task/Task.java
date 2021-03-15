package domain.task;
import domain.task.enums.Category;
import domain.task.enums.Priority;
import domain.task.interfaces.TaskService;


import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Objects;


public abstract class Task implements TaskService, Comparable<Task>, Serializable {
    private static final long SERIAL_VERSION_UID = 1L;
    private String taskName;
    private Priority priority;
    private Category category;
    private boolean taskPerformed;
    private LocalDate deadline;
    public LocalDate dateNow = LocalDate.now();


    public Task() {
    }

    public Task(String taskName, Priority priority, Category category, LocalDate deadline)  {
//        try {

            this.taskName = taskName;
            this.priority = priority;
            this.category = category;
            this.deadline = deadline;
    }

//    @Override
//    public void correctDateEntry() {
////              try {
////                  if (!deadlineToString.matches("^(0[1-9]|[12][0-9]|3[01])[/](0[1-9]|1[012])[/](19|20)\\d\\d$")) // сравниниваю верный ли введне формат даты (dd/mm/yyyy)
////            { throw new ParseExceptionDeadLine(deadlineToString);
////            }
////        } catch (ParseExceptionDeadLine e) {
////            System.out.println(e);
////            System.exit(1);
////        }
//    }

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
            System.out.println("--------------------Deadline now----------------------");
            if (deadline.equals(dateNow)) {
                System.out.println("Today is day of deadline: \""+getTaskName()+"\"");
            } else {
                System.out.println("Today there is no deadline!");
                long oneDay  = Duration.between(dateNow.atStartOfDay(), deadline.atStartOfDay()).toDays();
                System.out.println("The rest of the days \""+getTaskName()+ "\" before the deadline: "+oneDay+ " day/s");
            }
        }

    @Override
    public void showTask() {
        StringBuilder string = new StringBuilder();
        System.out.println("-------------------------Your task---------------------------");
        string.append("Name: ").append(getTaskName()).append("; Priority:").append(getPriority())
                .append("; Category:").append(getCategory()).append("; Deadline:");
        String newString = string.toString();
        System.out.println(newString);
    }

    @Override
    public void createTask(String taskName, Priority priority, Category category) {
        setTaskName(taskName);
        setPriority(priority);
        setCategory(category);
    }

    @Override
    public int compareTo(Task task) {
        int result = this.taskName.compareTo(task.getTaskName());
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
      return Objects.hashCode(taskName);
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

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }
}



