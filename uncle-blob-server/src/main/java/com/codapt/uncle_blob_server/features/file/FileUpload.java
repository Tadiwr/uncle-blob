package com.codapt.uncle_blob_server.features.file;

import org.springframework.http.MediaType;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class FileUpload {
    
    @Id
    private String uuid;

    private String fileName;
    private Long fileSize;

    private MediaType contentType;
    private String originalFileName;

    private Long uploadedAt;
    private Long lastUpdatedAt;

}
