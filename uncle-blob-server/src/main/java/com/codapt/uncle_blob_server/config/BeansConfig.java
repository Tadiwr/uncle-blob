package com.codapt.uncle_blob_server.config;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.codapt.uncle_blob_server.providers.storage.StorageProvider;
import com.codapt.uncle_blob_server.providers.storage.StorageProviderImpl;

@Configuration
public class BeansConfig {
    
    @Value("${uncle-blob.storage-dir}")
    private String storagePath;

    private Logger logger = Logger.getLogger(BeansConfig.class.getName());

    @Bean
    public StorageProvider storageProvider() throws IOException {

        try {    
            return new StorageProviderImpl(storagePath);
        } catch (Exception e) {

            e.printStackTrace();

            String newPath = System.getProperty("user.dir") + File.separator + ".storage";
            String message = "Could not create a storage directory with uncle-blob.storage-dir=" +
            storagePath + ". Resolving to '" + newPath + " as the new storage directory";

            logger.warning(message);

            return new StorageProviderImpl(newPath);
        }
    }
}
