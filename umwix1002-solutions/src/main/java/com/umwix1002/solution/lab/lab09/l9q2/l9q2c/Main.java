package com.umwix1002.solution.lab.lab09.l9q2.l9q2c;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.umwix1002.solution.Properties.*;

public class Main {

    public static void main(String[] args) throws Exception {
        String file = chainDir(LAB9, IO_FILES, txt("course"));

        List<Course> courses = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileReader(file))) {
            while (scanner.hasNextLine()) {
                courses.add(new Course(
                    scanner.nextLine(),
                    scanner.nextLine(),
                    Integer.parseInt(scanner.nextLine()),
                    Integer.parseInt(scanner.nextLine()),
                    Integer.parseInt(scanner.nextLine())));
            }
        }
        String format = "| %-13s | %-45s | %-13s | %-13s | %-13s |%n";
        String line = String.format(format, "-".repeat(13), "-".repeat(45), "-".repeat(13),
            "-".repeat(13), "-".repeat(13));

        // Headers
        System.out.printf(line);
        System.out.printf(format, "Course Code", "Course Name", "Semester", "Marks", "Grade");
        System.out.printf(line);

        // Content
        courses.forEach(
            course -> System.out.printf(format, course.courseCode(), course.courseName(),
                course.semester(), course.marks(), course.getGrade()));
        System.out.printf(line);
    }
}
