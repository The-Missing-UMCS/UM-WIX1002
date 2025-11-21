package com.umwix1002.solution.lab.lab06;

import java.util.Arrays;
import java.util.Scanner;

public class l6q3a {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // 1. Get the user input
            int[] arr = new int[10];
            for (int i = 0; i < 10; i++) {
                System.out.printf("Enter a number (%d): ", i + 1);
                arr[i] = scanner.nextInt();
            }

            // 2. Print the original array
            System.out.println(Arrays.toString(arr));

            // 3. Print the reversed array
            for (int i : arr) {
                System.out.print(reverse(i) + " ");
            }
        }
    }

    public static int reverse(int num) {
        int tmp = 0;
        while (num > 0) {
            tmp = tmp * 10 + (num % 10);
            num /= 10;
        }
        return tmp;
    }
}
