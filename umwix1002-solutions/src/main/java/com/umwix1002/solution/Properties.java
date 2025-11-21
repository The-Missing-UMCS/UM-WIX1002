package com.umwix1002.solution;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Properties {

    public static final String REPOSITORY_NAME = "umwix1002-solutions";
    public static final String ROOT = chainDir(REPOSITORY_NAME,
        "src/main/java/com/umwix1002/solution");

    // Different Solution Type
    public static final String PAST_YEAR = chainDir(ROOT, "pastyear");
    public static final String LAB = chainDir(ROOT, "lab");
    public static final String PROBLEM_SOLVING = chainDir(ROOT, "problemSolving");
    public static final String TUTORIAL = chainDir(ROOT, "tutorial");
    public static final String VIVA = chainDir(ROOT, "viva");

    // Lab
    public static final String LAB7 = chainDir(LAB, "lab07");
    public static final String LAB8 = chainDir(LAB, "lab08");
    public static final String LAB9 = chainDir(LAB, "lab09");
    public static final String LAB10 = chainDir(LAB, "lab10");

    // Past Year
    public static final String PY2025 = chainDir(PAST_YEAR, "PastYear2025");

    // Common folders
    public static final String IO_FILES = "io_files";

    /**
     * Chains the provided directory segments into a single path string.
     * This is used to avoid confusing use fromProperty file separator.
     *
     * @param dirs the directory segments to chain
     * @return the resulting path as a string
     */
    public static String chainDir(String... dirs) {
        Path path = Paths.get("", dirs);
        return path.toString();
    }

    public static String txt(String fileName) {
        return fileName + ".txt";
    }
}
