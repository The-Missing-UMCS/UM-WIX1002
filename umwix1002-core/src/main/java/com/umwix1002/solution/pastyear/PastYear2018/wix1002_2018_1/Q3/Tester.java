package com.umwix1002.solution.pastyear.PastYear2018.wix1002_2018_1.Q3;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        // 计算、算法 -> 画出来 + 找规律 + 建立起算法/ 模型，一步一步写出来
        Scanner scanner = new Scanner(System.in);
        // 1. Mock user input
        System.out.println("Font Size: ");
        int fontSize = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Font Type: ");
        char fontType = scanner.nextLine().charAt(0);
        System.out.println("Format: ");
        int format = scanner.nextInt();

        // 2. Calculation/ Transformation
        if (format == 1) {
            int height = fontSize * 2 + 3;
            int width = fontSize + 2;

            char[][] eight = new char[height][width];

            // Fill all
            for (int col = 0; col < width; col++) {
                // 1st
                eight[0][col] = fontType;
                // 2nd = size + 1
                eight[fontSize + 1][col] = fontType;
                // 3rd = 2 * size + 2
                eight[2 * fontSize + 2][col] = fontType;
            }

            // FIrst and last
            for (int row = 0; row < height; row++) {
                // First
                eight[row][0] = fontType;

                // Last
                eight[row][width - 1] = fontType;
            }

            for (char[] row : eight) {
                for (char val : row) {
                    System.out.print(val == fontType ? val : " ");
                }
                System.out.println();
            }
        } else if (format == 2) {
            // Implement the other one
        }


        // 3. Visualization


    }
}
