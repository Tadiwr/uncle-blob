package com.codapt.uncle_blob_server.providers.storage;

import org.springframework.stereotype.Service;

import com.codapt.uncle_blob_server.providers.storage.entities.StorageFile;

@Service
public interface StorageProvider {

    public StorageFile uploadFile(String fileName, byte[] bytes);

    public StorageFile getFile(String fileName);

    public StorageFile overwrite(String fileName, byte[] bytes);

    public void deleteFile(String fileName);

}
