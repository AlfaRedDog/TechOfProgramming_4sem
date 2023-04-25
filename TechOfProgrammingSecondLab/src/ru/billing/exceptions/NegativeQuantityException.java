package ru.billing.exceptions;

public class NegativeQuantityException extends Exception{
    public NegativeQuantityException(Throwable cause) {
        super(cause);
    }

    public NegativeQuantityException(String message, Throwable cause) {
        super(message, cause);
    }

    public NegativeQuantityException(String message) {
        super(message);
    }
}
