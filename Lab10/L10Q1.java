package Lab10;

public class L10Q1 {
	public static void main(String[] args) {
		Employee[] employees = new Employee[3];
		employees[0] = new PermanentEmployee("Employee 1", 'A');
		employees[1] = new ContractStaff("Employee 2", 1250.30);
		employees[2] = new TemporaryStaff("Employee 3", 70);
		
		System.out.printf("%-13s %-22s %-10s\n", "Name", "Type", "Salary");
		for(int i = 0; i < employees.length; i++)
			employees[i].showDetails();
	}
}

abstract class Employee {
	protected final String EMPLOYEE_TYPE;
	protected final String EMPLOYEE_NAME;
	protected double salary;
	
	Employee(String type, String name) {
		this.EMPLOYEE_TYPE = type;
		this.EMPLOYEE_NAME = name;
	}
	
	abstract void setSalary();
	
	public void showDetails() {
		System.out.printf("%-13s %-22s %-10.2f\n", this.EMPLOYEE_NAME, this.EMPLOYEE_TYPE, this.salary);
	}
}

class PermanentEmployee extends Employee {
	private final char category;
	
	PermanentEmployee(String name, char category) {
		super("Permanent Employee", name);
		this.category = category;
		this.setSalary();
	}
	
	public void setSalary() {
		switch (this.category) {
		case 'A' -> this.salary = 4000;
		case 'B' -> this.salary = 3000;
		case 'C' -> this.salary = 2000;
		}
	}
}

class ContractStaff extends Employee {
	private final int INCOME = 500;
	private double totalSales;
	
	ContractStaff(String name, double totalSales) {
		super("Contract Staff", name);
		this.totalSales = totalSales;
		this.setSalary();
	}
	
	@Override
	public void setSalary() {
		this.salary = INCOME + totalSales * 0.5;
	}
}

class TemporaryStaff extends Employee {
	private final int PAY_RATE = 15;
	private double totalHour;
	
	TemporaryStaff(String name, double totalHour) {
		super("Contract Staff", name);
		this.totalHour = totalHour;
		this.setSalary();
	}
	
	@Override
	public void setSalary() {
		this.salary = PAY_RATE * this.totalHour;
	}
}


