package com.umwix1002.solution.lab.lab10.config;


import static com.umwix1002.solution.Properties.*;

/**
 * @author Ng Zhi Yang
 */
public class Constants {

    public static final String PROPERTY_FILE_PATH = chainDir(LAB10, "config", "config.properties");

    public static final Integer NUM_OF_ALPHABET = 26;
    public static final Integer LOWER_A_ASCII = 97;
    public static final Integer UPPER_A_ASCII = 65;
    public static final Integer LOWER_Z_ASCII = 122;
    public static final Integer UPPER_Z_ASCII = 90;

    public static final String APPOINTMENT_FILE_PATH = chainDir(LAB10, IO_FILES, "l10q4",
        "appointments.txt");
}
