package com.codapt.uncle_blob_server.features.overwrite;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/v1/files/overwrite")
public class OverwriteController {
    
    @PutMapping("{fileName}")
    public String overwriteFile(
        @PathVariable String fileName,
        @RequestBody byte[] fileBytes[],
        @RequestHeader(HttpHeaders.CONTENT_TYPE) String contentType
    ) {
        throw new UnsupportedOperationException();
    }

}
