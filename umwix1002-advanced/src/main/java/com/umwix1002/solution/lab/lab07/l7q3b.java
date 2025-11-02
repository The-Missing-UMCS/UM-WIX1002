package com.umwix1002.solution.lab.lab07;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

import static com.umwix1002.solution.lab.Properties.*;

/**
 * @author Ng Zhi Yang
 */
public class l7q3b {
    public static void main(String[] args) throws IOException {
        String fromFile = chainDir(LAB7, IO_FILES, "text.txt");
        String toFile = chainDir(LAB7, IO_FILES, "reverse.txt");
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
