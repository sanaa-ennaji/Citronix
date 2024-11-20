package org.sanaa.setnence.citronix.citronix.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ApiException extends RuntimeException {

    private String message;
    private String details;

    public ApiException(String message, String details) {
        super(message);
        this.message = message;
        this.details = details;
    }
}
