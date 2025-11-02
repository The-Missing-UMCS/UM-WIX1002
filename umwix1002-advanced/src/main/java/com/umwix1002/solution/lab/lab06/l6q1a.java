package com.umwix1002.solution.lab.lab06;


public class l6q1a {
    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++)
            System.out.print(triangular(i) + " ");
    }

    public static int triangular(int n) {
        return n <= 1 ? n : n + triangular(n - 1);
    }
}
