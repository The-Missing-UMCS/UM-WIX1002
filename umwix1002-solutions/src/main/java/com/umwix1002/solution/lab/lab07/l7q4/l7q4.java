package com.umwix1002.solution.lab.lab07.l7q4;

import java.io.FileInputStream;
import java.util.Scanner;

import static com.umwix1002.solution.Properties.*;

public class l7q4 {

    public static void main(String[] args) throws Exception {
        String file = chainDir(LAB7, IO_FILES, "text.txt");

        int lineCount = 0, wordCount = 0, charCount = 0;

        try (Scanner scanner = new Scanner(new FileInputStream(file))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lineCount++;
                wordCount += line.split(" ").length;
                charCount += line.length();
            }
        }

        System.out.printf("Char: %d, Word: %d, Line: %d", lineCount, wordCount, charCount);
    }
}
