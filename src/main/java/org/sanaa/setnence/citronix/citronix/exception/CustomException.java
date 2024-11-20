package org.sanaa.setnence.citronix.citronix.exception;

import jakarta.persistence.EntityNotFoundException;

public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
