package com.umwix1002.solution.lab.Lab5;

import java.util.Scanner;

public class L5Q3A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of employee: ");
        int N = sc.nextInt();
        int [][] hours = new int [N][7]; // hours[N][day]
        int [] sum = new int [N];

        System.out.printf("%18s %7s %7s %7s %7s %7s %7s %7s\n","Day 1","Day 2","Day 3","Day 4","Day 5","Day 6","Day 7","Total");
        for (int i=0; i<hours.length; i++) {
            System.out.printf("%5s%2d","Employee ",(i+1));
            for (int j = 0; j < hours[i].length; j++) {
                hours[i][j] = (int) (Math.random() * 8+1);
                System.out.printf("%5d %2s",hours[i][j]," ");
                sum[i] += hours[i][j];
            }
            System.out.printf("%6s",sum[i]);
            System.out.println();
        }
    }
}
