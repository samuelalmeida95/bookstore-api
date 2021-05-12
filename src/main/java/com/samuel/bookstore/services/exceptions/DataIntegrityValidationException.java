package com.samuel.bookstore.services.exceptions;

public class DataIntegrityValidationException extends RuntimeException {

    public DataIntegrityValidationException(String message) {
        super(message);
    }

    public DataIntegrityValidationException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
}
