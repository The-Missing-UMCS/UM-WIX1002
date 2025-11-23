package com.umwix1002.solution.lab.lab09.l9q2.l9q2b;

import com.umwix1002.solution.lab.util.TableUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static com.umwix1002.solution.Properties.*;

/**
 * @author Ng Zhi Yang
 */
public class Main {

    public static void main(String[] args) throws Exception {
        List<Course> courses = new ArrayList<>();
        String file = chainDir(LAB9, IO_FILES, txt("course"));
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String code;
            while ((code = reader.readLine()) != null) {
                courses.add(new Course(code, reader.readLine(),
                    Integer.parseInt(reader.readLine()),
                    Integer.parseInt(reader.readLine()),
                    Integer.parseInt(reader.readLine())));
            }
        }
        String[] headers = {"Course Code", "Course Name", "Session", "Semester", "Marks", "Grade"};
        TableUtil.printTableWithRawData(headers, courses);
    }
}
