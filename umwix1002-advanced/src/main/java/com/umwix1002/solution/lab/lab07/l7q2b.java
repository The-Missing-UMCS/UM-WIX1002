package com.umwix1002.solution.lab.lab07;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.umwix1002.solution.lab.Properties.*;

/**
 * The result `fsktm.htm` will show `301 moved permanently` due to the use of nginx.
 * @author Ng Zhi Yang
 */
public class l7q2b {
    public static void main(String[] args) throws Exception {
        String urlString = "http://fsktm.um.edu.my";
        Path outputPath = Path.of(chainDir(LAB7, OUTPUT, "fkstm.htm"));

        URL url = new URI(urlString).toURL();
        URLConnection connection = url.openConnection();

        try (InputStream inputStream = connection.getInputStream()) {
            Files.copy(inputStream, outputPath);
        }

        System.out.println("File downloaded successfully: " + outputPath.toAbsolutePath());
    }
}
