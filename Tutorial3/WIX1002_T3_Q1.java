package Tutorial3;

import java.util.Scanner;
public class WIX1002_T3_Q1 {
	public static void main(String[] args) {
		// Question A
		System.out.println("3 * 8 = 27 is " + (3 * 8 == 27));
		
		// Question B
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int number = scanner.nextInt();
		String isEven = (number % 2 == 0) ? "even" : "odd";
		System.out.printf("%d is %s number\n", number, isEven);
		
		// Question C
		char ch = 'A';
		String isCapital = Character.isUpperCase(ch) ? "is" : "isn't";
		System.out.printf("%c %s capital letter\n", ch, isCapital);
		
		// Question D
		String str1 = "Sunday";
		String str2 = "Monday";
		if (str1.charAt(0) < str2.charAt(0)) {
			System.out.println(str1 + " " + str2);
		} else {
			System.out.println(str2 + " " + str1);
		}
		
		// Question E
		System.out.print("Enter a number between 0 - 6: ");
		int num = scanner.nextInt();
		switch (num) {
		case 0:
			System.out.println("Sunday");
			break;
		case 1:
			System.out.println("Monday");
			break;
		case 2:
			System.out.println("Tuesday");
			break;
		case 3:
			System.out.println("Wednesday");
			break;
		case 4:
			System.out.println("Thursday");
			break;
		case 5:
			System.out.println("Friday");
			break;
		case 6:
			System.out.println("Saturday");
			break;
		}
		
		// Better solution for Question E
		String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		System.out.print("Enter a number between 0 - 6: ");
		num = scanner.nextInt();
		System.out.println(days[num]);
	}
}
