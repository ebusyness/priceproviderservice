package de.ebusyness.priceproviderservice.commons.converter.exception;

public class DataConversionException extends Exception {
    public DataConversionException(String message, Throwable ex) {
        super(message,ex);
    }

    public DataConversionException(String message) {
        super(message);
    }
}