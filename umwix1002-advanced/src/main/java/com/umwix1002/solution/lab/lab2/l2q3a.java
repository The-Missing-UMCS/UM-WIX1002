package com.umwix1002.solution.lab.lab2;

public class l2q3a {
    public static void main(String[] args) {
        int[] arr = new int[3];

        // Generate three random numbers
        for (int i = 0; i < 3; i++) {
            arr[i] = (int) (Math.random() * 41 + 10);
        }

        // Display three numbers
        for (int i = 0; i < 3; i++) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }

        // Calculate the sum of three numbers
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        System.out.println("Sum     : " + sum);

        // Calculate average of three numbers
        double average = (double) sum / arr.length;
        System.out.printf("Averagje : %.2f%n", average);
    }
    
}
