package com.umwix1002.solution.lab.lab03;

import java.util.Scanner;

public class l3q6 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the radius: ");
            int radius = sc.nextInt();
            System.out.print("Enter the coordinate (4 5) : ");
            int x = sc.nextInt();
            int y = sc.nextInt();
            int dist = (int) Math.sqrt(x * x + y * y);
            System.out.println(dist > radius ? "Outside" : "Inside");
        }
    }
}
