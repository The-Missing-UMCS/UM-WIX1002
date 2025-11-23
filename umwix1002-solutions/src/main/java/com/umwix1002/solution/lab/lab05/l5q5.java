package com.umwix1002.solution.lab.lab05;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class l5q5 {

    public static void main(String[] args) {
        System.out.println("A list of 20 random integers within 0 and 100");
        int[] arr = createIntArray(20, 0, 100);
        printArray(arr);

        System.out.println("Array in descending order");
        int[] reversed = reverse(arr);
        printArray(reversed);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a number to search: ");
            int x = scanner.nextInt();

            int[] sorted = sort(arr);
            linearSearch(sorted, x);
            binarySearchUsingWhileLoop(sorted, x);
            binarySearchUsingForLoop(sorted, x);
        }
    }

    private static int[] createIntArray(int size, int minBound, int maxBound) {
        int[] arr = new int[size];
        int min = minBound + 1, max = maxBound - 1, range = max - min + 1;

        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(range) + min;
        }
        return arr;
        // or
        // return random.ints(size, min, max + 1).toArray();
    }

    public static void binarySearchUsingWhileLoop(int[] arr, int targetValue) {
        int count = 1, low = 0, mid, high = arr.length - 1;

        while (low <= high) {
            // You might want to use (low + high) / 2, but it might cause overflow.
            mid = low + (high - low) / 2;

            if (arr[mid] == targetValue) {
                System.out.printf("%d found. Binary Search - %d loop(s)%n", targetValue, count);
                return;
            }

            if (arr[mid] > targetValue) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            count++;
        }

        System.out.printf("Binary Search - %d not found", targetValue);
    }

    public static void binarySearchUsingForLoop(int[] arr, int targetValue) {
        for (
            int count = 1, low = 0, high = arr.length - 1, mid;
            low <= high;
            count++
        ) {
            // You might want to use (low + high) / 2, but it might cause overflow.
            mid = low + (high - low) / 2;
            if (arr[mid] == targetValue) {
                System.out.printf("%d found. Binary Search - %d loop(s)%n", targetValue, count);
                return;
            }

            if (arr[mid] > targetValue) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.printf("Binary Search - %d not found", targetValue);
    }

    public static void linearSearch(int[] arr, int x) {
        for (
            int i = 0, cnt = 1;
            i < arr.length;
            i++, cnt++
        ) {
            if (arr[i] == x) {
                System.out.printf("%d found. Linear Search - %d loop(s)\n", x, cnt);
                return;
            }
        }
        System.out.printf("Linear Search - %d + not found", x);
    }

    private static int[] sort(int[] arr) {
        int n = arr.length;
        int[] result = Arrays.copyOf(arr, n);
        sortAscending(result);
        return result;
    }

    private static int[] reverse(int[] arr) {
        int n = arr.length;
        int[] result = Arrays.copyOf(arr, n);
        sortDescending(result);
        return result;
    }

    private static void sortDescending(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            boolean hasSwap = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    hasSwap = true;
                }
            }
            if (!hasSwap) {
                break;
            }
        }
    }

    private static void sortAscending(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            boolean hasSwap = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    hasSwap = true;
                }
            }
            if (!hasSwap) {
                break;
            }
        }
    }

    private static void printArray(int[] arr) {
        // Enhanced for loop
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        // or
        // System.out.println(Arrays.toString(arr).replaceAll("[\\[\\]]", ""));
    }
}

