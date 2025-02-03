package com.codapt.uncle_blob_server.features.overwrite;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codapt.uncle_blob_server.features.file.FileUpload;
import com.codapt.uncle_blob_server.features.file.FileUploadService;
import com.codapt.uncle_blob_server.features.overwrite.dto.OverwriteFileReq;
import com.codapt.uncle_blob_server.providers.storage.StorageProvider;
import com.codapt.uncle_blob_server.providers.storage.entities.StorageFile;
import com.codapt.uncle_blob_server.providers.utils.FileName;

@Service
public class OverwriteServiceImpl implements OverwriteService {

    @Autowired
    private StorageProvider storageProvider;

    @Autowired
    private FileUploadService fileService;

    @Override
    public FileUpload overwrite(OverwriteFileReq dto) throws IOException {

        String uuid = FileName.getBaseName(dto.getFileName());
        FileUpload fileUpload = fileService.getByUuid(uuid);

        StorageFile storageFile = storageProvider.overwrite(dto.getFileName(), dto.getBytes());

        fileUpload.setContentType(dto.getContentType());
        fileUpload.setFileSize(storageFile.getBytesLength());
        fileUpload.setLastUpdatedAt(System.currentTimeMillis());
        
        return fileService.saveFileRecord(fileUpload);
    }
    
}
