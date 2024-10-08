package com.umwix1002.solution.lab.lab7;

import com.umwix1002.solution.lab.Properties;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

/**
 * @author Ng Zhi Yang
 */
public class l7q3 {
    public static void main(String[] args) throws IOException {
        String fromFile = Properties.PROJECT_ROUTE + "/lab7/io_files/text.txt";
        String toFile = Properties.PROJECT_ROUTE + "/lab7/output/reverse.txt";
        generateReverseTextFile(fromFile, toFile);
    }

    public static void generateReverseTextFile(String fromFile, String toFile) throws IOException {
        Path inputPath = Path.of(fromFile);
        Path outputPath = Path.of(toFile);
        
        try (var linesStream = Files.lines(inputPath)) {
            Files.write(outputPath,
                linesStream
                    .map(StringUtils::reverse)
                    .collect(Collectors.toList())
            );
        }
    }
}
