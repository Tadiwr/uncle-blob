package com.codapt.uncle_blob_server.exceptions;


import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class BadRequestError extends RestRuntimeException {
    
    private String error;
    private String message;

    private HttpStatus status = HttpStatus.BAD_REQUEST;

    public BadRequestError(String message) {
        this.error = "Bad Request";
        this.message = message;
    }

    public BadRequestError(String error, String message) {
        this.error = error;
        this.message = message;
    }

}
