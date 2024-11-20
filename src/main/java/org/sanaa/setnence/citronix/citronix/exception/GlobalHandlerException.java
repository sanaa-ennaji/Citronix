package org.sanaa.setnence.citronix.citronix.exception;

import org.sanaa.setnence.citronix.citronix.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalHandlerException  {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> handleApiException(ApiException ex, WebRequest request) {
        ErrorDTO errorDetails = new ErrorDTO(ex.getMessage(), ex.getDetails());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request) {
        ErrorDTO errorDetails = new ErrorDTO(ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
