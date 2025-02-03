package com.codapt.uncle_blob_server.features.overwrite;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codapt.uncle_blob_server.features.file.dto.FileUploadDto;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/v1/files/overwrite")
public class OverwriteController {
    
    @PutMapping("{fileName}")
    public ResponseEntity<FileUploadDto> overwriteFile(
        @PathVariable String fileName,
        @RequestBody byte[] fileBytes,
        @RequestHeader(HttpHeaders.CONTENT_TYPE) String contentType
    ) {
        throw new UnsupportedOperationException();
    }

}
