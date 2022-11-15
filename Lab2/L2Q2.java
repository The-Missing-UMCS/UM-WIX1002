package Lab2;

public class L2Q2 {
	public static void main(String[] args) {
		double price = 0;
		double downPayment = 0;
		double interestRate = 0;
		double loanDuration = 0;
		double payment = (price - downPayment) * (1 + interestRate * loanDuration / 100) / (loanDuration * 12);
		System.out.println("The monthly payment is " + payment);
	}
}
