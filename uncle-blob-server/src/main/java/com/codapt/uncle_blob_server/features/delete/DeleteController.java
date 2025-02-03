package com.codapt.uncle_blob_server.features.delete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codapt.uncle_blob_server.exceptions.RestSuccess;

@RestController
@RequestMapping("/api/v1/files/delete")
public class DeleteController {

    @Autowired
    private DeleteService service;
    
    @DeleteMapping("/{fileName}")
    public ResponseEntity<Object> deleteFile(
        @PathVariable String fileName
    ) {
        service.delete(fileName);

        String message = "File quitely deleted";

        return ResponseEntity.ok(new RestSuccess(message));
    }

}
