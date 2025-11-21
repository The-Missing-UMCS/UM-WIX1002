package com.umwix1002.solution.pastyear.PastYear2025;

import java.util.Arrays;
import java.util.Random;

public class py25q2a {
    private static final int[] RANDOM_NUMS = new int[10];

    public static void main(String[] args) {
        int largestEven = findLargestEven();
        System.out.println("The generated array is: " + Arrays.toString(RANDOM_NUMS));
        System.out.println("largest even number is: " + (largestEven == -1 ? "No even number found" : largestEven));
    }

    private static int findLargestEven() {
        // 1. Generate an array of 10 random integers between 1 and 100 using Random class
        Random random = new Random();
        for (int i = 0; i < RANDOM_NUMS.length; i++) {
            RANDOM_NUMS[i] = random.nextInt(1, 101);
        }

        // 2. Find the largest even number in the array
        int largestEven = -1;
        for (int num : RANDOM_NUMS) {
            if (num % 2 == 0 && num > largestEven) {
                largestEven = num;
            }
        }

        // 3. Return the largest even number
        return largestEven;
    }
}
