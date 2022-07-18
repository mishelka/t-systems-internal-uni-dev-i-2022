package myPersons.exceptions;

public class MojaPersonDbException extends Exception {

    public MojaPersonDbException(String message) {
        super(message);
    }

    public MojaPersonDbException(String message, Throwable cause) {
        super(message, cause);
    }
}
