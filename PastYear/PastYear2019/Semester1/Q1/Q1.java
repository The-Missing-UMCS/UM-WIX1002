package PastYear2019.Q1;

import java.util.Random;

public class Q1 {
	public static void main(String[] args) {
		System.out.println("This program shows the number of odd and eben number from 10 random numbers. The random numbers must be from 0 - 100");
		int num, odd = 0, even = 0;
		Random r = new Random();
		for(int i = 1; i <= 5; i++) {
			num = r.nextInt();
			System.out.print(num + " ");
			
			if(isEven(num)) 
				even++;
			else 
				odd++;
			
		}
		
		System.out.println("\nNumber of odd number: " + odd);
		System.out.println("Number of even number: " + even);
	}
	
	public static boolean isEven(double a) {
		return a % 2 == 0;
	}
}
