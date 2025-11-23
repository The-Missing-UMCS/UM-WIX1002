package com.umwix1002.solution.pastyear.PastYear2020.Q1;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Q1 {
    public static void main(String[] args) {
        System.out.println("This program changes all the odd numbers in the array into even numbers.");

        try (Scanner scanner = new Scanner(System.in)) {
            int size = 5;
            int[] numbers = new int[size];

            System.out.print("Enter five integer numbers: ");
            IntStream.range(0, size).forEach(i -> numbers[i] = scanner.nextInt());

            convertToEven(numbers);

            System.out.print("The numbers are: ");
            System.out.println(IntStream.of(numbers)
                .mapToObj(String::valueOf)
                .reduce((a, b) -> a + " " + b)
                .orElse(""));
        }
    }

    public static void convertToEven(int[] array) {
        IntStream.range(0, array.length)
            .filter(i -> array[i] % 2 != 0)
            .forEach(i -> array[i] += 1);
    }
}

