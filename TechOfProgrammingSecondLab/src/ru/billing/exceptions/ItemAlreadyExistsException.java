package ru.billing.exceptions;

public class ItemAlreadyExistsException extends Exception{
    public ItemAlreadyExistsException(String message) {
        super(message);
    }

    public ItemAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public ItemAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
