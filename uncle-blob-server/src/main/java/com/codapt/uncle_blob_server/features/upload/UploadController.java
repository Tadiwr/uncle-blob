package com.codapt.uncle_blob_server.features.upload;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codapt.uncle_blob_server.features.file.FileUpload;
import com.codapt.uncle_blob_server.features.file.dto.FileUploadDto;
import com.codapt.uncle_blob_server.features.upload.dto.UploadFileReq;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


@RestController
@RequestMapping("/api/v1/files/upload")
public class UploadController {

    @Autowired
    private UploadService service;
    
    @PostMapping("")
    public ResponseEntity<FileUploadDto> uploadFile(

        @RequestParam String fileName,
        @RequestBody byte[] fileBytes,
        @RequestHeader(HttpHeaders.CONTENT_TYPE) String contentType

    ) throws IOException {

        System.out.println(fileName);

        UploadFileReq dto = new UploadFileReq();
        dto.setBytes(fileBytes);
        dto.setContentType(MediaType.parseMediaType(contentType));
        dto.setFileName(fileName);

        FileUpload upload = service.upload(dto);

        return ResponseEntity.ok(new FileUploadDto(upload));
    }
    

}
