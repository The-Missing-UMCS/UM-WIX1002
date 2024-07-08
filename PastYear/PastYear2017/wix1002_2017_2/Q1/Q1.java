package wix1002_2017_2.Q1;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        final int N;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a number: ");
        N = s.nextInt();
        System.out.println("The first " + N + " triangular numbers");
        for (int i = 1; i < N; i++)
            System.out.print(getTriangular(i) + " ");
        System.out.println();
        s.close();
    }

    public static double getTriangular(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++)
            sum += 1;
        return sum;
    }

}
