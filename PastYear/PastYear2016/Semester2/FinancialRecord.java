package PastYear2016.S2;

public class FinancialRecord {
	private int id;
	private double balance;
	private double annualInterestRate;
	
	public FinancialRecord() {
		this(0, 0);
	}
	
	public FinancialRecord(int id, double balance) {
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = 0;
	}
	
	public int getID() {
		return id;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	
	public double getMonthlyInterestRate() {
		return annualInterestRate / 12;
	}
	
	public void withdraw(double amount) {
		if(amount < balance) {
			System.out.printf("Previous balance: RM%.1f\n", balance);
			balance -= amount;
			System.out.printf("Current balance after withdrawal of RM%.1f is: RM%.1f\n", amount, balance);
		}
	}
	
	public void deposit(double amount) {
		if(amount > 0) {
			System.out.printf("Previous balance: RM%.1f\n", balance);
			balance += amount;
			System.out.printf("Current balance after withdrawal of RM%.1f is: RM%.1f\n", amount, balance);
		}
	}
	
	public void displayRecordInfo() {
		System.out.println("Financial record id is: " + id);
		System.out.printf("Financial record balance is: RM%s\n", balance);
		System.out.printf("Annual interest rate is: %s\n", annualInterestRate);
	}
	
	
}
