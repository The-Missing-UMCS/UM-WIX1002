package com.umwix1002.solution.lab.lab08.l8q1a;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.function.IntPredicate;

public class Number {

    private final int[] arr;

    public Number() {
        this(10, 100, false);
    }

    public Number(int size) {
        this(size, 100, false);
    }

    public Number(int size, int upper) {
        this(size, upper, false);
    }

    public Number(int size, int upper, boolean isDuplicate) {
        if (!isDuplicate) {
            var set = new HashSet<Integer>();
            while (set.size() < size) {
                set.add((int) (Math.random() * (upper + 1)));
            }
            this.arr = set.stream().mapToInt(Integer::intValue).toArray();
        } else {
            this.arr = new Random().ints(size, 0, upper).toArray();
        }
        Arrays.sort(arr);
    }


    public Number(int[] arr) {
        this.arr = arr;
        Arrays.sort(arr);
    }

    public void displayAll() {
        final String format = "%-15s: %s\n";
        System.out.printf(format, "Items", this);
        System.out.printf(format, "Max", max());
        System.out.printf(format, "Min", min());
        System.out.printf(format, "Average", average());
        System.out.printf(format, "Even", Arrays.toString(evens()));
        System.out.printf(format, "Odd", Arrays.toString(odds()));
        System.out.printf(format, "Square", Arrays.toString(squares()));
        System.out.printf(format, "Perfect square", Arrays.toString(perfectSquares()));
        System.out.printf(format, "Prime", Arrays.toString(primes()));
    }

    public int max() {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    public int min() {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }
        return min;
    }

    public double average() {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return (double) sum / arr.length;
    }

    public int[] primes() {
        return keepOnly(this::isPrime);
    }

    public int[] odds() {
        return keepOnly(this::isOdd);
    }

    public int[] evens() {
        return keepOnly(this::isEven);
    }

    public int[] perfectSquares() {
        return keepOnly(this::isPerfectSquare);
    }

    public int[] squares() {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i] * arr[i];
        }
        return result;
    }

    private int[] keepOnly(IntPredicate predicate) {
        // 1. Find elements that match the requirement
        int[] subset = new int[arr.length];
        int index = 0;
        for (int j : arr) {
            if (predicate.test(j)) {
                subset[index++] = j;
            }
        }

        // 2. Return the result
        return Arrays.copyOf(subset, index);
    }

    public boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public boolean isOdd(int n) {
        return (n % 2 == 1);
    }

    public boolean isEven(int n) {
        return (n % 2 == 0);
    }

    public int square(int n) {
        return n * n;
    }

    public boolean isPerfectSquare(int x) {
        return (int) (Math.sqrt(x)) == Math.sqrt(x);
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}
