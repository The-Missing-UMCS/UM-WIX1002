package com.umwix1002.solution.pastyear.PastYear2016.wix1002_2016_1;

import java.util.Arrays;

public class Q1 {
    public static void main(String[] args) {
        int[] num = {34, 15, 12, 27, 74, 23};
        int cnt = 0;

        for (int j : num) {
            cnt += isEven(j) ? 1 : 0;
        }
        System.out.println("The number of even number is " + cnt);
        System.out.println("The sum of the array is " + Arrays.stream(num).sum());
    }

    public static boolean isEven(int a) {
        return (a & 1) == 0;
    }
}
