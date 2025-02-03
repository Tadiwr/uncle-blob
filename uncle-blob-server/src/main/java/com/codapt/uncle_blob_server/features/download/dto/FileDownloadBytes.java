package com.codapt.uncle_blob_server.features.download.dto;

import org.springframework.http.MediaType;

import lombok.Data;

@Data
public class FileDownloadBytes {
    
    private byte[] bytes;
    private String fileName;
    private MediaType contentType;

}
