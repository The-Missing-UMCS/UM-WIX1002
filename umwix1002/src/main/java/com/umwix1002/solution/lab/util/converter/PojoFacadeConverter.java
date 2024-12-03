package com.umwix1002.solution.lab.lab10.l10q4.util.converter;

import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.Collection;

public class PojoFacadeConverter {
    public <T> T convert(String file, Class<T> clazz) throws IOException {
        Converter converter = ConverterFactory.getConverter(file);
        return converter.convert(file, clazz);
    }

    public <C extends Collection<T>, T> C convertToCollection(String file, Class<T> clazz) throws IOException {
        Converter converter = ConverterFactory.getConverter(file);
        return converter.convertToCollection(file, clazz, new TypeReference<C>() {});
    }
}
