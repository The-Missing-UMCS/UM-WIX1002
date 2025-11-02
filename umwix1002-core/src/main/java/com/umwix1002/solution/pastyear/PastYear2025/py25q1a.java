package com.umwix1002.solution.pastyear.PastYear2025;

import java.util.Scanner;

public class py25q1a {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the Decimal Number: ");
            int value = scanner.nextInt();
            System.out.println("Binary Number 1: " + toBinaryString1(value));
            System.out.println("Binary Number 2: " + toBinaryString2(value));
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }

    private static String toBinaryString1(int value) {
        return value == 0 ? "" : toBinaryString1(value >> 1) + value % 2;
    }

    private static String toBinaryString2(int value) {
        int[] binary = new int[32];
        int index = 0;
        while (value > 0) {
            binary[index++] = value % 2;
            value /= 2;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = index - 1; i >= 0; i--) {
            sb.append(binary[i]);
        }
        return sb.toString();
    }
}
