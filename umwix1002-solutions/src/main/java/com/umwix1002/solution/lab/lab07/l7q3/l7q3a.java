package com.umwix1002.solution.lab.lab07.l7q3;

import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import static com.umwix1002.solution.Properties.*;

public class l7q3a {

    public static void main(String[] args) throws Exception {
        String fromFile = chainDir(LAB7, IO_FILES, "text.txt");
        String toFile = chainDir(LAB7, IO_FILES, "Q3.txt");

        try (
            Scanner scanner = new Scanner(new FileInputStream(fromFile));
            PrintWriter writer = new PrintWriter(toFile)
        ) {
            while (scanner.hasNextLine()) {
                writer.println(new StringBuilder(scanner.nextLine()).reverse());
            }
        }
    }
}
