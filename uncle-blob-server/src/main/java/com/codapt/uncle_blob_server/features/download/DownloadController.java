package com.codapt.uncle_blob_server.features.download;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/files/download")
public class DownloadController {
    
    @GetMapping("/{fileName}")
    public ResponseEntity<byte[]> getByFileName(@RequestParam String fileName) {
        throw new UnsupportedOperationException();
    }
    

}
