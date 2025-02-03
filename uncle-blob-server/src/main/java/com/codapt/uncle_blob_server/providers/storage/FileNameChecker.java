package com.codapt.uncle_blob_server.providers.storage;

import com.codapt.uncle_blob_server.exceptions.InvalidFileNameError;

public class FileNameChecker {
    
    /** Checks against file names that could be used to perform recursive attacks on the
     * file system
     */
    public static void check(String fileName) {
        if (fileName.startsWith("./")) {
            throw new InvalidFileNameError("Invalid file name. File name can't start with './'");
        }

        if (fileName.contains("/")) {
            throw new InvalidFileNameError("Invalid File name. File name can't contain a '\\' or /");
        }

        if (fileName.contains("\\")) {
            throw new InvalidFileNameError("Invalid File name. File name can't contain a '\\' or /");
        }
    }

}
