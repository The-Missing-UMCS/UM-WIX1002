package com.umwix1002.solution.lab.lab8.l8q1;

import com.umwix1002.solution.lab.constants.CommonConstant;
import com.umwix1002.solution.lab.util.MyMathUtil;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.IntStream;

import static com.umwix1002.solution.lab.constants.CommonConstant.TWO;

/**
 * @author Ng Zhi Yang
 */
@Data
@AllArgsConstructor
public class NumberPresenter {
    private int[] numbers;
    
    public void displayAll() {
        String pattern = "%-15s: %s%n";
        Map<String, String> map = new LinkedHashMap<>();
        map.put("Item", Arrays.toString(numbers));
        map.put("Maximum", String.valueOf(getMax().orElse(CommonConstant.NOT_FOUND)));
        map.put("Minimum", String.valueOf(getMin().orElse(CommonConstant.NOT_FOUND)));
        map.put("Average", String.valueOf(getAverage().orElse(CommonConstant.NOT_FOUND)));
        map.put("Prime", Arrays.toString(getPrime()));
        map.put("Odd", Arrays.toString(getOdd()));
        map.put("Even", Arrays.toString(getEven()));
        map.put("Square", Arrays.toString(getSquare()));
        map.put("Perfect Square", Arrays.toString(getPerfectSquare()));
        map.forEach((k, v) -> System.out.printf(pattern, k, v));
    }

    public OptionalInt getMax() {
        return streamOf(numbers).max();
    }

    public OptionalInt getMin() {
        return streamOf(numbers).min();
    }

    public OptionalDouble getAverage() {
        return streamOf(numbers).average();
    }
    
    public int[] getPrime() {
        return streamOf(numbers).filter(MyMathUtil::isPrime).toArray();
    }

    public int[] getOdd() {
        return streamOf(numbers).filter(MyMathUtil::isOdd).toArray();
    }

    public int[] getEven() {
        return streamOf(numbers).filter(MyMathUtil::isEven).toArray();
    }

    public int[] getSquare() {
        return streamOf(numbers).map(x -> x * x).toArray();
    }

    public int[] getPerfectSquare() {
        return streamOf(numbers).filter(this::isPerfectSquare).toArray();
    }

    private boolean isPerfectSquare(int x) {
        int sqrt = (int) Math.sqrt(x);
        return sqrt * sqrt == x;
    }
    
    private static IntStream streamOf(int[] arr) {
        return IntStream.of(arr);
    }
}
