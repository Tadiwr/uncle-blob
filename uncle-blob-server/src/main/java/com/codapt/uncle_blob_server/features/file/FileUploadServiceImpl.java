package com.codapt.uncle_blob_server.features.file;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codapt.uncle_blob_server.exceptions.NotFoundError;
import com.codapt.uncle_blob_server.providers.utils.FileName;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Autowired
    private FileUploadRepository repository;

    @Override
    public FileUpload getByUuid(String uuid) {
        Optional<FileUpload> optional = repository.findById(uuid);

        if (optional.isEmpty()) {
            String message = "File with uuid '" + uuid + "' was not found";
            throw new NotFoundError(message);
        }

        return optional.get();
    }

    @Override
    public FileUpload getByFileName(String fileName) {

        String uuid = FileName.getBaseName(fileName);
        return getByUuid(uuid);
    }

    @Override
    public List<FileUpload> getAll() {
        return (List<FileUpload>) repository.findAll();
    }

    @Override
    public FileUpload saveFileRecord(FileUpload fileUpload) {
        return repository.save(fileUpload);
    }

    @Override
    public void delete(FileUpload fileUpload) {
        repository.delete(fileUpload);
    }
    
}
