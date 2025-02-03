package com.codapt.uncle_blob_server.features.delete;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codapt.uncle_blob_server.features.file.FileUpload;
import com.codapt.uncle_blob_server.features.file.FileUploadService;
import com.codapt.uncle_blob_server.providers.storage.StorageProvider;

@Service
public class DeleteServiceImpl implements DeleteService {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private FileUploadService fileService;

    @Autowired
    private StorageProvider storageProvider;

    @Override
    public void delete(String fileName) {

        try {

            FileUpload fileUpload = fileService.getByFileName(fileName);
            storageProvider.deleteFile(fileName);
            fileService.delete(fileUpload);

        } catch (Exception err) {
            logger.warning("Exception Throw whiles deleting file with id " + fileName);
            logger.warning(err.getMessage());
        }
        
    }
    
}
