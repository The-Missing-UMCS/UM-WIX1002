package com.umwix1002.solution.lab.util;

import static com.umwix1002.solution.lab.constants.ConsoleConstants.*;

/**
 * @author Ng Zhi Yang
 */
public class LoggerUtil {
    public static void logWithColor(String color, String pattern, Object... args) {
        log(color(pattern, color), args);
    }
    
    public static void log(String pattern, Object... args) {
        System.out.printf(pattern, args);
    }
    
    private static String color(String text, String color) {
        return color + text + RESET;
    }

    
}
