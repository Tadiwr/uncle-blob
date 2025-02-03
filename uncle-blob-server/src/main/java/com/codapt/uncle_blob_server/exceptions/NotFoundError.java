package com.codapt.uncle_blob_server.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class NotFoundError extends RestRuntimeException {
    
    private String error = "Resource Not Found";
    private String message;

    private HttpStatus status = HttpStatus.NOT_FOUND;

    public NotFoundError(String message) {
        this.message = message;
    }
}
