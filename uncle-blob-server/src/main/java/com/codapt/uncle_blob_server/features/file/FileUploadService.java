package com.codapt.uncle_blob_server.features.file;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface FileUploadService {
    
    public FileUpload getByUuid(String uuid);
    public FileUpload getByFileName(String fileName);

    public List<FileUpload> getAll();

    public FileUpload saveFileRecord(FileUpload fileUpload);

}
