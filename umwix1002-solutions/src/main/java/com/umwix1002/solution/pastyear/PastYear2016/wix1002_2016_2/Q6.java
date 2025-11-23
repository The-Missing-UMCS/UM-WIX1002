package com.umwix1002.solution.pastyear.PastYear2016.wix1002_2016_2;

public class Q6 {
	public static void main(String[] args) {
		FinancialRecord accountA = new FinancialRecord(1234, 10_000);
		accountA.setAnnualInterestRate(7.77);
		System.out.println("The information about financial record A is as follows.");
		accountA.displayRecordInfo();
		System.out.println();
		
		FinancialRecord accountB = new FinancialRecord(1235, 20_000);
        accountB.setAnnualInterestRate(8.0);
        System.out.println("The information about financial record B is as follows.");
        accountB.displayRecordInfo();
        System.out.println("The monthly interest rate is: " + accountB.getMonthlyInterestRate());
        accountB.deposit(1500);
        accountB.withdraw(500);
	}
}
