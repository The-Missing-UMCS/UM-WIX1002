package com.umwix1002.solution.lab.lab4;

import com.umwix1002.solution.lab.CommonConstant;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.Scanner;

/**
 * @author Ng Zhi Yang
 */
public class l4q3b {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            DescriptiveStatistics stats = new DescriptiveStatistics();
            while(true) {
                System.out.print("Enter a score [negative score to quit]: ");
                int input = sc.nextInt();
                boolean isQuit = input < 0;
                if(isQuit) {
                    break;
                }
                stats.addValue(input);
            }
            System.out.println("Minimum Score: " + stats.getMin());
            System.out.println("Maximum Score: " + stats.getMax());
            System.out.printf("Average Score: %.2f\n", stats.getMean());
            System.out.printf("Standard Deviation: %.2f\n ", stats.getStandardDeviation());
        }
    }
}
