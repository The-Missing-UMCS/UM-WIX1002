package com.umwix1002.solution.lab.lab09.l9q3.l9q3c;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.umwix1002.solution.Properties.*;

public class Main {

    public static void main(String[] args) throws Exception {
        String file = chainDir(LAB9, IO_FILES, txt("lecture"));

        List<Lecture> lectures = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileReader(file))) {
            while (scanner.hasNextLine()) {
                lectures.add(new Lecture(
                    scanner.nextLine(),                    // courseCode
                    scanner.nextLine(),                    // courseName
                    Integer.parseInt(scanner.nextLine()),  // session
                    Integer.parseInt(scanner.nextLine()),  // semester
                    Double.parseDouble(scanner.nextLine()),// creditHour
                    Integer.parseInt(scanner.nextLine())   // studentCount
                ));
            }
        }

        String format = "| %-13s | %-45s | %-13s | %-13s | %-13s | %-13s |%n";
        String line = String.format(format,
            "-".repeat(13),
            "-".repeat(45),
            "-".repeat(13),
            "-".repeat(13),
            "-".repeat(13),
            "-".repeat(13)
        );

        // Headers
        System.out.printf(line);
        System.out.printf(format,
            "Course Code",
            "Course Name",
            "Session",
            "Semester",
            "Credit Hour",
            "Student Count"
        );
        System.out.printf(line);

        // Content
        lectures.forEach(lecture -> System.out.printf(format,
            lecture.courseCode(),
            lecture.courseName(),
            lecture.session(),
            lecture.semester(),
            lecture.getCreditHour(),
            lecture.studentCount()
        ));
        System.out.printf(line);
    }
}
