package PastYear2023;

import java.util.Scanner;
public class Q2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numOfStudents, numOfSubjects, mark;
		numOfStudents = prompt(sc, "Enter the number of students: ", 0, 10);
		int[][] marks = new int[numOfStudents][];
		
		for(int stp = 0; stp < numOfStudents; stp++) {
			numOfSubjects = prompt(sc, String.format("Enter the number of subjects for student %d: ", stp + 1), 0, 10);
			int sum = 0;
			marks[stp] = new int[numOfSubjects + 1];
			
			for(int sbp = 0; sbp < numOfSubjects; sbp++) {
				mark = prompt(sc, String.format("Student (%d) Enter mark for Subject %d: ", stp + 1, sbp + 1), 0, 100);
				marks[stp][sbp] = mark;
				sum += mark;
			}
			
			marks[stp][numOfSubjects] = sum / numOfSubjects;
		}
		sc.close();
		
		int maxNo = 0, maxAverage = 0;
		System.out.printf("List of Students (%d students)\n", numOfStudents);
		for(int stp = 0; stp < numOfStudents; stp++) {
			System.out.println("Student " + (stp + 1));
			int sbp = 0;
			for( ; sbp < marks[stp].length - 1; sbp++) 
				System.out.printf("  Subject %d:%d\n", sbp + 1, marks[stp][sbp]);
			int average = marks[stp][sbp];
			System.out.println("Average Marks: " + average);
			
			if(average > maxAverage) {
				maxNo = stp;
				maxAverage = average;
			}
		}
		
		System.out.printf("Student %d has the highest average, with %d marks\n", maxNo + 1, maxAverage);
	}
	
	public static int prompt(Scanner sc, String message, int low, int high) {
		int value = 0;
		while(true) {
			System.out.print(message);
			value = sc.nextInt();
			if(value >= low && value <= high)
				break;
			System.out.print("Error!!! ");
		}
		return value;
	}
}
