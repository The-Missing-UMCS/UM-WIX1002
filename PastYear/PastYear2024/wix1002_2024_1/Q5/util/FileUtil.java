package wix1002_2024_1.Q5.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileUtil {
    public static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (Scanner scanner = new Scanner(new FileInputStream(filePath))) {
            while (scanner.hasNextLine())
                content.append(scanner.nextLine()).append(System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return content.toString();
    }
}
