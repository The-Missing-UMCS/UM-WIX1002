package com.umwix1002.solution.pastyear.PastYear2018.wix1002_2018_2.Q3;

import java.io.FileInputStream;
import java.util.Scanner;

public class Q3Main {
    public static void main(String[] args) {
        final String filePath = "umwix1002-core/src/main/java/com/umwix1002/solution/pastyear/PastYear2018/wix1002_2018_2/Q3/student.txt";

        try (Scanner sc = new Scanner(new FileInputStream(filePath))) {
            String[] info = sc.hasNextLine() ? sc.nextLine().split(",") : null;
            if (info == null)
                return;
            String[] highest = info, lowest = info;
            int absent = 0;
            while (sc.hasNextLine()) {
                info = sc.nextLine().split(",");
                if ("-1".equals(info[1])) {
                    absent++;
                    continue;
                }
                highest = highest[1].compareTo(info[1]) >= 0 ? highest : info;
                lowest = lowest[1].compareTo(info[1]) <= 0 ? lowest : info;
            }
            System.out.printf("The student with the highest mark: %s %s\n", highest[0], highest[1]);
            System.out.printf("The student with the lowest mark: %s %s\n", lowest[0], lowest[1]);
            System.out.println("The number of students who were absent from the exam: " + absent);

        } catch (Exception ex) {
            System.out.println("Error reading file: " + ex.getMessage());
        }
    }
}
