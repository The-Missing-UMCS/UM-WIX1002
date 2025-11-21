package com.umwix1002.solution.lab.lab03;

import java.util.Scanner;

public class l3q5 {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("""
                Crammer's rule:
                    ax + by = e, cx + dy = f
                    x = (ed - bf) / (ad - bc)
                    y = (af - ec) / (ad - bc)
                """);
            int[] val = new int[6];
            for (int i = 0; i < 6; i++) {
                System.out.printf("Enter the value of %c : ", i + 'a');
                val[i] = sc.nextInt();
            }
            int a = val[0], b = val[1], c = val[2], d = val[3], e = val[4], f = val[5];
            int denominator = a * d - b * c;
            if (denominator == 0) {
                System.out.println("no solution");
            } else {
                System.out.printf("x = %d, y = %d%n",
                    (e * d - b * f) / denominator,
                    (a * f - e * c) / denominator
                );
            }
        }
    }
}
