package com.umwix1002.solution.pastyear.PastYear2019.wix1002_2019_2.Q6;

import java.util.Scanner;

public class Q6Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String customerName = getStringInput(sc, "Enter customer name :");
        String customerId = getStringInput(sc, "Enter customer id:");
        int quantity = getIntInput(sc, "Enter quantity ordered :");
        double unitPrice = getDoubleInput(sc, "Enter price per unit :");

        System.out.println(new Order(customerName, customerId, quantity, unitPrice) + "\n");
        System.out.println(new ShippedOrder(customerName, customerId, quantity, unitPrice));
    }

    public static String getStringInput(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    public static int getIntInput(Scanner sc, String prompt) {
        System.out.print(prompt);
        int val = sc.nextInt();
        sc.nextLine();
        return val;
    }

    public static double getDoubleInput(Scanner sc, String prompt) {
        System.out.print(prompt);
        double val = sc.nextDouble();
        sc.nextLine();
        return val;
    }

}
