package com.umwix1002.solution.lab.util.converter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class JsonConverter implements Converter {
    private final ObjectMapper objectMapper;

    public JsonConverter() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public <T> T convert(String file, Class<T> clazz) throws IOException {
        return objectMapper.readValue(new File(file), clazz);
    }

    @Override
    public <C extends Collection<T>, T> C convertToCollection(
            String file, Class<T> clazz, TypeReference<C> typeReference) throws IOException {
        return objectMapper.readValue(new File(file), typeReference);
    }
}
