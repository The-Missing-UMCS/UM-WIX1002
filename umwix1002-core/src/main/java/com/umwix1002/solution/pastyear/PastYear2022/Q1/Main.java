package com.umwix1002.solution.pastyear.PastYear2022.Q1;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Main {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        double[] prices = getRandomPrices(3, 100, 300);
        int[] years = getEvenNumberedYears(5, 1990, 2030);
        String carPlate = generateCarPlate(5, 2);
        String randomWord = generateRandomWord(8);

        displayArray(prices, "Random Prices", "%.2f");
        displayArray(years, "Even Numbered Years", "%d");
        displayString(carPlate, "Car Plate Number");
        displayString(randomWord, "Random Word");
    }

    private static double[] getRandomPrices(int count, double start, double end) {
        return DoubleStream.generate(() -> start + RANDOM.nextDouble() * (end - start))
            .limit(count)
            .sorted()
            .toArray();
    }

    private static int[] getEvenNumberedYears(int count, int startYear, int endYear) {
        return IntStream.range(0, count)
            .map(i -> startYear + RANDOM.nextInt((endYear - startYear + 1) / 2) * 2)
            .sorted()
            .toArray();
    }

    private static String generateCarPlate(int numOfDigits, int numOfChars) {
        String digits = IntStream.range(0, numOfDigits)
            .mapToObj(i -> String.valueOf(RANDOM.nextInt(10)))
            .collect(Collectors.joining());

        String letters = RANDOM.ints(numOfChars, 'A', 'Z' + 1)
            .mapToObj(c -> String.valueOf((char) c))
            .collect(Collectors.joining());

        return digits + letters;
    }

    private static String generateRandomWord(int maxChar) {
        int length = RANDOM.nextInt(maxChar) + 1;
        return RANDOM.ints(length, 0, 2)
            .mapToObj(flag -> {
                int base = (flag == 0) ? 'a' : 'A';
                return (char) (RANDOM.nextInt(26) + base);
            })
            .map(String::valueOf)
            .collect(Collectors.joining());
    }

    public static char getRandomChar() {
        // if lowercaseFlag = 1, it will generate lowercase letter and vice versa
        int flag = RANDOM.nextInt(2);
        int tmp = RANDOM.nextInt(26);
        return (char) (tmp + ((flag == 1) ? 'a' : 'A'));
    }

    private static <T> void displayArray(T[] array, String title, String format) {
        System.out.printf("%s (%d values): ", title, array.length);
        for (T value : array) {
            System.out.printf(format + " ", value);
        }
        System.out.println();
    }

    private static void displayArray(int[] array, String title, String format) {
        System.out.printf("%s (%d values): ", title, array.length);
        for (int value : array) {
            System.out.printf(format + " ", value);
        }
        System.out.println();
    }

    private static void displayArray(double[] array, String title, String format) {
        System.out.printf("%s (%d values): ", title, array.length);
        for (double value : array) {
            System.out.printf(format + " ", value);
        }
        System.out.println();
    }

    private static void displayString(String str, String title) {
        System.out.printf("%s: %s%n", title, str);
    }
}
