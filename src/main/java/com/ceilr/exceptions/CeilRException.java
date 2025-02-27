package main.java.com.ceilr.exceptions;

public class CeilRException extends Exception {
    public CeilRException(String message) {
        super(message);
    }

    public CeilRException(String message, Throwable cause) {
        super(message, cause);
    }
}
