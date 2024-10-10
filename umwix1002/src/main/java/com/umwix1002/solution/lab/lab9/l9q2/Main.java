package com.umwix1002.solution.lab.lab9.l9q2;

import com.umwix1002.solution.lab.Properties;
import com.umwix1002.solution.lab.lab7.helper.Gender;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ng Zhi Yang
 */
public class Main {
    public static void main(String[] args) throws Exception{
        List<Course> courses = new ArrayList<>();
        String file = Properties.PROJECT_ROUTE + "/lab9/io_files/course.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String code = "";
            while((code = reader.readLine()) != null) {
                courses.add(new Course(code, reader.readLine(),
                    Integer.parseInt(reader.readLine()),
                    Integer.parseInt(reader.readLine()),
                    Integer.parseInt(reader.readLine())));
            }
        }
        Student student = new Student("Jane", Gender.FEMALE, "2024-08-12", courses);
        System.out.println(student);
        student.getCourses().forEach(System.out::println);
    }
}
