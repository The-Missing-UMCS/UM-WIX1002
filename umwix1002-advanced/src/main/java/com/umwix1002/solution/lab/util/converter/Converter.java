package com.umwix1002.solution.lab.util.converter;

import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.Collection;

public interface Converter {
    public <T> T convert(String file, Class<T> clazz) throws IOException;
    public <C extends Collection<T>, T> C convertToCollection(
            String file, Class<T> clazz, TypeReference<C> typeReference) throws IOException;
}
