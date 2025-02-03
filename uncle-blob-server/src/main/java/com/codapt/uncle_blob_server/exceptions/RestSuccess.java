package com.codapt.uncle_blob_server.exceptions;

import lombok.Getter;

@Getter
public class RestSuccess {
    
    private String message;

    public RestSuccess(String message) {
        this.message = message;
    }
}
