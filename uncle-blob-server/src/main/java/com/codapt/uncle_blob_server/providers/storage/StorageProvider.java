package com.codapt.uncle_blob_server.providers.storage;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.codapt.uncle_blob_server.providers.storage.entities.StorageFile;

@Service
public interface StorageProvider {

    public StorageFile uploadFile(String fileName, byte[] bytes) throws IOException;

    public StorageFile getFile(String fileName) throws IOException;

    public StorageFile overwrite(String fileName, byte[] bytes) throws IOException;

    public void deleteFile(String fileName);

    public void deleteAllFiles();

    public boolean exists(String fileName);
}
