package wix1002_2019_2.Q3;

import java.util.Random;
import java.util.Scanner;

public class Q3Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int number1, number2, ans;
        boolean isContinue = true;
        do {
            System.out.println();
            number1 = rand.nextInt(10);
            number2 = rand.nextInt(10);
            System.out.printf("What is %d + %d ? ", number1, number2);
            System.out.printf("%d + %d = %d is %b\n",
                    number1, number2, (ans = sc.nextInt()), number1 + number2 == ans);
            sc.nextLine();
            System.out.print("Do you wan to try another question (y/n) ? : ");
            isContinue = sc.nextLine().charAt(0) == 'y';
        } while (isContinue);
        System.out.println("Program ends");
        sc.close();
    }
}
