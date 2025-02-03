package com.codapt.uncle_blob_server.features.upload;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codapt.uncle_blob_server.features.file.dto.FileUploadDto;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


@RestController
@RequestMapping("/api/v1/files/upload")
public class UploadController {
    
    @PostMapping("")
    public ResponseEntity<FileUploadDto> uploadFile(
        @RequestParam String fileName,
        @RequestBody byte[] fileBytes,
        @RequestHeader(HttpHeaders.CONTENT_TYPE) String contentType
    ) {
        throw new UnsupportedOperationException();
    }
    

}
