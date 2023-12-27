package Tutorial5;

import java.util.Scanner;

public class T5Q4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your sentence here: ");
		String[] arr = scanner.nextLine().split(" ");
		scanner.close();
		
		int counter = 0;
		for(int i = 0; i < arr.length; i++)
			if (arr[i].equals("the"))
				counter++;
		
		System.out.println("The occurrence of word 'the' = " + counter);

	}
}
