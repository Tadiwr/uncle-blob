package com.codapt.uncle_blob_server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.codapt.uncle_blob_server.providers.storage.StorageProvider;
import com.codapt.uncle_blob_server.providers.storage.StorageProviderImpl;

@Configuration
public class BeansConfig {
    
    @Bean
    public StorageProvider storageProvider() {
        return new StorageProviderImpl();
    }
}
