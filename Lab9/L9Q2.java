package com.fyiernzy.Lab9;

import java.io.*;
import java.util.HashMap;

// Reference code: https://github.com/LimJY03/WIX1002_UM/blob/main/Lab%2009/L9Q2_3/Student.java

public class L9Q2 {
	public static void main(String[] args) {
		String file = "./io_files/Lab07/course.txt";
		new Student("John Doe",'F',"01-01-2003", file).showDetails();
	}
}

class PersonProfile {
	protected final String NAME;
	protected final char GENDER;
	protected final String DATE_OF_BIRTH;
	
	PersonProfile(String name, char gender, String date) {
		this.NAME = name;
		this.GENDER = gender;
		this.DATE_OF_BIRTH = date;
	}
	
	public void showDetails() {
		System.out.printf("Name: %s\nGender: %c\nBirthday: %s\n", NAME, GENDER, DATE_OF_BIRTH);
	}
}

class Student extends PersonProfile {
	HashMap<String, Course> courseList = new HashMap<String, Course>();
	
	Student(String name, char gender, String date, String file) {
		super(name, gender, date);
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String code = "";
			while((code = reader.readLine()) != null) {
				courseList.put(code, new Course(code, reader.readLine(), 
						Integer.parseInt(reader.readLine()), 
						Integer.parseInt(reader.readLine()), 
						Integer.parseInt(reader.readLine())));
			}
			reader.close();
		} catch (FileNotFoundException ex) { 
			ex.printStackTrace(); 
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public void showDetails() {
		super.showDetails();
		System.out.printf(" %-13s | %-35s | %8s | %10s | %7s | %7s | \n", 
				"-".repeat(13), "-".repeat(35),  "-".repeat(8),  "-".repeat(10),  "-".repeat(7),  "-".repeat(7));
		System.out.printf(" %-13s | %-35s | %8s | %10s | %7s | %7s | \n", 
				"Course Code","Course Name", "Session", "Semester", "Marks", "Grade");
		System.out.printf(" %-13s | %-35s | %8s | %10s | %7s | %7s | \n", 
				"-".repeat(13), "-".repeat(35),  "-".repeat(8),  "-".repeat(10),  "-".repeat(7),  "-".repeat(7));
		
		for(String code : this.courseList.keySet()) {
			Course course = this.courseList.get(code);
			System.out.printf(" %-13s | %-35s | %8d | %10d | %7d | %7s | \n",
					code, course.getCourseName(), course.getSession(), 
					course.getSemester(), course.getMarks(), course.getGrade());
			
		}
	}
}

class Course {
	private String courseCode;
	private String courseName;
	private int session;
	private int semester;
	private int marks;
	private String grade;
	
	Course(String code, String name, int session, int semester, int marks) {
		this.courseCode = code;
		this.courseName = name;
		this.session = session;
		this.semester = semester;
		this.marks = marks;
		this.setGrade();
	}
	
	public void setGrade() {
		if (marks >= 85) { this.grade = "A"; }
		else if (marks >= 85) { this.grade = "A-"; }
		else if (marks >= 75) { this.grade = "B+"; }
		else if (marks >= 70) { this.grade = "B"; }
		else if (marks >= 65) { this.grade = "B-"; }
		else if (marks >= 60) { this.grade = "C+"; }
		else if (marks >= 55) { this.grade = "C"; }
		else if (marks >= 45) { this.grade = "D"; }
		else if (marks >= 35) { this.grade = "E"; }
		else  { this.grade = "F"; }
	}
	
	public String getCourseCode() {
		return this.courseCode;
	}
	
	public String getCourseName() {
		return this.courseName;
	}
	
	public int getSession() {
		return this.session;
	}
	
	public int getSemester() {
		return this.semester;
	}
	
	public int getMarks() {
		return this.marks;
	}
	
	public String getGrade() {
		return this.grade;
	}
	
}