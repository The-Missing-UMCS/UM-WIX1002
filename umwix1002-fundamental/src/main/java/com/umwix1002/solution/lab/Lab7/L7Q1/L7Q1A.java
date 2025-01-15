package com.umwix1002.solution.lab.Lab7.L7Q1;

import com.umwix1002.solution.lab.Lab7.Generator;
import lombok.SneakyThrows;

import java.io.*;
import java.util.*;


public class L7Q1A {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            String code;
            while (true) {
                System.out.print("Enter the course code (enter q to quit): ");
                code = scanner.nextLine();

                if (code.charAt(0) == 'q') break;

                checkCode(code, Generator.COURSE_FILE);
            }
        }
    }

    @SneakyThrows
    public static void checkCode(String code, String fromFile) {
        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(fromFile))) {
            String[] info;
            do {
                info = ((String) reader.readObject()).split(",");
            } while (!info[0].equals(code));

            System.out.printf("Course Code: %s\nCourse Name: %s\n\n", info[0], info[1]);
        } catch (EOFException ex) {
            System.out.println("Course not found");
        }
    }
}
