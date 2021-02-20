package domain.schedule;

import domain.enums.Category;
import domain.enums.Priority;

public class CriticalDateline extends Task{
    String criticalDateline;

    public CriticalDateline(String task, Priority priority, Category category, String dateLine, String criticalDateline) {
        super(task, priority, category, dateLine);
        this.criticalDateline = criticalDateline;
    }


}

