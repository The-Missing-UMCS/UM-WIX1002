package Lab6;

public class L6Q6 {
	public static void main(String[] args) {
		System.out.printf("%-20s: ", "Palindromic Prime");
		for(int count = 0, i = 0; count < 20; i++) {
			if (isPalindromicPrime(i)) {
				System.out.print(i + ((count == 19) ? "\n" : " "));
				count++;
			}
				
		}
		
		System.out.printf("%-20s: ", "Emirp");
		for(int count = 0, i = 0; count < 20; i++) {
			if (isEmirp(i)) {
				System.out.print(i + ((count == 19) ? "\n" : " "));
				count++;
			}
		}
		
		System.out.printf("%-20s: ", "Prime");
		for(int count = 0, i = 0; count < 20; i++) {
			if (isPrime(i)) {
				System.out.print(i + ((count == 19) ? "\n" : " "));
				count++;
			}
		}

	}
	
	public static boolean isPalindromicPrime(int n) {
		return (isPalindromic(n) && isPrime(n));
	}
	
	public static boolean isEmirp(int n) {
		return (!isPalindromic(n) && isPrime(n) && isPrime(reverse(n)));
	}
	
	public static boolean isPrime(int n) {
		// https://gitlab.com/fop2022/group05/-/blob/main/22004835/Lab%206/L6Q6.java
		if(n == 2) return true;
		if(n < 2)  return false;

		for(int i = 3; i <= Math.sqrt(n); i += 2) 
			if (n % i == 0)
				return false;
		
		return true;
		
		/*
		if (n < 2)
			return false;
		
		if (n == 2)
			return true;
		
		for(int i = 3; i <= Math.sqrt(n); i += 2) {
			if (n % i == 0)
				return false;
		}
		
		return true;
		
		 */
	}
	
	public static boolean isPalindromic(int n) {
		if (n < 0 || n % 10 == 0)
			return false;
		
		int tmp = 0;
		while(tmp < n) {
			tmp = tmp * 10 + n % 10;
			n /= 10;
		}
		
		return (tmp == n || (tmp / 10) == n);
	}
	
	public static int reverse(int n) {
		int tmp = 0;
		
		while(n != 0) {
			tmp = tmp * 10 + n % 10;
			n /= 10;
		}
		
		return tmp;
	}
}
