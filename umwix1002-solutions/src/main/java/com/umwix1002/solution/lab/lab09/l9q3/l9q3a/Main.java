package com.umwix1002.solution.lab.lab09.l9q3.l9q3a;


import static com.umwix1002.solution.Properties.*;

public class Main {

    public static void main(String[] args) {
        String file = chainDir(LAB9, IO_FILES, "lecture.txt");
        Lecturer.of("John Doe", 'F', "01-01-2003", file).showDetails();
    }
}
