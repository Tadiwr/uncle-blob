package com.codapt.uncle_blob_server.features.overwrite;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codapt.uncle_blob_server.features.file.FileUpload;
import com.codapt.uncle_blob_server.features.file.dto.FileUploadDto;
import com.codapt.uncle_blob_server.features.overwrite.dto.OverwriteFileReq;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/v1/files/overwrite")
public class OverwriteController {
    
    @Autowired
    private OverwriteService service;

    @PutMapping("{fileName}")
    public ResponseEntity<FileUploadDto> overwriteFile(
        
        @PathVariable String fileName,
        @RequestBody byte[] fileBytes,
        @RequestHeader(HttpHeaders.CONTENT_TYPE) String contentType

    ) throws IOException {
        OverwriteFileReq dto = new OverwriteFileReq();

        dto.setBytes(fileBytes);
        dto.setContentType(MediaType.parseMediaType(contentType));
        dto.setFileName(fileName);

        FileUpload upload = service.overwrite(dto);

        return ResponseEntity.ok(new FileUploadDto(upload));
    }

}
