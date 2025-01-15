package com.umwix1002.solution.problemsolving.Problem_Solving_3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public class PS3Q3 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // 1. Initializing the array
            System.out.print("Enter an integer value: ");
            int n = scanner.nextInt();
            int[] arr = new Random().ints(n, 0, 10001).toArray();
            final String delimiter = ", ";

            // 2. Show Min Value
            System.out.println("Min: " + Arrays.stream(arr).min().orElseThrow());

            // 3. Show Normal Integer
            String normalInteger = Arrays.stream(arr).boxed().map(String::valueOf).collect(joining(delimiter));
            System.out.println("Show Normal Integer: " + normalInteger);

            // 4. Show Rounded Integer
            String roundedInteger = Arrays.stream(arr).mapToObj(val -> String.valueOf(Math.round(val / 100f) * 100)).collect(joining(delimiter));
            System.out.println("Show Rounded Integer: " + roundedInteger);

            // 5. Show Reverse Integer
            String reverseInteger = IntStream.range(0, arr.length)
                .map(i -> arr[arr.length - 1 - i])
                .mapToObj(String::valueOf)
                .collect(joining(delimiter));
            System.out.println("Show Reverse Integer: " + reverseInteger);
        }
    }
}

