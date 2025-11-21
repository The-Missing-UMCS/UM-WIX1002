package com.umwix1002.solution.pastyear.PastYear2025.py25q4;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.umwix1002.solution.Properties.*;

public class Main {

    public static void main(String[] args) throws Exception {
        String inputFile = chainDir(PY2025, IO_FILES, "Q4_input.txt");
        String outputFile = chainDir(PY2025, IO_FILES, "Q4_output.txt");

        List<String> originalTexts = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream(inputFile))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
                originalTexts.add(line);
            }
            System.out.println();
        }

        // Create the manipulator and perform all preprocessing operations.
        StringManipulator manipulator = new StringManipulator(originalTexts.toArray(String[]::new));

        manipulator.clean();
        manipulator.display("Cleaned text:");

        manipulator.reverseTexts();
        manipulator.display("Reversed text:");

        manipulator.rearrange();
        manipulator.display("Arranged text:");

        // Save final outcome to output.txt
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
            for (String text : manipulator.get()) {
                writer.println(text);
            }
        } catch (IOException exception) {
            System.out.println("Error writing output file: " + exception.getMessage());
        }
    }
}
