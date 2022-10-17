package com.wenance.coreapi.util;

import java.io.File;
import java.util.Objects;
import java.util.Optional;

public class FileUtils {

    private static FileUtils instance = null;
    
    private static final String RESOURCE_PATH = "src/main/resources/";

    private FileUtils() {}

    public static FileUtils getInstance() {
        return instance = Objects.isNull(instance)
                ? new FileUtils()
                : instance;
    }

    public File getFile(String fileName) {
    	StringBuilder path = new StringBuilder();
    	path.append(RESOURCE_PATH);
        return Optional.ofNullable(fileName)
                .map(fn -> path.append(fn).toString())
                .map(File::new)
                .orElseThrow(() -> new RuntimeException("File: " + fileName + " could not be found"));
    }


}
