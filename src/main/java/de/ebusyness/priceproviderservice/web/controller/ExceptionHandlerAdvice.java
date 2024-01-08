package de.ebusyness.priceproviderservice.web.controller;

import de.ebusyness.priceproviderservice.commons.converter.exception.DataConversionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

@ControllerAdvice
public class ExceptionHandlerAdvice {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

    @ExceptionHandler(DataConversionException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Void> handleConversionException(DataConversionException ex) {
        logger.error("DataConversionException: {}", ex.getMessage(), ex);
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(IOException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Void> handleIOException(IOException ex) {
        logger.error("IOException: {}", ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Void> handleGenericException(Exception ex) {
        logger.error("Unexpected Exception: {}", ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}