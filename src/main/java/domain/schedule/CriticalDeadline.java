package domain.schedule;

import exception.ParseExceptionDeadLine;

public class CriticalDeadline extends Task{
    String criticalDeadline;
    TaskRepeat taskRepeat;

    public CriticalDeadline(TaskRepeat taskRepeat, String criticalDeadline){
        super();
        try {
            this.taskRepeat = taskRepeat;
            this.criticalDeadline = criticalDeadline;
            if (!criticalDeadline.matches("^(0[1-9]|[12][0-9]|3[01])[ /](0[1-9]|1[012])[ /](19|20)\\d\\d$")) // сравниниваю верный ли введне формат даты (dd/mm/yyyy)
            { throw new ParseExceptionDeadLine(criticalDeadline);
            }
        } catch (ParseExceptionDeadLine e) {
            System.out.println(e);
            System.exit(1);
        }
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

