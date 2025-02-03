package com.codapt.uncle_blob_server.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class InvalidFileNameError extends RestRuntimeException {
    
    private String error;
    private String message;
    
    private HttpStatus status = HttpStatus.BAD_REQUEST;

    public InvalidFileNameError(String message) {
        this.error = "Invalid File Name";
        this.message = message;
    }
}
