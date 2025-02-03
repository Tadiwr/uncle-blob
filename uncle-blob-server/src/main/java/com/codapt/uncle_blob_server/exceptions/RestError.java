package com.codapt.uncle_blob_server.exceptions;

import lombok.Data;

@Data
public class RestError {
    
    private String error;
    private String message;

}
