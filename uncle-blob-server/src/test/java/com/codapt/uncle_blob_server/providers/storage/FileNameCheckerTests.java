package com.codapt.uncle_blob_server.providers.storage;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.codapt.uncle_blob_server.exceptions.InvalidFileNameError;

public class FileNameCheckerTests {

    @Test
    void test_when_file_name_is_valid() {

        String valid1 = "hello_world.java";
        String valid2 = "hie_bro_i_am_goated.java";
        String valid3 = "Dockerfile";

        assertDoesNotThrow(() -> FileNameChecker.check(valid1));
        assertDoesNotThrow(() -> FileNameChecker.check(valid2));
        assertDoesNotThrow(() -> FileNameChecker.check(valid3));

    }

    @Test
    void test_when_file_name_is_invalid() {
        
        String invalid1 = "./hello.txt";
        String invalid2 = "../hello.txt";
        String invalid3 = "hell/o.txt";
        String invalid4 = "/src/Boostrap.java";

        assertThrows(InvalidFileNameError.class, () -> FileNameChecker.check(invalid1));
        assertThrows(InvalidFileNameError.class, () -> FileNameChecker.check(invalid2));
        assertThrows(InvalidFileNameError.class, () -> FileNameChecker.check(invalid3));
        assertThrows(InvalidFileNameError.class, () -> FileNameChecker.check(invalid4));
    }

}
