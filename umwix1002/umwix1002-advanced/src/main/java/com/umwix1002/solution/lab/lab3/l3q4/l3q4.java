package com.umwix1002.solution.lab.lab3.l3q4;

/**
 * @author Ng Zhi Yang
 */
public class l3q4 {
    public static void main(String[] args) {
        int p1 = (int) (Math.random() * 11 + 2);
        int p2 = (int) (Math.random() * 11 + 2);
        System.out.printf("Player %d wins\n", (p1 > p2) ? 1 : 2);
    }
}
