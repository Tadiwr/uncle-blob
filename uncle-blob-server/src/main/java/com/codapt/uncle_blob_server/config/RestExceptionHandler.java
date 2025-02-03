package com.codapt.uncle_blob_server.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.codapt.uncle_blob_server.exceptions.RestError;
import com.codapt.uncle_blob_server.exceptions.RestRuntimeException;

@ControllerAdvice
public class RestExceptionHandler {
    
    @ExceptionHandler(RestRuntimeException.class)
    public ResponseEntity<RestError> handleError(RestRuntimeException error) {
        RestError restError = new RestError();

        restError.setError(error.getError());
        restError.setMessage(error.getMessage());

        return ResponseEntity
            .status(error.getStatus())
            .body(restError);
    }

}
