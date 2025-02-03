package com.codapt.uncle_blob_server.providers.utils;

public class FileName {
    
    private String principle;
    private static String delimiter = "\\.";

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

        if (fileName.contains(".")) {

            String[] parts = fileName.split(delimiter);
            String extension = parts[parts.length - 1];
            
            return extension;
        }

        return "";
    }

    public static String getBaseName(String fileName) {

        if (fileName.contains(".")) {   

            String[] parts = fileName.split(delimiter);
            int lastIndex = parts.length - 2;

            StringBuilder stringBuilder = new StringBuilder();

            for (int index = 0; index <= lastIndex; index ++) {
                String curr = parts[index];

                stringBuilder.append(curr + ".");
            }

            String outStr = stringBuilder.toString();
            
            return outStr.substring(0, outStr.length() - 1);
        }

        return fileName;
    }

}
