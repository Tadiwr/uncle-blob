package com.codapt.uncle_blob_server.providers.storage.entities;

import java.nio.file.Path;

import com.codapt.uncle_blob_server.providers.utils.FileName;

import lombok.Data;

@Data
public class StorageFile {
    
    private String fileName;
    private String baseName;
    private String fileExtension;
    private String filePath;
    private byte[] bytes;

    public StorageFile(Path path, byte[] bytes) {
        this.fileName = path.getFileName().toString();

        FileName fileHelper = new FileName(this.fileName);

        this.baseName = fileHelper.getBaseName();
        this.fileExtension = fileHelper.getExtension();
        this.filePath = path.toString();
        this.bytes = bytes;

    }

    public Long getBytesLength() {
        return bytes.length + 0L;
    }


}
