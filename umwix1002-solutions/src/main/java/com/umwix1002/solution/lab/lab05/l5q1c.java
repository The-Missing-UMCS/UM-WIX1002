package com.umwix1002.solution.lab.lab05;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.Random;

/**
 * @author Ng Zhi Yang
 */
public class l5q1c {
    public static void main(String[] args) {
        DescriptiveStatistics stats = new DescriptiveStatistics();
        new Random().ints(10, 1, 101).forEach(stats::addValue);
        System.out.println("min = " + stats.getMin());
        System.out.println("max = " + stats.getMax());
        System.out.println("average = " + stats.getMean());
    }
}
