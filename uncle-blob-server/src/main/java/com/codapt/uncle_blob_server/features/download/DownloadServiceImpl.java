package com.codapt.uncle_blob_server.features.download;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codapt.uncle_blob_server.features.download.dto.FileDownloadBytes;
import com.codapt.uncle_blob_server.features.file.FileUpload;
import com.codapt.uncle_blob_server.features.file.FileUploadService;
import com.codapt.uncle_blob_server.providers.storage.StorageProvider;
import com.codapt.uncle_blob_server.providers.storage.entities.StorageFile;

@Service
public class DownloadServiceImpl implements DownloadService {

    @Autowired
    private FileUploadService service;

    @Autowired
    private StorageProvider storageProvider;

    @Override
    public FileDownloadBytes download(String fileName) throws IOException {

        FileUpload fileUpload = service.getByFileName(fileName);
        StorageFile storageFile = storageProvider.getFile(fileUpload.getFileName());

        FileDownloadBytes downloadBytes = new FileDownloadBytes();

        downloadBytes.setBytes(storageFile.getBytes());
        downloadBytes.setContentType(fileUpload.getContentType());
        downloadBytes.setFileName(storageFile.getFileName());

        return downloadBytes;
    }
    
}
