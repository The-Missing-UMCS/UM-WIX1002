package com.umwix1002.solution.lab.lab5;

import com.umwix1002.solution.lab.CommonConstant;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class l5q2b {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        Random random = new Random();
        while(set.size() < 10) {
            set.add(random.nextInt(1, 21));
        }
        set.forEach(value -> System.out.print(value + CommonConstant.SPACE));
    }
}
