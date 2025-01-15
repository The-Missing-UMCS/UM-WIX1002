package com.umwix1002.solution.lab.Lab9.L9Q3;

import com.umwix1002.solution.lab.Lab9.L9Q2.Profile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Lecturer extends Profile {
    Map<String, Lecture> lectures = new HashMap<>();

    private Lecturer(String name, char gender, String date, Map<String, Lecture> lectures) {
        super(name, gender, date);
        this.lectures = lectures;
    }

    public static Lecturer of(String name, char gender, String date, String file) {
        Map<String, Lecture> lectures = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String code;
            while ((code = reader.readLine()) != null) {
                lectures.put(code, new Lecture(code, reader.readLine(),
                    Integer.parseInt(reader.readLine()),
                    Integer.parseInt(reader.readLine()),
                    Double.parseDouble(reader.readLine()),
                    Integer.parseInt(reader.readLine())));
            }
        } catch (Exception ex) {
            System.out.println("The student cannot be created. Reason: " + ex.getMessage());
        }
        return new Lecturer(name, gender, date, lectures);
    }

    public void showDetails() {
        System.out.println(this);

        final String format = " %-13s | %-35s | %8s | %10s | %15s | %15s | \n";
        final String line = String.format(format, "-".repeat(13), "-".repeat(35), "-".repeat(8), "-".repeat(10), "-".repeat(15), "-".repeat(15));

        System.out.printf(line);
        System.out.printf(format, "Course Code", "Course Name", "Session", "Semester", "Student Count", "Credit Hour");
        System.out.printf(line);

        lectures.keySet().forEach(code -> {
            Lecture lecture = lectures.get(code);
            System.out.printf(format,
                code, lecture.courseName(), lecture.session(),
                lecture.semester(), lecture.studentCount(), lecture.getCreditHour());
        });
    }
}
