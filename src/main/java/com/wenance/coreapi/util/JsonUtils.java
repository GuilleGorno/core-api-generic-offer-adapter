package com.wenance.coreapi.util;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

    private static JsonUtils instance = null;

    private final FileUtils fileUtils;
    private final ObjectMapper objectMapper;

    
    private JsonUtils() {
        
    	fileUtils = FileUtils.getInstance();
        objectMapper = new ObjectMapper();
    }

    /**
     * <p>Instanciador del objeto</p>
     * <p>Utiliza el patron singleton</p>
     * @return
     */
    public static JsonUtils getInstance() {
        
    	return instance = Objects.isNull(instance)
                ? new JsonUtils()
                : instance;
    }

    /**
     * <p>Deserializa Objetos simples</p>
     * @param <T>
     * @param fileName
     * @param clazz
     * @return
     */
    public <T> T deserializeJsonFile(String fileName, Class<T> clazz) {
        
    	File myFile = fileUtils.getFile(fileName);
        
        try {
            return objectMapper.readValue(myFile, clazz);
        } catch (IOException e) {
            throw new RuntimeException("Could not deserialize json file: " + fileName + ". Reason: " + e.getMessage());
        }
    }
        
    /**
     * <p>Deserializa listas de objetos.</p>
     * @param <T>
     * @param fileName
     * @param clazz
     * @return
     */
    public <T> List<T> deserializeJsonFile(String fileName, TypeReference<?> clazz) {
        
    	File myFile = fileUtils.getFile(fileName);
        
        try {
            return objectMapper.readValue(myFile, new TypeReference<List<T>>(){});
        } catch (IOException e) {
            throw new RuntimeException("Could not deserialize json file: " + fileName + ". Reason: " + e.getMessage());
        }
    }
    
}
