package com.umwix1002.solution.lab.lab10.l10q4.util.converter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class XmlConverter implements Converter {
    private final XmlMapper xmlMapper;

    public XmlConverter() {
        this.xmlMapper = new XmlMapper();
    }

    @Override
    public <T> T convert(String file, Class<T> clazz) throws IOException {
        return xmlMapper.readValue(new File(file), clazz);
    }

    @Override
    public <C extends Collection<T>, T> C convertToCollection(
            String file, Class<T> clazz, TypeReference<C> typeReference) throws IOException {
        return xmlMapper.readValue(new File(file), typeReference);
    }
}
