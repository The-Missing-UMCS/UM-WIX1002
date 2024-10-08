package com.umwix1002.solution.lab.lab6;

import java.util.Scanner;
import java.util.stream.LongStream;

/**
 * This implementation uses {@code long} to accommodate larger numbers. However, if you encounter 
 * an error such as:
 * <pre>
 * Exception in thread "main" java.util.InputMismatchException: For input string: "2183982193829138923"
 * </pre>
 * it indicates that the number exceeds the range of {@code long}. 
 * To resolve this issue, consider using the {@link java.math.BigInteger} class instead.
 *
 * @author Ng Zhi Yang
 */
public class l6q3 {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            long[] arr = new long[10];
            for(int i = 0; i < 10; i++) {
                System.out.printf("Enter a number (%d): ", i + 1);
                arr[i] = sc.nextInt();
            }
            LongStream.of(arr).forEach(val -> System.out.printf("input=%15d, reverse=%15d\n", val, reverse(val)));
        }
    }
    
    public static long reverse(long val) {
        long result = 0;
        while(val != 0) {
            result = result * 10 + val % 10;
            val /= 10;
        }
        return result;
    }
}
