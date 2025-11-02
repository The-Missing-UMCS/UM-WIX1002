package com.umwix1002.solution.lab.lab09.l9q3;

import com.umwix1002.solution.lab.util.TableUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static com.umwix1002.solution.lab.Properties.*;

/**
 * @author Ng Zhi Yang
 */
public class Main {
    public static void main(String[] args) throws Exception {
        List<Lecture> lectures = new ArrayList<>();
        String file = chainDir(LAB9, IO_FILES, txt("lecture"));
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String code;
            while((code = reader.readLine()) != null) {
                lectures.add(new Lecture(code, reader.readLine(),
                    Integer.parseInt(reader.readLine()),
                    Integer.parseInt(reader.readLine()),
                    Double.parseDouble(reader.readLine()),
                    Integer.parseInt(reader.readLine())));
            }
        }
        String[] headers = {"Course Code", "Course Name", "Session", "Semester", "Credit Hour", "Student Count"};
        TableUtil.printTableWithRawData(headers, lectures);
    }
}
