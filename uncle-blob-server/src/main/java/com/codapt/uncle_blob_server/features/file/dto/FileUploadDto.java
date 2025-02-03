package com.codapt.uncle_blob_server.features.file.dto;

import java.util.Date;

import com.codapt.uncle_blob_server.features.file.FileUpload;

import lombok.Data;

@Data
public class FileUploadDto {
    
    private String uuid;

    private String fileName;
    private String originalFileName;
    
    private String fileSize;
    private String contentType;

    private Date uploadedAt;
    private Date lastUpdatedAt;

    public FileUploadDto(FileUpload file) {
        this.uuid = file.getUuid();
        this.fileName = file.getFileName();

        this.contentType = file.getContentType().toString();
        this.fileSize = file.getFileSize().toString() + " bytes";
        this.originalFileName = file.getOriginalFileName();

        this.uploadedAt = new Date(file.getUploadedAt());
        this.lastUpdatedAt =  new Date(file.getLastUpdatedAt());
    }

}
