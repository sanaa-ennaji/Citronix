package org.sanaa.setnence.citronix.citronix.dto;

import lombok.Data;

@Data
public class ErrorDTO {

    private String message;
    private String details;

    public ErrorDTO(String message, String details) {
        this.message = message;
        this.details = details;
    }
}
