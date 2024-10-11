package com.umwix1002.solution.lab;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Properties {
    public static final String PROJECT_ROUTE = "src/main/java/com/umwix1002/solution/lab";
    
    public static final String LAB1 = chainDir(PROJECT_ROUTE, "lab1");;
    public static final String LAB2 = chainDir(PROJECT_ROUTE, "lab2");
    public static final String LAB3 = chainDir(PROJECT_ROUTE, "lab3");
    public static final String LAB4 = chainDir(PROJECT_ROUTE, "lab4");
    public static final String LAB5 = chainDir(PROJECT_ROUTE, "lab5");
    public static final String LAB6 = chainDir(PROJECT_ROUTE, "lab6");
    public static final String LAB7 = chainDir(PROJECT_ROUTE, "lab7");
    public static final String LAB8 = chainDir(PROJECT_ROUTE, "lab8");
    public static final String LAB9 = chainDir(PROJECT_ROUTE, "lab9");
    public static final String LAB10 = chainDir(PROJECT_ROUTE, "lab10");
    
    public static final String IO_FILES = "io_files";
    public static final String OUTPUT = "output";
    public static final String LOG = "log";
    
    public static String chainDir(String... dirs) {
        Path path = Paths.get("", dirs);
        return path.toString();
    }
}
