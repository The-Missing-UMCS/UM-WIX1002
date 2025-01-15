package com.umwix1002.solution.lab.lab7;

import com.umwix1002.solution.lab.lab7.helper.WordCount;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.umwix1002.solution.lab.Properties.*;
import static com.umwix1002.solution.lab.constants.CommonConstant.SPACE;

/**
 * @author Ng Zhi Yang
 */
public class l7q4 {
    public static void main(String[] args) throws IOException {
        final String file = chainDir(LAB7, IO_FILES, "text.txt");
        WordCount wordCount = wordCount(file);
        System.out.printf("Char: %d, Word: %d, Line: %d%n",
            wordCount.getCharCount(), wordCount.getWordCount(), wordCount.getLineCount());
    }

    public static WordCount wordCount(String file) throws IOException {
        WordCount wordCount = new WordCount();
        String[] lines = Files.readAllLines(Path.of(file)).toArray(String[]::new);
        for (String line : lines) {
            wordCount.incrementLineCount();
            for (String word : line.split(SPACE)) {
                wordCount.incrementWordCount();
                wordCount.incrementCharCount(word.length());
            }
        }
        return wordCount;

    }
}
