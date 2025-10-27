package com.umwix1002.solution.lab.lab02;

import java.util.Scanner;

/**
 * @author Ng Zhi Yang
 */
public class l2q2 {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            double price = scanner.nextDouble();
            double downPayment = scanner.nextDouble();
            double interestRate = scanner.nextDouble();
            double loanDuration = scanner.nextDouble();
            double payment = (price - downPayment) * (1 + interestRate * loanDuration / 100) / (loanDuration * 12);
            System.out.println("The monthly payment is " + payment);
        }
    }
}
