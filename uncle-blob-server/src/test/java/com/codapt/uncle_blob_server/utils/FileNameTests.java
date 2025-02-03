package com.codapt.uncle_blob_server.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.codapt.uncle_blob_server.providers.utils.FileName;

public class FileNameTests {
    
    @Test
    void test_get_file_base_name1() {
        String baseName = "post.action";
        String fileName =  baseName + ".ts";

        assertEquals(baseName, FileName.getBaseName(fileName));
    }

    @Test
    void test_get_file_base_name2() {
        String baseName = "hello";
        String fileName =  baseName + ".txt";

        assertEquals(baseName, FileName.getBaseName(fileName));
    }

    @Test
    void test_get_file_base_name_with_no_extension() {
        String baseName = "Dockerfile";
        String fileName =  baseName;

        assertEquals(baseName, FileName.getBaseName(fileName));
    }

    @Test
    void test_get_extension_1() {

        String extension = "ts";
        String fileName = "app.service." + extension;
        
        assertEquals(extension, FileName.getExtension(fileName));
    }

    @Test
    void test_get_extension_2() {

        String extension = "js";
        String fileName = "app." + extension;
        
        assertEquals(extension, FileName.getExtension(fileName));
    }

    @Test
    void test_get_extension_3() {

        String extension = "";
        String fileName = "Dockerfile" + extension;
        
        assertEquals(extension, FileName.getExtension(fileName));
    }

}
