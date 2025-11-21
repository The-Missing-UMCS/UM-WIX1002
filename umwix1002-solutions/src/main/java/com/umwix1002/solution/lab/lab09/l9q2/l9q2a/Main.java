package com.umwix1002.solution.lab.lab09.l9q2.l9q2a;

// Reference code: https://github.com/LimJY03/WIX1002_UM/blob/main/Lab%2009/L9Q2_3/Student.java


import static com.umwix1002.solution.Properties.*;

public class Main {

    public static void main(String[] args) {
        String file = chainDir(LAB9, IO_FILES, "course.txt");
        Student.of("John Doe", 'F', "01-01-2003", file).showDetails();
    }
}