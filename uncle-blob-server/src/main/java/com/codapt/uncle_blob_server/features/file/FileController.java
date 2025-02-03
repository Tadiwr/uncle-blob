package com.codapt.uncle_blob_server.features.file;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codapt.uncle_blob_server.features.file.dto.FileUploadDto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/v1/files")
public class FileController {
    
    @Autowired
    private FileUploadService service;

    @GetMapping("")
    public ResponseEntity<List<FileUploadDto>> getAll() {
        List<FileUploadDto> uploads = service.getAll()
            .stream()
            .map(file -> new FileUploadDto(file))
            .toList();
        
        return ResponseEntity.ok(uploads);
    }

    @GetMapping("/{fileName}")
    public ResponseEntity<FileUploadDto> getFileByName(@PathVariable String fileName) {

        FileUpload file = service.getByFileName(fileName);
        return ResponseEntity.ok(new FileUploadDto(file));
        
    }
    
    

}
