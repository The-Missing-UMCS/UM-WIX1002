package Lab4;

public class Tester {
	public static void main(String[] args) {
		int principal = 10000;
		int interest = 4;
		int numberMonth = 12;
		
		double repeatedValue = interest / (double) (12 * 100);
		double numerator = principal * repeatedValue;
		double denominator = 1 - Math.pow(1 + repeatedValue, (numberMonth * -1));
		double monthlyPayment =  numerator / denominator;
		
		System.out.println(monthlyPayment);
	}
}
