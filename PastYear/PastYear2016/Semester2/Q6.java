package PastYear2016.S2;


public class Q6 {
	public static void main(String[] args) {
		FinancialRecord acc_a = new FinancialRecord(1234, 10_000);
		acc_a.setAnnualInterestRate(7.77);
		System.out.println("The information about financial record A is as follows.");
		acc_a.displayRecordInfo();
		System.out.println();
		
		FinancialRecord acc_b = new FinancialRecord(1235, 20_000);
        acc_b.setAnnualInterestRate(8.0);
        System.out.println("The information about financial record B is as follows.");
        acc_b.displayRecordInfo();
        System.out.println("The monthly interest rate is: " + acc_b.getMonthlyInterestRate());
        acc_b.deposit(1500);
        acc_b.withdraw(500);
        
       
        
        
	}
}
