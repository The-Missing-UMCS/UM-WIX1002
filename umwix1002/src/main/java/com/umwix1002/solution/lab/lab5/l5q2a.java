package com.umwix1002.solution.lab.lab5;

/**
 * @author Ng Zhi Yang
 */
public class l5q2a {
    public static void main(String[] args) {
        int min = 0, max = 20, range = max - min + 1, count = 0, n = 10;
        boolean[] set = new boolean[range];
        while(count < n) {
            int rand = (int)(Math.random() * range) + min;
            if(set[rand]) {
                continue;
            }
            set[rand] = true; 
            count++;
        }
        for(int i = 0; i < range; i++) {
            if(set[i]) {
                System.out.print(i + ", ");
            }
        }
    }
}
