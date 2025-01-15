package com.umwix1002.solution.lab.Lab8.L8Q1;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.HashSet;
import java.util.Random;

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
        return IntStream.of(arr).max().orElse(-1);
    }

    public int min() {
        return IntStream.of(arr).min().orElse(-1);
    }

    public double average() {
        return IntStream.of(arr).average().orElse(-1);
    }

    public int[] primes() {
        return IntStream.of(arr).filter(this::isPrime).toArray();
    }

    public int[] odds() {
        return IntStream.of(arr).filter(this::isOdd).toArray();
    }

    public int[] evens() {
        return IntStream.of(arr).filter(this::isEven).toArray();
    }

    public int[] squares() {
        return IntStream.of(arr).map(this::square).toArray();
    }

    public int[] perfectSquares() {
        return IntStream.of(arr).filter(this::isPerfectSquare).toArray();
    }

    public boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
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
