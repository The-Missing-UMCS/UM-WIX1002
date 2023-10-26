package Lab4;
import java.util.Scanner;

public class L4Q8A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a value: ");
		int num = sc.nextInt(); sc.close();
		for(int i = 2; i <= num; i++) 
			if (isPrime(i)) 
				System.out.print(i + " ");
	}
	
	public static boolean isPrime(int num) {
		if (num < 2) return false;
		for(int i = 3; i < num; i += 2) 
			if(num % i == 0) 
				return false;
		return true;
	}
}
