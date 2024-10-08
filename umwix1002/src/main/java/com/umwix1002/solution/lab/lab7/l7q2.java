package com.umwix1002.solution.lab.lab7;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Ng Zhi Yang
 */
public class l7q2 {
    public static void main(String[] args) throws Exception {
        String urlString = "http://fsktm.um.edu.my";
        Path outputPath = Path.of("src/main/java/com/umwix1002/solution/lab/lab7/output/fkstm.htm");

        URL url = new URI(urlString).toURL();
        URLConnection connection = url.openConnection();

        try (InputStream inputStream = connection.getInputStream()) {
            Files.copy(inputStream, outputPath);
        }

        System.out.println("File downloaded successfully: " + outputPath.toAbsolutePath());
        
    }
}
