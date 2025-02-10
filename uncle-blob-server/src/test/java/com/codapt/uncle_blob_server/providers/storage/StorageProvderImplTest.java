package com.codapt.uncle_blob_server.providers.storage;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.io.TempDir;

import com.codapt.uncle_blob_server.exceptions.BadRequestError;
import com.codapt.uncle_blob_server.exceptions.NotFoundError;
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
        storage.deleteAllFiles();
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

    @Test
    void test_upload_file_when_file_already_exists() throws IOException {
        // assert
        
        // arrange
        String fileName = "hello_word.py";
        byte[] bytes = "print('Hello World')".getBytes();
        
        assertDoesNotThrow(() -> storage.uploadFile(fileName, bytes));

        // act
        byte[] bytes2 = "print('This should throw exception')".getBytes();

        assertThrows(BadRequestError.class, () -> storage.uploadFile(fileName, bytes2));
    }

    @Test
    void test_delete_all_files() throws IOException {
        // Arrange

        String fileName1 = "hello.txt";
        String fileName2 = "whatsapp.txt";

        storage.uploadFile(fileName1, UUID.randomUUID().toString().getBytes());
        storage.uploadFile(fileName2, UUID.randomUUID().toString().getBytes());

        assertTrue(Files.exists(storagePath.resolve(fileName1)));
        assertTrue(Files.exists(storagePath.resolve(fileName2)));

        // Act
        storage.deleteAllFiles();

        // Assert
        assertFalse(Files.exists(storagePath.resolve(fileName1)));
        assertFalse(Files.exists(storagePath.resolve(fileName2)));
        assertTrue(Files.exists(storagePath));
        

    }

    @Test
    void test_get_file_when_exists() throws IOException {
        // Arrange
        String fileName = "hello.js";
        byte[] bytes = "console.log('Yeah its cray cray, crazy')".getBytes();
        
        StorageFile savedFile = storage.uploadFile(fileName, bytes);

        // Act
        StorageFile file = storage.getFile(fileName);

        // Assert
        assertArrayEquals(bytes, file.getBytes());
        assertEquals(fileName, file.getFileName());
        assertEquals(savedFile.getFilePath(), file.getFilePath());

    }

    @Test
    void test_get_file_when_does_not_exists() {
        String fileName = "hie.txt";
        storage.deleteAllFiles();

        assertThrows(NotFoundError.class, () -> storage.getFile(fileName));
    }

    @Test
    void test_overwrite_when_file_exists() throws IOException {

        // Arranging
        String fileName = "hello.txt";
        byte[] oldBytes = "This is the old string".getBytes();

        StorageFile oldFile = storage.uploadFile(fileName, oldBytes);

        assertEquals(fileName, oldFile.getFileName());
        assertEquals(oldBytes, oldFile.getBytes());

        // Act
        byte[] newBytes = "This is the new string".getBytes();
        StorageFile newFile = storage.overwrite(fileName, newBytes);
        
        assertArrayEquals(newBytes, newFile.getBytes());
        assertEquals(fileName, newFile.getFileName());
        
    }

    @Test
    void test_overwrite_when_file_does_not_exist() {
        // Arrange
        String fileName = "hello.txt";
        byte[] bytes = "THE BYTES DON'T MATTTER".getBytes();
        storage.deleteAllFiles();

        // Act
        assertThrows(NotFoundError.class, () -> storage.overwrite(fileName, bytes));
    }

    @Test
    void test_delete_file_when_exists() throws IOException {
        // Arrange
        String fileName = "hello.txt";
        byte[] bytes = "Hie there".getBytes();

        storage.uploadFile(fileName, bytes);
        assertTrue(Files.exists(storagePath.resolve(fileName)));

        // Act
        storage.deleteFile(fileName);

        // assert
        assertFalse(Files.exists(storagePath.resolve(fileName)));
        
    }

    @Test
    void text_delete_file_when_does_not_exist() {
        storage.deleteAllFiles();

        assertDoesNotThrow(() -> storage.deleteFile("Hello.txt"));
    }

    @Test
    void test_file_exists_when_file_exits() throws IOException {

        // Arrange
        String fileName = "hello.txt";
        byte[] bytes = UUID.randomUUID().toString().getBytes();

        storage.uploadFile(fileName, bytes);

        // Act
        boolean fileExists = storage.exists(fileName);

        // Assert
        assertTrue(fileExists);

    }

    @Test
    void test_file_exists_when_file_does_not_exist() {
        // Arrange
        storage.deleteAllFiles();
        String fileName = "this_file_does_not_exist.txt";

        // Act & Asset
        assertFalse(storage.exists(fileName));
    }
}

