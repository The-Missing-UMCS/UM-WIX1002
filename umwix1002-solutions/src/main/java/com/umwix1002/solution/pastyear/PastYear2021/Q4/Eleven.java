package com.umwix1002.solution.pastyear.PastYear2021.Q4;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public abstract class Eleven {
    protected int[] arr;

    protected Eleven(int[] data) {
        this.arr = data;
    }

    public String divide() {
        return Arrays.stream(arr)
            .mapToObj(this::checkDivisibility)
            .collect(Collectors.joining(System.lineSeparator(), getRuleName() + System.lineSeparator(), ""));
    }

    protected String formResult(int originalValue, int computedValue, int modulus, Supplier<String> upperLineSupplier) {
        String lowerLine = modulus == 0
            ? String.format("%d modulus 11 = 0, %d is divisible by 11", computedValue, originalValue)
            : String.format("%d modulus 11 is not equal to 0, %d is not divisible by 11", computedValue, originalValue);
        return String.format("""
            %s
            %s
            """, upperLineSupplier.get(), lowerLine);
    }

    protected abstract String getRuleName();

    protected abstract String checkDivisibility(int value);

}

