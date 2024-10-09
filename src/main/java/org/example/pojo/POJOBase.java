package org.example.pojo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class POJOBase {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static String PojoToString(POJOBase item) {
        try {
            return mapper.writeValueAsString(item);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <E extends POJOBase> E JsonToPojo(String json, Class<E> trasformClass) {
        try {
            return mapper.readValue(json, trasformClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
