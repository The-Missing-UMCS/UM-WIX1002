package com.fyiernzy.ProblemSolving.PS3;

public class PS3Q5 {
	public static void main(String[] args) {
		PermanentStaff p1 = new PermanentStaff("Abdul Razak", "871001-14-1765", "EM02" );
		PartTimeStaff p2 = new PartTimeStaff("Tengku Ali", "911223-08-3301", 35);
		System.out.println(p1.toString());
		System.out.println(p2.toString()); 
	}
}

abstract class Staff {
	protected final String NAME;
	protected final String IC;
	
	Staff(String name, String ic) {
		this.NAME = name;
		this.IC = ic;
	}
	
	@Override 
	public String toString() {
		return String.format("Full Name: %s\nIC: %s\n", this.NAME, this.IC);
	}
	
	abstract double getSalary();
}

class PermanentStaff extends Staff {
	private String grade;
	PermanentStaff(String name, String ic, String grade) {
		super(name, ic);
		this.grade = grade;
	}
	
	@Override
	public double getSalary() {
		double salary = 0;
		
		switch(this.grade) {
		case "EM01" -> salary = 7000;
		case "EM02" -> salary = 5000;
		case "EM03" -> salary = 3000;
		case "EM04" -> salary = 1000;
		}
		
		return salary;
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format("Grade: %s\nSalary: RM %.0f\n", grade, getSalary());
	}
}

class PartTimeStaff extends Staff {
	private int workingHour;
	
	PartTimeStaff(String name, String ic, int hour) {
		super(name, ic);
		this.workingHour = hour;
	}
	
	@Override
	public double getSalary() {
		return this.workingHour * 40;
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format("Number of working Hours: %d\nSalary: RM %.0f\n", workingHour, getSalary());
	}
}
