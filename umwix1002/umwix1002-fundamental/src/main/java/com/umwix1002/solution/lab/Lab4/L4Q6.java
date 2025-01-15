package Lab4;

public class L4Q6 {
	public static void main(String[] args) {
		int num = (int)(Math.random() * Integer.MAX_VALUE + 1), digit;		
		System.out.println("Random number = " + num);
		for(int i = 0 ; num > 0; num /= 10, i++) {
			digit = num % 10;
			System.out.printf("%15d = %d\n", (1 * (int) Math.pow(10, i)), digit);
		}
	}
}
