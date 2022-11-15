package Tutorial4;

import java.util.Scanner;

public class WIX1002_T4_Q1 {
	public static void main(String[] args) {
		System.out.println("Question A");
		int n = 1;
		int num = 0;
		while (num < 2000) {
			n++;
			num = (int)(Math.pow(n, 3));
		}
		System.out.println("The largest n = " + (n - 1));
		
		System.out.println("");
		System.out.println("Question B");
		int spaceNum = 1;
		for(int i = 1; i <= 12; i++) {
			System.out.printf("%5d", i * i);
			if(spaceNum % 5 == 0)
				System.out.println("");
			spaceNum++;
		}		
		
		System.out.println("\n");
		System.out.println("Question C");
		int randomNum;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 5; j++) {
				randomNum = (int)((Math.random() * 100) + 1);
				System.out.print(randomNum + "\t");
			}
			System.out.println("");
		}
		
		System.out.println("");
		System.out.println("Question D");
		Scanner scanner = new Scanner(System.in);
		System.out.print("Given number: ");
		int givenNumber = scanner.nextInt();
		scanner.close();
		int sum = 0;
		for(int i = 1; i <= givenNumber; i++) {
			sum += i;
		}
		System.out.println("Sum = " + sum);
		
		
		System.out.println("");
		System.out.println("Question E");
		double total = 0;
		for(int i = 1; i < 25; i++) {
			total += (i / (double) (25 - i));
		}
		System.out.printf("Total = %.2f",total);
			
	}
}
