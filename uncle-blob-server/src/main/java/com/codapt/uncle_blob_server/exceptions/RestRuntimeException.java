package com.codapt.uncle_blob_server.exceptions;

import org.springframework.http.HttpStatus;

public abstract class RestRuntimeException extends RuntimeException {
    
    public abstract String getMessage();
    public abstract String getError();
    public abstract HttpStatus getStatus();

}
