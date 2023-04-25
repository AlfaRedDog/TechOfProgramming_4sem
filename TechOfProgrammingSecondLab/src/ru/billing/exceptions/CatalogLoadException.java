package ru.billing.exceptions;

public class CatalogLoadException extends Exception{
    public CatalogLoadException(String message) {
        super(message);
    }

    public CatalogLoadException(String message, Throwable cause) {
        super(message, cause);
    }

    public CatalogLoadException(Throwable cause) {
        super(cause);
    }
}
