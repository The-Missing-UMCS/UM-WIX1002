package com.fyiernzy.Lab9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class L9Q3 {
	public static void main(String[] args) {
		String file = "./io_files/Lab07/lecturer.txt";
		new Lecturer("John Doe",'F',"01-01-2003", file).showDetails();
	}
}

class Lecturer extends PersonProfile{
	HashMap<String, Lecture> lectureList = new HashMap<String, Lecture>();
	
	Lecturer(String name, char gender, String date, String file) {
		super(name, gender, date);
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String code = "";
			while((code = reader.readLine()) != null) {
				lectureList.put(code, new Lecture(code, reader.readLine(), 
						Integer.parseInt(reader.readLine()), 
						Integer.parseInt(reader.readLine()), 
						Double.parseDouble(reader.readLine()),
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
		System.out.printf(" %-13s | %-35s | %8s | %10s | %15s | %15s | \n", 
				"-".repeat(13), "-".repeat(35),  "-".repeat(8),  "-".repeat(10),  "-".repeat(15),  "-".repeat(15));
		
		System.out.printf(" %-13s | %-35s | %8s | %10s | %15s | %15s | \n", 
				"Course Code","Course Name", "Session", "Semester", "Student Count", "Credit Hour");
		
		System.out.printf(" %-13s | %-35s | %8s | %10s | %15s | %15s | \n", 
				"-".repeat(13), "-".repeat(35),  "-".repeat(8),  "-".repeat(10),  "-".repeat(15),  "-".repeat(15));
		
		for(String code : this.lectureList.keySet()) {
			Lecture lecture = this.lectureList.get(code);
			System.out.printf(" %-13s | %-35s | %8d | %10d | %15d | %15s | \n",
					code, lecture.getCourseName(), lecture.getSession(), 
					lecture.getSemester(), lecture.getCount(), lecture.getHour());
			
		}
	}
}

class Lecture {
	private String courseCode;
	private String courseName;
	private int session;
	private int semester;
	private double creditHour;
	private int studentCount;
	
	Lecture(String code, String name, int session, int semester, double hour, int count) {
		this.courseCode = code;
		this.courseName = name;
		this.session = session;
		this.semester = semester;
		this.creditHour = hour;
		this.studentCount = count;
		this.updateCreditHour();
	}
	
	public void updateCreditHour() {
		if (this.studentCount >= 150) { this.creditHour *= 3; }
		else if (this.studentCount >= 100) { this.creditHour *= 2; }
		else if (this.studentCount >= 50) { this.creditHour *= 1.5; }
		else { this.creditHour *= 1; }
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
	
	public double getHour() {
		return this.creditHour;
	}
	
	public int getCount() {
		return this.studentCount;
	}
}
