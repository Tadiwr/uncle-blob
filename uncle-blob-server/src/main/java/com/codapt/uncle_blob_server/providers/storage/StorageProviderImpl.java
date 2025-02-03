package com.codapt.uncle_blob_server.providers.storage;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths; 

import com.codapt.uncle_blob_server.providers.storage.entities.StorageFile;

public class StorageProviderImpl implements StorageProvider {

    private String storageName = ".storage";

    public StorageProviderImpl() {

        Path storagePath = getStorageDir();
        File file = storagePath.toFile();

        if (!file.exists()) {
            file.mkdir();
            System.out.println("------------ Storage Provider ------------");
            System.out.println("\n--> Initialised storage dir '.storage' in project root\n");
            System.out.println("------------------------------------------");
        } else {
            System.out.println("Storage Directory already initialized");
        }
    }

    public Path getFilePath(String filePath) {
        String storageDir = getStorageDir().toString();
        String absPath = storageDir + File.separator + filePath;

        return Paths.get(absPath);
    }

    public Path getStorageDir() {
        String projectPath = System.getProperty("user.dir");
        String absPath = projectPath + File.separator + storageName;

        return Paths.get(absPath);
    }

    @Override
    public StorageFile uploadFile(String fileName, byte[] bytes) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'uploadFile'");
    }

    @Override
    public StorageFile getFile(String fileName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFile'");
    }

    @Override
    public StorageFile overwrite(String fileName, byte[] bytes) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'overwrite'");
    }

    @Override
    public void deleteFile(String fileName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteFile'");
    }
    
}
