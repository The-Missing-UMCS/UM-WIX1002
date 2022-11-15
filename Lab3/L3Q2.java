package Lab3;

public class L3Q2 {
	public static void main(String[] args) {
		int randomNum = (int)(Math.random() * 6);
		String[] numbers = {"zero","one","two","three","four","five"};
		System.out.printf("%d is %s", randomNum, numbers[randomNum]);
	}
}
