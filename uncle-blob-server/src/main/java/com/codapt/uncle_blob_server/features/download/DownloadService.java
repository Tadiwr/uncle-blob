package com.codapt.uncle_blob_server.features.download;

import org.springframework.stereotype.Service;

import com.codapt.uncle_blob_server.features.download.dto.FileDownloadBytes;

@Service
public interface DownloadService {
    
    public FileDownloadBytes download(String fileName);

}
