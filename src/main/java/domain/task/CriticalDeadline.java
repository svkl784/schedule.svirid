package domain.task;

import exception.ParseExceptionDeadLine;

public class CriticalDeadline extends Task {
    String criticalDeadline;
    TaskRepeat taskRepeat;

    public CriticalDeadline(TaskRepeat taskRepeat, String criticalDeadline){
        super();
            this.taskRepeat = taskRepeat;
            this.criticalDeadline = criticalDeadline;
        }

    public void correctDateEntry() {
        System.out.println("-----------Correct criticalDeadline entry-------------");
        try {
        if (!criticalDeadline.matches("^(19|20)\\d\\d[ -](0[1-9]|1[012])[ -](0[1-9]|[12][0-9]|3[01])$")) // сравниниваю верный ли введне формат даты (dd/mm/yyyy)
        { throw new ParseExceptionDeadLine(criticalDeadline);
        }
        else {
            System.out.println("Correct criticalDeadline: "+getCriticalDeadline());
        }
    } catch (ParseExceptionDeadLine e) {
        System.out.println(e);
        System.exit(1);
    }
        finally {
            System.out.println("------------------------------------------------------");
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

