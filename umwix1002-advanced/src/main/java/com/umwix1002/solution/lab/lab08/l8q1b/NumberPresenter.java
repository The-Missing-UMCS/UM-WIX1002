package com.umwix1002.solution.lab.lab08.l8q1b;

import com.umwix1002.solution.lab.util.MyMathUtil;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * @author Ng Zhi Yang
 */
@Data
@AllArgsConstructor
public class NumberPresenter {

    private IntStream streamOf(int[] arr) {
        return IntStream.of(arr);
    }

    public void displayAll(int[] numbers) {
        Map<String, Object> map = new LinkedHashMap<>();
        IntSummaryStatistics summary = IntStream.of(numbers).summaryStatistics();

        map.put("Item", Arrays.toString(numbers));
        map.put("Maximum", summary.getMin());
        map.put("Minimum", summary.getMax());
        map.put("Average", summary.getAverage());

        map.put("Prime", Arrays.toString(getPrime(numbers)));
        map.put("Odd", Arrays.toString(getOdd(numbers)));
        map.put("Even", Arrays.toString(getEven(numbers)));
        map.put("Square", Arrays.toString(getSquare(numbers)));
        map.put("Perfect Square", Arrays.toString(getPerfectSquare(numbers)));

        map.forEach((k, v) -> System.out.printf("%-15s: %s%n", k, v));
    }

    public int[] getPrime(int[] numbers) {
        return keepOnly(numbers, MyMathUtil::isPrime);
    }

    public int[] getOdd(int[] numbers) {
        return keepOnly(numbers, MyMathUtil::isOdd);
    }

    public int[] getEven(int[] numbers) {
        return keepOnly(numbers, MyMathUtil::isEven);
    }

    public int[] getSquare(int[] numbers) {
        return transform(numbers, stream -> stream.map(x -> x * x));
    }

    public int[] getPerfectSquare(int[] numbers) {
        return keepOnly(numbers, this::isPerfectSquare);
    }

    private boolean isPerfectSquare(int x) {
        int sqrt = (int) Math.sqrt(x);
        return sqrt * sqrt == x;
    }

    private int[] keepOnly(int[] numbers, IntPredicate condition) {
        return transform(numbers, stream -> stream.filter(condition));
    }

    private int[] transform(int[] numbers, Function<IntStream, IntStream> function) {
        IntStream stream = Arrays.stream(numbers);
        function.apply(stream);
        return stream.toArray();
    }
}
