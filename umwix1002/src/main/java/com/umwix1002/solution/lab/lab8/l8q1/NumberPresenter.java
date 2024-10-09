package com.umwix1002.solution.lab.lab8.l8q1;

import com.umwix1002.solution.lab.CommonConstant;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author Ng Zhi Yang
 */
@Data
@AllArgsConstructor
public class NumberPresenter {
    private Number number;
    
    public void displayAll() {
        String pattern = "%-15s: %s%n";
        Map<String, String> map = new LinkedHashMap<>();
        map.put("Item", Arrays.toString(number.getNumbers()));
        map.put("Maximum", String.valueOf(getMax().orElse(CommonConstant.NOT_FOUND)));
        map.put("Minimum", String.valueOf(getMin().orElse(CommonConstant.NOT_FOUND)));
        map.put("Average", String.valueOf(getAverage().orElse(CommonConstant.NOT_FOUND)));
        map.put("Prime", Arrays.toString(getPrime()));
        map.put("Odd", Arrays.toString(getOdd()));
        map.put("Even", Arrays.toString(getEven()));
        map.put("Square", Arrays.toString(getSquare()));
        map.put("Perfect Square", Arrays.toString(getPerfectSquare()));
        for(Map.Entry<String, String> entry : map.entrySet()) {
            System.out.printf(pattern, entry.getKey(), entry.getValue());
        }
    }

    public OptionalInt getMax() {
        return streamOf(number.getNumbers()).max();
    }

    public OptionalInt getMin() {
        return streamOf(number.getNumbers()).min();
    }

    public OptionalDouble getAverage() {
        return streamOf(number.getNumbers()).average();
    }
    
    public int[] getPrime() {
        return streamOf(number.getNumbers()).filter(this::isPrime).toArray();
    }

    public int[] getOdd() {
        return streamOf(number.getNumbers()).filter(this::isOdd).toArray();
    }

    public int[] getEven() {
        return streamOf(number.getNumbers()).filter(this::isEven).toArray();
    }

    public int[] getSquare() {
        return streamOf(number.getNumbers()).map(x -> x * x).toArray();
    }

    public int[] getPerfectSquare() {
        return streamOf(number.getNumbers()).filter(this::isPerfectSquare).toArray();
    }

    private boolean isPerfectSquare(int x) {
        int sqrt = (int) Math.sqrt(x);
        return sqrt * sqrt == x;
    }

    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for(int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isOdd(int n) {
        return n % 2 != 0;
    }

    private boolean isEven(int n) {
        return n % 2 == 0;
    }
    
    private static IntStream streamOf(int[] arr) {
        return IntStream.of(arr);
    }
}
