package com.umwix1002.solution.lab.lab05;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class l5q5b {
    public static void main(String[] args) {
        int[] randomNumbers = getRandomNums(20, 0, 100);
        System.out.println("A list of 20 random integers within 0 and 20: " + toString(randomNumbers));
        System.out.println("Array in descending order: " + toString(reverse(randomNumbers)));

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a number to search: ");
            int target = scanner.nextInt();

            String pattern = "%d %s found. %s search - %d loops(s)%n";

            // 1. Display Binary Search Result
            SearchResult binaryRes = binarySearch(randomNumbers, target);
            System.out.printf(pattern, target, binaryRes.getResult() == -1 ? "not" : "",
                "Binary", binaryRes.getLoops());

            // 2. Display Linear Search Result
            SearchResult linearRes = linearSearch(randomNumbers, target);
            System.out.printf(pattern, target, linearRes.getResult() == -1 ? "not" : "",
                "Linear", linearRes.getLoops());
        }
    }

    public static SearchResult binarySearch(int[] arr, int key) {
        SearchResult searchResult = SearchResult.initial(arr, key);
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        int low = 0, high = arr.length - 1, mid;
        while (low <= high) {
            searchResult.loop();
            // You might want to use (low + high) / 2, but it might cause overflow.
            mid = low + (high - low) / 2;
            if (copy[mid] == key) {
                searchResult.setResult(mid);
                return searchResult;
            } else if (copy[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return searchResult;
    }

    public static SearchResult linearSearch(int[] arr, int key) {
        SearchResult searchResult = SearchResult.initial(arr, key);
        for (int i = 0; i < arr.length; i++) {
            searchResult.loop();
            if (arr[i] == key) {
                searchResult.setResult(i);
                return searchResult;
            }
        }
        return searchResult;
    }

    private static String toString(int[] arr) {
        if (arr == null || arr.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(',').append(' ');
            }
        }
        return sb.append(']').toString();
    }

    private static int[] reverse(int[] arr) {
        int n = arr.length;
        int[] reversed = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            reversed[n - i - i] = arr[i];
        }
        return reversed;
    }

    private static int[] getRandomNums(int size, int min, int max) {
        return new Random().ints(size, min, max + 1).toArray();
    }

    @Getter
    public static class SearchResult {
        private int target;

        private int[] copy;

        @Setter(AccessLevel.PUBLIC)
        private int result;

        private int loops;

        public static SearchResult initial(int[] arr, int target) {
            SearchResult searchResult = new SearchResult();
            searchResult.copy = Arrays.copyOf(arr, arr.length);
            searchResult.target = target;
            searchResult.loops = 0;
            searchResult.result = -1;
            return searchResult;
        }

        public void loop() {
            loops++;
        }
    }
}
