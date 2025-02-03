package com.codapt.uncle_blob_server.features.overwrite.dto;

import org.springframework.http.MediaType;

import lombok.Data;

@Data
public class OverwriteFileReq {
    
    private String fileName;
    private byte[] bytes;
    private MediaType contentType;

}
