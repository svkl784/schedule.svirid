package domain.schedule;

import domain.enums.Category;
import domain.enums.Priority;

import java.text.ParseException;

public class CriticalDateline extends Task{
    String criticalDateline;
    TaskRepeat taskRepeat;

    public CriticalDateline(TaskRepeat taskRepeat, String criticalDateline){
        super();
        this.taskRepeat = taskRepeat;
        this.criticalDateline = criticalDateline;
    }

    @Override
    public String toString() {
        return "-----------------CriticalDateline----------------------"+'\n'+
                "CriticalDateline: " + criticalDateline +'\n' +
                taskRepeat +'\n'+
                "------------------------------------------------------";
    }

    public String getCriticalDateline() {
        return criticalDateline;
    }

    public void setCriticalDateline(String criticalDateline) {
        this.criticalDateline = criticalDateline;
    }

    public TaskRepeat getTaskRepeat() {
        return taskRepeat;
    }

    public void setTaskRepeat(TaskRepeat taskRepeat) {
        this.taskRepeat = taskRepeat;
    }
}

