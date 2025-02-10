package com.codapt.uncle_blob_server.providers.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.io.TempDir;

import com.codapt.uncle_blob_server.providers.storage.entities.StorageFile;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StorageProvderImplTest {

    @TempDir
    private Path storagePath;

    private StorageProviderImpl storage;

    @BeforeEach
    void setUp() throws IOException {
        Files.deleteIfExists(storagePath);
        storage = new StorageProviderImpl(storagePath);
    }

    @Test
    void test_if_storage_dir_is_initialised() {
        assertTrue(Files.exists(storagePath));
    }

    @Test
    void test_upload_file() throws IOException {
        // Arrange
        String fileExt = "txt";
        String baseName = "hello";
        String fileName = baseName + "." + fileExt;
        byte[] fileBytes = "Hie bro whats up?".getBytes();

        // Act
        StorageFile file = storage.uploadFile(fileName, fileBytes);

        // Assert
        assertEquals(fileBytes, file.getBytes());
        assertEquals(fileExt, file.getFileExtension());
        assertEquals(baseName, file.getBaseName());
        assertEquals(storagePath.resolve(fileName).toString(), file.getFilePath());

        assertTrue(Files.exists(storagePath.resolve(fileName)));
    }
}
