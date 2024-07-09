package wix1002_2019_2.Q2;

import java.util.Scanner;

public class Q2Main {
    public static void main(String[] args) {
        final double PRICE_PER_KG = 5.99;
        final double SALES_TAX = 7.25;

        Scanner sc = new Scanner(System.in);
        final int numOfBag = getIntInput(sc, "Enter the number of bags sold : ");
        final int unitWeight = getIntInput(sc, "Enter the weight per bag (kilogram) : ");

        System.out.printf("Price per kilogram: $%.2f\n", PRICE_PER_KG);
        System.out.printf("Sales tax: %.2f%%\n", SALES_TAX);
        System.out.printf("Total price after tex: $%.2f\n",
                unitWeight * numOfBag * PRICE_PER_KG * (1 + SALES_TAX / 100));

        sc.close();
    }

    public static int getIntInput(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextInt();
    }

}
