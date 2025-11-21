package com.umwix1002.solution.viva.viva2223.viva01;

import java.util.*;

public class Viva1_Class {
	public static void main(String[] args) {
		new Student("Carmen", "s23789", 90.3);
		new Student("Ali", "s12345", 77.9);
		new Student("Emilin", "s18743", 75.2);
		new Student("Dinesh", "s14569", 68.0);
		new Student("Beng", "s24567", 23.5);
		
		Student.showList();
		
		System.out.println("\nSort by Name");
		Student.sort("name");
		Student.showList();
		
		System.out.println("\nSort by Reg No");
		Student.sort("regno");
		Student.showList();
		
		System.out.println("\nSort by Fop Marks");
		Student.sort("marks", false);
		Student.showList();
	}
}

class Student {
	private static ArrayList<Student> ls = new ArrayList<Student>();
	private static ArrayList<Double> marksLs = new ArrayList<Double>();
	private String name;
	private String regNo;
	private double fopMarks;
	
	Student(String name, String no, double marks){
		this.name = name;
		this.regNo = no;
		this.fopMarks = marks;
		ls.add(this);
		marksLs.add(marks);
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getNo() {
		return this.regNo;
	}
	
	public double getMarks() {
		return this.fopMarks;
	}
	
	public String checkAverage() {
		double average = marksLs.stream().mapToDouble(x -> x).average().getAsDouble();
		if (this.fopMarks > average) return "ABOVE";
		else if (this.fopMarks == average) return "AVERAGE";
		else return "BELOW";
	}
	
	static class NameComparator implements Comparator<Student> {
		boolean isAscending;
		
		NameComparator() {
			this.isAscending = true;
		}
		
		NameComparator(boolean isAscending) {
			this.isAscending = isAscending;
		}
		
		@Override
		public int compare(Student std1, Student std2) {
			return ((isAscending) ? 1 : -1) * std1.getName().compareTo(std2.getName());
		}
	}
	
	static class RegNoComparator implements Comparator<Student> {
		boolean isAscending;
		
		RegNoComparator() {
			this.isAscending = true;
		}
		
		RegNoComparator(boolean isAscending) {
			this.isAscending = isAscending;
		}
		
		@Override
		public int compare(Student std1, Student std2) {
			return ((isAscending) ? 1 : -1) * std1.getNo().compareTo(std2.getNo());
		}
	}
	
	static class MarksComparator implements Comparator<Student> {
		boolean isAscending;
		
		MarksComparator() {
			this.isAscending = true;
		}
		
		MarksComparator(boolean isAscending) {
			this.isAscending = isAscending;
		}
		
		@Override
		public int compare(Student std1, Student std2) {
			return ((isAscending) ? 1 : -1) * (int) (std1.getMarks() - std2.getMarks());
		}
	}
	
	public static void sort(String type, boolean isAscending) {
		if (type.equalsIgnoreCase("name")) 
			Collections.sort(ls, new NameComparator(isAscending));
		else if (type.equalsIgnoreCase("regno"))
			Collections.sort(ls, new RegNoComparator(isAscending));
		else if (type.equalsIgnoreCase("marks"))
			Collections.sort(ls, new MarksComparator(isAscending));
	}
	
	public static void sort(String type) {
		if (type.equalsIgnoreCase("name")) 
			Collections.sort(ls, new NameComparator());
		else if (type.equalsIgnoreCase("regno"))
			Collections.sort(ls, new RegNoComparator());
		else if (type.equalsIgnoreCase("marks"))
			Collections.sort(ls, new MarksComparator());
	}
	
	public static void showList() {
		System.out.printf(" %-12s  %-10s %6s %10s\n", "Reg No.", "Name", "FOP Marks","Average");
		System.out.println(" +" + "-".repeat(45) + "+");
		ls.forEach(person -> System.out.printf(" %-12s  %-10s %6.2f %12s\n", person.getNo(), person.getName(), person.getMarks(), person.checkAverage()));
	}
}
