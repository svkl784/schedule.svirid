package domain.schedule;

public class CriticalDeadline extends Task{
    String criticalDeadline;
    TaskRepeat taskRepeat;

    public CriticalDeadline(TaskRepeat taskRepeat, String criticalDeadline){
        super();
        this.taskRepeat = taskRepeat;
        this.criticalDeadline = criticalDeadline;
    }

    @Override
    public String toString() {
        return "-----------------CriticalDeadline----------------------"+'\n'+
                "CriticalDeadline: " + criticalDeadline +'\n' +
                taskRepeat +'\n'+
                "------------------------------------------------------";
    }

    public String getCriticalDeadline() {
        return criticalDeadline;
    }

    public void setCriticalDeadline(String criticalDeadline) {
        this.criticalDeadline = criticalDeadline;
    }

    public TaskRepeat getTaskRepeat() {
        return taskRepeat;
    }

    public void setTaskRepeat(TaskRepeat taskRepeat) {
        this.taskRepeat = taskRepeat;
    }
}

