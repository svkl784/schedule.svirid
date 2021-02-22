package domain.schedule;

import domain.exception.DatelineException;

import java.text.ParseException;

public interface TaskService {
        void showInfo();
        void dateLineNow() throws ParseException;
        boolean performed();

}
