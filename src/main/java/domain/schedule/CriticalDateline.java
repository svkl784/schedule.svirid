package domain.schedule;

import domain.enums.Category;
import domain.enums.Priority;

public class CriticalDateline extends Task{
    String criticalDateline;

    public CriticalDateline(String taskName, Priority priority, Category category,
                            String dateLine, String criticalDateline) {
        super(taskName, priority, category, dateLine);
        this.criticalDateline = criticalDateline;
    }


}

