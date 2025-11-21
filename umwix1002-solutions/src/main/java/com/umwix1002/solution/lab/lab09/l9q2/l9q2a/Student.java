package com.umwix1002.solution.lab.lab09.l9q2.l9q2a;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Student extends Profile {

    private final Map<String, Course> courses;

    private Student(String name, char gender, String date, Map<String, Course> courses) {
        super(name, gender, date);
        this.courses = courses;
    }

    public static Student of(String name, char gender, String date, String file) {
        Map<String, Course> courses = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String code;
            while ((code = reader.readLine()) != null) {
                courses.put(code, new Course(code, reader.readLine(),
                    Integer.parseInt(reader.readLine()),
                    Integer.parseInt(reader.readLine()),
                    Integer.parseInt(reader.readLine())));
            }
        } catch (Exception ex) {
            System.out.println("The student cannot be created. Reason: " + ex.getMessage());
        }
        return new Student(name, gender, date, courses);
    }

    @Override
    public void showDetails() {
        System.out.println(this);
        String format = "| %-13s | %-35s | %8s | %10s | %7s | %7s |%n";
        String line = String.format(format,
            "-".repeat(13), "-".repeat(35), "-".repeat(8), "-".repeat(10), "-".repeat(7),
            "-".repeat(7));

        System.out.printf(line);
        System.out.printf(format, "Course Code", "Course Name", "Session", "Semester", "Marks",
            "Grade");
        System.out.printf(line);

        courses.keySet().forEach(
            code -> {
                Course course = this.courses.get(code);
                System.out.printf(format,
                    code, course.courseName(), course.session(),
                    course.semester(), course.marks(), course.getGrade());
            }
        );
        System.out.printf(line);
    }
}
