package com.umwix1002.solution.lab.Lab9.L9Q2;

// Reference code: https://github.com/LimJY03/WIX1002_UM/blob/main/Lab%2009/L9Q2_3/Student.java

public class L9Q2 {
	public static void main(String[] args) {
		String file = "./io_files/Lab07/course.txt";
		new Student("John Doe",'F',"01-01-2003", file).showDetails();
	}
}