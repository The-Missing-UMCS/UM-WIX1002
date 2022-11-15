package Lab4;

import java.util.*;

public class WIX1002_Lab4_Q5 {
	String[] months = {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
	String[] weeks = new String[42];
	int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	int year;
	int firstDayOfYear;
	int targetMonth;
	int firstDayOfMonth;
	
	public static void main(String[] args) {
		new WIX1002_Lab4_Q5().run();
	}
	
	public void run() {
		getInput();
		checkLeapYear();
		if (targetMonth >= 1 && targetMonth <= 12) {
			System.out.println(months[targetMonth-1]);
			generateCal(targetMonth);
		} else {
			for(int i = 1; i <= 12; i++) {
				System.out.println(months[i-1]);
				generateCal(i);
				System.out.println("");
			}
		}
	}
	
	public void generateCal(int month) {
		calcCalendar(month);
		makeCalendar(month);
		printCalendar();
	}
	
	public void printCalendar() {
		String[] label = {"Sun","Mon","Tue","Wed","Thur","Fri","Sat"};
		for(int i = 0; i < 7; i++)
			System.out.printf("%8s",label[i]);
		
		System.out.println("");
		
		int counter = 0;
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 7; j++) {
				if(weeks[counter] == null) {
					System.out.printf("%8s","");
				} else {
					System.out.printf("%8s", weeks[counter]);
				}
				counter++;
			}
			System.out.println("");
		}
	}
	
	public void makeCalendar(int month) {
		for (int i = 0; i < days[month]; i++) {
			weeks[i+firstDayOfMonth] = Integer.toString(i+1);			
		}
	}
	
	public void calcCalendar(int month) {
		int cumalativeDays = 0;
		
		for(int i = 1; i < month; i++) {
			cumalativeDays += days[i];
		}
		
		firstDayOfMonth = (firstDayOfYear + (cumalativeDays)) % 7;
	}
	
	public void getInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the year: ");
		year = scanner.nextInt();
		System.out.print("Enter the first day of the year: ");
		firstDayOfYear = scanner.nextInt();
		System.out.print("Target month: ");
		targetMonth = scanner.nextInt();
		scanner.close();
	}
	
	public void checkLeapYear() {
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
			days[1] = 29;
	}
	
}
