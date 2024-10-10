package com.umwix1002.solution.lab.lab9.l9q3;

import com.umwix1002.solution.lab.Properties;
import com.umwix1002.solution.lab.lab7.helper.Gender;
import com.umwix1002.solution.lab.lab9.l9q2.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ng Zhi Yang
 */
public class Main {
    public static void main(String[] args) throws Exception {
        List<Lecture> lectures = new ArrayList<>();
        String file = Properties.PROJECT_ROUTE + "/lab9/io_files/lecture.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String code = "";
            while((code = reader.readLine()) != null) {
                lectures.add(new Lecture(code, reader.readLine(),
                    Integer.parseInt(reader.readLine()),
                    Integer.parseInt(reader.readLine()),
                    Double.parseDouble(reader.readLine()),
                    Integer.parseInt(reader.readLine())));
            }
        }
        Lecturer lecturer = new Lecturer("Jane", Gender.FEMALE, "2024-08-12", lectures);
        System.out.println(lecturer);
        lecturer.getLectures().forEach(System.out::println);
    }
}
