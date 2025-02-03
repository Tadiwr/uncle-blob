package com.codapt.uncle_blob_server.features.file;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codapt.uncle_blob_server.features.file.dto.FileUploadDto;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/v1/files")
public class FileController {
    
    @GetMapping("")
    public ResponseEntity<List<FileUploadDto>> getAll() {
        throw new UnsupportedOperationException();
    }

    @GetMapping("/{fileName}")
    public String getFileByUUID(@PathVariable String fileName) {
        throw new UnsupportedOperationException();
    }
    
    

}
