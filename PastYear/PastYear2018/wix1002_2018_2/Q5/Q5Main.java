package wix1002_2018_2.Q5;

import java.util.Scanner;

public class Q5Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Essay essay = new Essay(
                getIntInput(sc, compose("Grammar", 30), 0, 30),
                getIntInput(sc, compose("Spelling", 20), 0, 20),
                getIntInput(sc, compose("Length", 20), 0, 20),
                getIntInput(sc, compose("Content", 30), 0, 30));
        System.out.println("\n" + essay);
    }

    public static String compose(String label, int max) {
        return String.format("Enter the marks for %s (maximum %d) marks: ", label, max);
    }

    public static int getIntInput(Scanner sc, String prompt, int min, int max) {
        int input = -1;
        do {
            System.out.print(prompt);
            input = sc.nextInt();
        } while (input < min || input > max);
        return input;
    }
}
