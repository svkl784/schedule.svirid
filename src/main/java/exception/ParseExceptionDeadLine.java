package exception;

public class ParseExceptionDeadLine extends Exception {
    String deadline;
    public ParseExceptionDeadLine(String deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "YOU DEADLINE " + deadline + " NOT CORRECT! ";
    }
}
