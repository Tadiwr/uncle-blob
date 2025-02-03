package com.codapt.uncle_blob_server.features.delete;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/files/delete")
public class DeleteController {
    
    @DeleteMapping("/{fileName}")
    public ResponseEntity<Object> deleteFile(
        @PathVariable String fileName
    ) {
        throw new UnsupportedOperationException();
    }

}
