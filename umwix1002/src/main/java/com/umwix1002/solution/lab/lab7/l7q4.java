package com.umwix1002.solution.lab.lab7;

import com.umwix1002.solution.lab.Properties;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * @author Ng Zhi Yang
 */
public class l7q4 {
    public static void main(String[] args) throws IOException {
        int[] counts = wordCount(Properties.PROJECT_ROUTE + "/lab7/io_files/text.txt");
        System.out.printf("Char: %d, Word: %d, Line: %d%n", counts[0], counts[1], counts[2]);
    }
    
    public static int[] wordCount(String file) throws IOException {
        // 0: char count, 1: word count, 2: line count
        int[] counts = new int[3];

        try (Stream<String> lines = Files.lines(Path.of(file))) {
            counts[2] = (int) lines.peek(line -> counts[0] += line.length())
                .map(line -> line.split("\\s+").length)
                .peek(wordCount -> counts[1] += wordCount)
                .count(); // count lines
        }
        return counts;
        
    }
}
