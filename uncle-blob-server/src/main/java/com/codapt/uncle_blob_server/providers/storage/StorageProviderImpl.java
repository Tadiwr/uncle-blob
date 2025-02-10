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

    private Path storagePath;

    private Logger logger = Logger.getLogger(StorageProviderImpl.class.getName());

    public static StorageProviderImpl fromStrPath(String storagePathStr) throws IOException {
        
        Path path = Paths.get(storagePathStr);

        return new StorageProviderImpl(path);
         
    }

    public StorageProviderImpl(Path path) throws IOException {
        
        this.storagePath = path;

        if (!Files.exists(storagePath)) {

            Files.createDirectories(storagePath);

            logger.info("Storage Path set to '" + storagePath.toString() + "'");
            logger.info("Storage Path has been intialised");

        } else {

            logger.info("Storage Directory already initialized");
        } 
    }

    public Path getFilePath(String filePath) {
        return getStorageDir().resolve(filePath);
    }

    public Path getStorageDir() {
        return storagePath;
    }

    @Override
    public StorageFile uploadFile(String fileName, byte[] bytes) throws IOException {
        FileNameChecker.check(fileName);

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

        FileNameChecker.check(fileName);

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

        FileNameChecker.check(fileName);

        Path filePath = getFilePath(fileName);

        if (!Files.exists(filePath)) {
            String message = "Can't overwite because file with name " + 
            fileName + " does not exists";
            
            throw new NotFoundError(message);
        }

        Path finalPath = Files.write(filePath, bytes);

        return new StorageFile(finalPath, bytes);
    }

    @Override
    public void deleteFile(String fileName) {

        FileNameChecker.check(fileName);

        try {
            
            Path filePath = getFilePath(fileName);
            Files.delete(filePath);

        } catch (Exception e) {
            logger.warning(fileName);
        }
    }

    @Override
    public void deleteAllFiles() {

        try {
            
            
            File storageRoot = storagePath.toFile();
            
            for (File child: storageRoot.listFiles()) {
                deleteRecursive(child);
            }

        } catch (Exception e) {
            logger.warning("Exception throw when delete all files " + e.getMessage());
        }
    }

    private void deleteRecursive(File file) throws IOException {

        if (file.isDirectory()) {
            for (File child: file.listFiles()) {
                deleteRecursive(child);
            }
        }
        
        Files.deleteIfExists(file.toPath());
    }

    @Override
    public boolean exists(String fileName) {
        return Files.exists(storagePath.resolve(fileName));
    }
    
}
