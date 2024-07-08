package wix1002_2017_2.Q3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of random integer: ");
        final int N = sc.nextInt();
        int[] numbers = generateRandomNumbers(N);
        System.out.println("The random integer : " + toArrayString(numbers));
        System.out.println("Minimum Number : " + findMinInArray(numbers));
        System.out.println("The approximation of the integer to the nearest hundred : "
                + toArrayString(roundDownToNearest(100, numbers)));
        System.out.println("The random integer in reverse order: " + toArrayString(reverseNumInArray(numbers)));
        sc.close();
    }

    public static int[] generateRandomNumbers(int n) {
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++)
            numbers[i] = (int) (Math.random() * 10001);
        return numbers;
    }

    public static String toArrayString(int[] arr) {
        return Arrays.toString(arr)
                .replace("[", "")
                .replace("]", "")
                .replace(", ", " ");
    }

    public static int findMinInArray(int[] arr) {
        int min = arr[0];
        for (int i : arr)
            if (i < min)
                min = i;
        return min;
    }

    public static int[] roundDownToNearest(int precision, int[] arr) {
        final int N = arr.length;
        int[] results = new int[N];
        for (int i = 0; i < N; i++)
            results[i] = arr[i] / precision * precision;
        return results;
    }

    public static int[] reverseNumInArray(int[] arr) {
        final int N = arr.length;
        int[] results = new int[N];
        for (int i = 0; i < N; i++)
            results[i] = reverseNum(arr[i]);
        return results;
    }

    public static int reverseNum(int val) {
        int result = 0;
        while (val > 0) {
            result = result * 10 + val % 10;
            val /= 10;
        }
        return result;
    }
}
