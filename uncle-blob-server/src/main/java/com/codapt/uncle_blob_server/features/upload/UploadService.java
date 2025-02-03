package com.codapt.uncle_blob_server.features.upload;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.codapt.uncle_blob_server.features.file.FileUpload;
import com.codapt.uncle_blob_server.features.upload.dto.UploadFileReq;

@Service
public interface UploadService {
    
    public FileUpload upload(UploadFileReq dto) throws IOException;

}
