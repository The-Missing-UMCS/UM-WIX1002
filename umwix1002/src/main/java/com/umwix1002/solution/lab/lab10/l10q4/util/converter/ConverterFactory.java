package com.umwix1002.solution.lab.lab10.l10q4.util.converter;

public class ConverterFactory {
    private static final String XML = ".xml";
    private static final String JSON = ".json";
    private static final String YAML = ".yaml";

    public static Converter getConverter(String file) {
        if(file.endsWith(JSON)) {
            return new JsonConverter();
        } else if(file.endsWith(XML)) {
            return new XmlConverter();
        } else if(file.endsWith(YAML)) {
            return new YamlConverter();
        } else {
            throw new IllegalArgumentException("Unsupported file format. Only JSON, XML and YAML are supported.");
        }
    }
}
