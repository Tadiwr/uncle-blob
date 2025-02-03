package com.codapt.uncle_blob_server.features.upload.dto;

import org.springframework.http.MediaType;

import lombok.Data;

@Data
public class UploadFileReq {
    
    private String fileName;
    private byte[] bytes;
    private MediaType contentType;

}
