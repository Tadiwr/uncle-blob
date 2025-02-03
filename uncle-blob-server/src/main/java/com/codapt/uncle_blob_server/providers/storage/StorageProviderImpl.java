package com.codapt.uncle_blob_server.providers.storage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

import com.codapt.uncle_blob_server.exceptions.BadRequestError;
import com.codapt.uncle_blob_server.exceptions.NotFoundError;
import com.codapt.uncle_blob_server.providers.storage.entities.StorageFile;

public class StorageProviderImpl implements StorageProvider {

    private String storageName = ".storage";

    private Logger logger = Logger.getLogger(StorageProviderImpl.class.getName());

    public StorageProviderImpl() {

        Path storagePath = getStorageDir();
        File file = storagePath.toFile();

        if (!file.exists()) {
            file.mkdir();
            logger.info("Initialised storage dir '.storage' in project root\n");

        } else {
            logger.info("Storage Directory already initialized");
        }
    }

    public Path getFilePath(String filePath) {
        return getStorageDir().resolve(filePath);
    }

    public Path getStorageDir() {
        return Paths.get(System.getProperty("user.dir")).resolve(storageName);
    }

    @Override
    public StorageFile uploadFile(String fileName, byte[] bytes) throws IOException {
        Path filePath = getFilePath(fileName);
        boolean fileExits = Files.exists(filePath);

        if (fileExits) {
            String message = "Can't upload. File with name '" + 
            fileName + "' already exists";

            throw new BadRequestError(message);
        }
        
        Path finalPath = Files.write(filePath, bytes);
        StorageFile storageFile = new StorageFile(finalPath, bytes);

        return storageFile;
    }

    @Override
    public StorageFile getFile(String fileName) throws IOException {

        Path filePath = getFilePath(fileName);
        boolean fileExits = Files.exists(filePath);

        if (!fileExits) {

            String message = "File with name'" + fileName +"' was not found";
            throw new NotFoundError(message);

        }

        byte[] bytes = Files.readAllBytes(filePath);

        return new StorageFile(filePath, bytes);

    }

    @Override
    public StorageFile overwrite(String fileName, byte[] bytes) throws IOException {
        return uploadFile(fileName, bytes);
    }

    @Override
    public void deleteFile(String fileName) {
        try {
            
            Path filePath = getFilePath(fileName);
            Files.delete(filePath);

        } catch (Exception e) {
            logger.warning(fileName);
        }
    }
    
}
