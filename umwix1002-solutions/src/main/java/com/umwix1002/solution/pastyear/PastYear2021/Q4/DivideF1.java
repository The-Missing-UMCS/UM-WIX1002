package com.umwix1002.solution.pastyear.PastYear2021.Q4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DivideF1 extends Eleven {

    public DivideF1(int[] data) {
        super(data);
    }

    @Override
    protected String getRuleName() {
        return "Divisibility Rule 1";
    }

    @Override
    protected String checkDivisibility(int value) {
        List<Integer> groupOne = new ArrayList<>();
        List<Integer> groupTwo = new ArrayList<>();

        splitDigits(value, groupOne, groupTwo);

        int oneSum = groupOne.stream().mapToInt(Integer::intValue).sum();
        int twoSum = groupTwo.stream().mapToInt(Integer::intValue).sum();
        int difference = Math.abs(oneSum - twoSum);
        int mod = difference % 11;

        return formResult(value, difference, mod, () -> {
            String groupOneString = concatenate(groupOne);
            String groupTwoString = concatenate(groupTwo);
            return String.format("%d : |x| = | %s - %s | = %d", value, groupOneString, groupTwoString, difference);
        });
    }

    private void splitDigits(int value, List<Integer> groupOne, List<Integer> groupTwo) {
        boolean isGroupOneTurn = true;

        while (value > 0) {
            int digit = value % 10;
            List<Integer> group = isGroupOneTurn ? groupOne : groupTwo;
            group.add(digit);
            isGroupOneTurn = !isGroupOneTurn;
            value /= 10;
        }
    }

    private String concatenate(List<Integer> digits) {
        return digits.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(" + ", "(", ")"));
    }
}
