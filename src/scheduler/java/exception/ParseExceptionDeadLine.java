package exception;

public class ParseExceptionDeadLine extends Exception {
    String CriticalDeadline;
    public ParseExceptionDeadLine(String CriticalDeadline) {
        this.CriticalDeadline = CriticalDeadline;
    }

    @Override
    public String toString() {
        return "YOU CRITICAL DEADLINE " + CriticalDeadline +" NOT CORRECT! Correct deadline/critical deadline format \"dd\\mm\\yyyy\""+ '\n' +
                "Enter the correct deadline!"+"\n"+
                "-------------------------------------------------------";
    }
}
