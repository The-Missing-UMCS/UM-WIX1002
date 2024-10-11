package com.umwix1002.solution.lab.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

/**
 * @author Ng Zhi Yang
 */
public class PropertiesUtil {
    public static final Properties PROPERTIES = new Properties();
    private static boolean isLoaded = false;

    public static Optional<String> read(String file, String key)  {
        try {
            if (!isLoaded) {
                load(file);
            }
            return Optional.ofNullable(PROPERTIES.getProperty(key));
        } catch (IOException e) {
            return Optional.empty();
        }
    }

    private static void load(String file) throws IOException {
        try (FileInputStream input = new FileInputStream(file)) {
            PROPERTIES.load(input);
            isLoaded = true;
        }
    }
}
