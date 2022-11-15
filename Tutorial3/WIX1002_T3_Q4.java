package Tutorial3;

public class WIX1002_T3_Q4 {
	public static void main(String[] args) {
		int[] numbers = {2, 3, 5};
		int max = 0;
		for (int i = 0; i < 3; i++) {
			if (numbers[i] > max) {
				max = numbers[i];
			}
		}
		System.out.println("The maximum number is " + max);
	}
}
