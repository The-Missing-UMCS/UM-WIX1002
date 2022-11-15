package Lab4;

public class WIX1002_Lab4_Q7 {
	public static void main(String[] args) {
		int num = (int)(Math.random() * Integer.MAX_VALUE + 1);
		int digit;
		int i = 0;
		
		System.out.println("Random number = " + num);
		while(num != 0) {
			digit = num % 10;
			num = Math.floorDiv(num, 10);
			System.out.printf("%15d = %d\n", (1 * (int) Math.pow(10, i)), digit);
			i++;
		}
	}
}
