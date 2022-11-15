package Lab4;

import java.util.Scanner;

public class WIX1002_Lab4_Q8 {
	String[] labels = {"Month","Monthly Payment","Principal","Interest","Unpaid Balance","Total interest"};
	int principal;
	int interest;
	int numberMonth;
	
	int currentMonth = 1;
	
	double monthlyPayment, principalPortionDue, interestDue, unpaidBalance;
	double totalInterest = 0;
	double repeatedValue;
	
	public static void main(String[] args) {
		new WIX1002_Lab4_Q8().run();
	}
	
	public void run() {
		getInput();
		
		// Setup repeated value
		repeatedValue = interest / (double)(12 * 100);
		
		// Print Header Row
		System.out.printf("%s%-10s", " ".repeat(5), labels[0]);
		for(int i = 1; i < labels.length; i++) {
			System.out.printf("%20s", labels[i]);
		}
		
		System.out.println("");
		
		// Calc and display each line of result
		for(int i = 0; i < numberMonth; i++) {
			calcAll();
			displayLine();
			currentMonth++;
		}
	}
	
	public void getInput() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter principal amount: ");
		principal = scanner.nextInt();
		System.out.print("Enter interest in %： ");
		interest = scanner.nextInt();
		System.out.print("Enter total number of month(s): ");
		numberMonth = scanner.nextInt();
		
		scanner.close();
	}
	
	public void calcAll() {
		calMonthlyPayment();
		calPrincipalPortionDue();
		calInterestDue();
		calUnpaidBalance();
	}
	
	public void calMonthlyPayment() {
		double numerator = principal * repeatedValue;
		double denominator = 1 - Math.pow(1 + repeatedValue, (numberMonth * -1));
		monthlyPayment =  numerator / denominator;
	}
	
	public void calPrincipalPortionDue() {
		int index = (1 + numberMonth - currentMonth) * -1;
		principalPortionDue = monthlyPayment * Math.pow((1 + repeatedValue), index);
	}
	
	public void calInterestDue() {
		interestDue = monthlyPayment - principalPortionDue;
		totalInterest += interestDue;
	}
	
	public void calUnpaidBalance() {
		unpaidBalance = (interestDue / repeatedValue) - principalPortionDue;
	}
	
	public void displayLine() {
		System.out.printf("%s%-10d%20.2f%20.2f%20.2f%20.2f%20.2f\n", 
				" ".repeat(5), currentMonth, monthlyPayment, principalPortionDue, 
				interestDue, unpaidBalance, totalInterest);
	}
}
