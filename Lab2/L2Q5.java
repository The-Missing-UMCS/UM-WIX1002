package Lab2;

public class L2Q5 {
	public static void main(String[] args) {

		// Solution 1
		int randomNum = (int)(Math.random() * 10001);
		int digit;
		int factor = 10;
		int i = 1;
		int sum = 0;
		
		System.out.println("The number generated is " + randomNum);
		
		while (randomNum != 0) {
			digit = randomNum % 10;
			System.out.printf("%10d: %d\n", i, digit);
			
			sum += digit;
			i *= 10;
			randomNum = Math.floorDiv(randomNum, factor);
		}
		
		System.out.println("The sum of all digit is " + sum);
		
		System.out.println("\n ===================== \n");
		
		// Solution 2
		randomNum = (int)(Math.random() * 10001);
		sum = 0;
		System.out.println("The number generated is " + randomNum);
		while (randomNum != 0) {
			sum += (randomNum % 10);
			randomNum = Math.floorDiv(randomNum, 10);
		}
		
		
		System.out.println("The sum of all digit is " + sum);
		System.out.println("\n\nSolution 3");
		
		
		// Solution 3
		randomNum = (int)(Math.random() * 10001);
		System.out.println("The number is " + randomNum);
		for(sum = 0; randomNum > 0; randomNum /= 10) {
			digit = randomNum % 10;
			System.out.println("The digit is " + digit);
			sum += digit;
		}
		System.out.println("The sum is " + sum);
	}
}
