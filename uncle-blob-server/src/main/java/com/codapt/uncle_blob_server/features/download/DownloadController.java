package com.codapt.uncle_blob_server.features.download;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codapt.uncle_blob_server.features.download.dto.FileDownloadBytes;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/v1/files/download")
public class DownloadController {

    @Autowired
    private DownloadService service;

    private static final String DEFAULT_DISPOSITION = "attachment";
    
    @GetMapping("/{fileName}")
    public ResponseEntity<byte[]> getByFileName(
        @PathVariable String fileName,
        @RequestParam(defaultValue = DEFAULT_DISPOSITION) String disposition
    ) throws IOException {

        FileDownloadBytes file = service.download(fileName);

        ContentDisposition contentDisposition = disposition.equals(DEFAULT_DISPOSITION) ?
            ContentDisposition.attachment()
                .filename(fileName)
                .build()

            : ContentDisposition.inline()
                .filename(fileName)
                .build();
        
        HttpHeaders headers = new HttpHeaders();

        headers.setContentDisposition(contentDisposition);
        headers.setContentType(file.getContentType());

        return ResponseEntity.ok()
            .headers(headers)
            .contentType(file.getContentType())
            .body(file.getBytes());

    }
    
}
