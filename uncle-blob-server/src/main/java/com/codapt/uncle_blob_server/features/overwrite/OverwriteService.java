package com.codapt.uncle_blob_server.features.overwrite;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.codapt.uncle_blob_server.features.file.FileUpload;
import com.codapt.uncle_blob_server.features.overwrite.dto.OverwriteFileReq;

@Service
public interface OverwriteService {

    public FileUpload overwrite(OverwriteFileReq dto) throws IOException;
    
}