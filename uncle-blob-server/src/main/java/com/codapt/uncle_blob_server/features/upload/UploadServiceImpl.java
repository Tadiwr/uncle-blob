package com.codapt.uncle_blob_server.features.upload;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codapt.uncle_blob_server.features.file.FileUpload;
import com.codapt.uncle_blob_server.features.file.FileUploadService;
import com.codapt.uncle_blob_server.features.upload.dto.UploadFileReq;
import com.codapt.uncle_blob_server.providers.storage.StorageProvider;
import com.codapt.uncle_blob_server.providers.storage.entities.StorageFile;
import com.codapt.uncle_blob_server.providers.utils.FileName;

@Service
public class UploadServiceImpl implements UploadService {

    @Autowired
    private FileUploadService fileService;

    @Autowired
    private StorageProvider storageProvider;

    @Override
    public FileUpload upload(UploadFileReq dto) throws IOException {

        String fileExtension = FileName.getExtension(dto.getFileName());

        String uuid = UUID.randomUUID().toString();
        String newFileName = uuid + "." + fileExtension;

        StorageFile storageFile = storageProvider.uploadFile(newFileName, dto.getBytes());

        FileUpload fileUpload = new FileUpload();

        fileUpload.setUuid(uuid);
        fileUpload.setFileName(newFileName);
        fileUpload.setOriginalFileName(dto.getFileName());
        fileUpload.setContentType(dto.getContentType());
        fileUpload.setFileSize(storageFile.getBytesLength());

        fileUpload.setUploadedAt(System.currentTimeMillis());
        fileUpload.setLastUpdatedAt(System.currentTimeMillis());
        
        return fileService.saveFileRecord(fileUpload);
    }
    
}
