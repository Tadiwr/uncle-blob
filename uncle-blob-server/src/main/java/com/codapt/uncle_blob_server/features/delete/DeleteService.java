package com.codapt.uncle_blob_server.features.delete;

import org.springframework.stereotype.Service;

@Service
public interface DeleteService {
    
    public void delete(String fileName);

}
