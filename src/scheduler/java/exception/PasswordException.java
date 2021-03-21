package exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordException extends Exception{
    public PasswordException() {

    }

    @Override
    public String toString() {
        return "--------------------Attention!!!----------------------"+"\n"+
                "You password unsafe! \n" +
                "\n" +
                "For security purposes, change your password to a longer one!";
    }
}

