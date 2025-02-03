package com.codapt.uncle_blob_server.providers.storage.entities;

import lombok.Data;

@Data
public class StorageFile {
    
    private String fileName;
    private String baseName;
    private String fileExtension;
    private String filePath;
    private byte[] bytes;

    public Long getBytesLength() {
        return bytes.length + 0L;
    }


}
