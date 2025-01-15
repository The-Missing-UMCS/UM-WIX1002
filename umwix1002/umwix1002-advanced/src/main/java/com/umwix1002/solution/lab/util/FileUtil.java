package com.umwix1002.solution.lab.util;

import java.io.*;

import static com.umwix1002.solution.lab.constants.CommonConstant.LINE_BREAK;

public class FileUtil {
    public static void writeFile(String filePath, String content) throws IOException {
        try(PrintWriter writer = new PrintWriter(filePath)) {
            writer.println(content);
        }
    }
    
    public static String readFile(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while((line = reader.readLine()) != null) {
                sb.append(line).append(LINE_BREAK);
            }
        }
        return sb.toString();
    }
    public static String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
    
    public static String getFileName(String filePath) {
        return filePath.substring(filePath.lastIndexOf("/") + 1);
    }
}
