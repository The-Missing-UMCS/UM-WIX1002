package Lab3;

import java.util.Scanner;

public class L3Q1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter two number: " );
		int num1 = scanner.nextInt();
		int num2 = scanner.nextInt();
		System.out.print("Enter the operator: ");
		char operator = scanner.next().charAt(0);
		
		scanner.close();
		int result = 0;
		
		switch (operator) {
		case '+':
			result = num1 + num2;
			break;
		case '-':
			result = num1 - num2;
			break;
		case '*':
			result = num1 * num2;
			break;
		case '/':
			result = (int) (num1 / num2);
			break;
		case '%':
			result = num1 % num2;
			break;
		}
		
		System.out.printf("%d %c %d is %d", num1, operator, num2, result);
	}
}
