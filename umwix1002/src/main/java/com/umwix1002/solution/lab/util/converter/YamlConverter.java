package com.umwix1002.solution.lab.lab10.l10q4.util.converter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class YamlConverter implements Converter {
    private final ObjectMapper yamlMapper;

    public YamlConverter() {
        this.yamlMapper = new ObjectMapper(new YAMLFactory());
    }

    @Override
    public <T> T convert(String file, Class<T> clazz) throws IOException {
        return yamlMapper.readValue(new File(file), clazz);
    }

    @Override
    public <C extends Collection<T>, T> C convertToCollection(
            String file, Class<T> clazz, TypeReference<C> typeReference) throws IOException {
        return yamlMapper.readValue(new File(file), typeReference);
    }
}
