package com.umwix1002.solution.lab.lab04;

import java.util.*;
import java.util.stream.IntStream;

public class l4q1 {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a number (integer): ");
            int number = sc.nextInt();

            String format = "[%s]%nThe factors are: ";

            // 1. Using for loop
            System.out.printf(format, "for");
            for (int i = 1; i <= number; i++) {
                boolean isDivisible = number % i == 0;
                if (isDivisible) {
                    System.out.print(i + " ");
                }
            }

            System.out.println(System.lineSeparator());

            // 2. Using while loop
            System.out.printf(format, "while");
            int factor = 1;
            while (factor <= number) {
                boolean isDivisible = number % factor == 0;
                if (isDivisible) {
                    System.out.print(factor + " ");
                }
                factor++;
            }

            System.out.println(System.lineSeparator());

            // 3. Using List
            System.out.printf(format, "for + list");
            List<Integer> factors = new ArrayList<>();
            for (int i = 1; i <= number; i++) {
                boolean isDivisible = number % i == 0;
                if (isDivisible) {
                    factors.add(i);
                }
            }

            for (int f : factors) {
                System.out.print(f + " ");
            }

            System.out.println(System.lineSeparator());

            // 4. Using boolean array
            System.out.printf(format, "for + boolean array");
            boolean[] booleanArray = new boolean[number + 1];
            for (int i = 1; i <= number; i++) {
                boolean isDivisible = number % i == 0;
                booleanArray[i] = isDivisible;
            }

            for (int i = 1; i < booleanArray.length; i++) {
                if (booleanArray[i]) {
                    System.out.print(i + " ");
                }
            }

            System.out.println(System.lineSeparator());

            // 5. Using integer array
            System.out.printf(format, "for + int array");
            int[] intArray = new int[number + 1];
            int count = 0;
            for (int i = 1; i <= number; i++) {
                boolean isDivisible = number % i == 0;
                if (isDivisible) {
                    intArray[count++] = i;
                }
            }

            for (int i = 0; i < count; i++) {
                System.out.print(intArray[i] + " ");
            }

            System.out.println(System.lineSeparator());

            // 6. Using stream
            System.out.printf(format, "IntStream");
            IntStream.rangeClosed(1, number)
                .filter(i -> number % i == 0)
                .forEach(value -> System.out.print(value + " "));

            System.out.println(System.lineSeparator());

            // 7. Different algorithm
            int[] array = new int[(number >> 1)];
            int cnt = 0;
            for (int i = 1; i < array.length; i++) {
                boolean isDivisible = number % i == 0;
                if (isDivisible) {
                    array[cnt++] = i;
                }
            }
            System.out.printf(format, "Different Algorithm 1");
            for (int i = 0; i < cnt; i++) {
                System.out.print(array[i] + " ");
            }
            for (int i = cnt - 1 - 2; i >= 0; i--) {
                int val = array[i];
                int alt = number / array[i];
                if (val != alt) {
                    System.out.print(alt + " ");
                }
            }

            System.out.println(System.lineSeparator());

            // 8. Possible solutions
            Set<Integer> set = new HashSet<>();
            for (int i = 1; i <= (number >> 1); i++) {
                boolean isDivisible = number % i == 0;
                if (isDivisible) {
                    set.add(i);
                    set.add(number / i);
                }
            }
            System.out.printf(format, "Different Algorithm 2");
            set.stream().sorted().forEach(value -> System.out.print(value + " "));
        }

    }
}
