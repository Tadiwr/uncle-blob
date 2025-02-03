package com.codapt.uncle_blob_server.features.file_upload;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileUploadRepository extends CrudRepository<FileUpload, String> {
    
}
