package wix1002_2019_2.Q5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter values for a, b and c: ");
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
        QuadraticEquation eq = new QuadraticEquation(a, b, c);
        System.out.println("The equation is : " + eq);
        double dis, r1, r2;
        System.out.printf("Discriminant: %.0f\n", (dis = eq.discriminant()));
        System.out.println(dis < 0 ? "The equation has no roots"
                : (r1 = eq.calcRoot1()) == (r2 = eq.calcRoot2())
                        ? String.format("Same roots : %.0f", r1)
                        : String.format("The roots: %.0f and %.0f", r1, r2));
        sc.close();
    }

}
