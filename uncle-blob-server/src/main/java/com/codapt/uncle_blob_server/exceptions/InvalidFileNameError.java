package com.codapt.uncle_blob_server.exceptions;

public class InvalidFileNameError extends RuntimeException {
    
    private String error;
    private String message;

    public InvalidFileNameError(String message) {
        this.error = "Invalid File Name";
        this.message = message;
    }
}
