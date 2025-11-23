package com.umwix1002.solution.pastyear.PastYear2021.Q4;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DivideF1B extends Eleven {
    public DivideF1B(int[] data) {
        super(data);
    }

    @Override
    protected String getRuleName() {
        return "Divisibility Rule 1b";
    }

    @Override
    protected String checkDivisibility(int value) {
        // 1. Determine the maximum possible number of digits for grouping
        //    +1 is added in case of an odd number of digits
        int maxGroups = (String.valueOf(value).length() >> 1) + 1;
        int[][] groupedDigits = new int[2][maxGroups];
        int digitPosition = 0;
        int totalDifference = 0;

        // 2. Process each digit of the number
        for (int remainingValue = value; remainingValue > 0; digitPosition++, remainingValue /= 10) {
            int groupType = digitPosition & 1; // Determines which group (odd/even index)
            int positionInGroup = digitPosition >> 1; // Determines position within the group
            int digit = groupedDigits[groupType][positionInGroup] = remainingValue % 10;
            int weight = (groupType == 0) ? 1 : -1;
            totalDifference += weight * digit;
        }

        // 3. Compute the absolute difference, digitPosition and modulus
        int absoluteDifference = Math.abs(totalDifference);
        int finalDigitPosition = digitPosition;
        int modulus = absoluteDifference % 11;

        // 4. Format the result using helper methods
        return formResult(value, absoluteDifference, modulus, () -> {
            String groupOneString = concatenate(groupedDigits[0], (finalDigitPosition >> 1) + (finalDigitPosition & 1));
            String groupTwoString = concatenate(groupedDigits[1], finalDigitPosition >> 1);
            return String.format("%d : |x| = | %s - %s | = %d", value, groupOneString, groupTwoString, absoluteDifference);
        });
    }

    private String concatenate(int[] digits, int length) {
        return IntStream.range(0, length)
            .mapToObj(i -> String.valueOf(digits[i]))
            .collect(Collectors.joining(" + ", "(", ")"));
    }
}
