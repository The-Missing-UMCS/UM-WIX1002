package com.umwix1002.solution.lab;

import com.umwix1002.solution.lab.constants.CommonConstant;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Ng Zhi Yang
 */
public class Properties {
    public static final String PROJECT_ROUTE = "umwix1002-advanced/src/main/java/com/umwix1002/solution/lab";

    public static final String LAB7_LABEL = "lab7";
    public static final String LAB9_LABEL = "lab9";
    public static final String LAB10_LABEL = "lab10";

    public static final String LAB7 = chainDir(PROJECT_ROUTE, LAB7_LABEL);
    public static final String LAB9 = chainDir(PROJECT_ROUTE, LAB9_LABEL);
    public static final String LAB10 = chainDir(PROJECT_ROUTE, LAB10_LABEL);

    public static final String IO_FILES = "io_files";
    public static final String OUTPUT = "output";
    public static final String LOG = "log";

    /**
     * Chains the provided directory segments into a single path string.
     * This is used to avoid confusing use fromProperty file separator.
     *
     * @param dirs the directory segments to chain
     * @return the resulting path as a string
     */
    public static String chainDir(String... dirs) {
        Path path = Paths.get(CommonConstant.BLANK, dirs);
        return path.toString();
    }

    public static String txt(String fileName) {
        return fileName + ".txt";
    }
}
