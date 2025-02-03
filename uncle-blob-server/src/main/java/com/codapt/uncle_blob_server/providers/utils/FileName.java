package com.codapt.uncle_blob_server.providers.utils;

public class FileName {
    
    private String principle;

    public FileName(String fileName) {

    }

    public String getFileName() {
        return this.principle;
    }
    
    public String getExtension() {
        return getExtension(this.principle);
    }

    public String getBaseName() {
        return getBaseName(this.principle);
    }

    public static String getExtension(String fileName) {
        return "";
    }

    public static String getBaseName(String fileName) {
        return "";
    }

}
