package Lab4;

import java.util.*;

public class WIX1002_Lab4_Q5_V2 {
	int year;
	int firstDayOfYear;
	int targetMonth;
	
	public static void main(String[] args) {
		new WIX1002_Lab4_Q5_V2().run();
	}
	
	public void run() {
		getInput();
		Calendar calendar = new Calendar(year, firstDayOfYear);
		if (targetMonth >= 1 && targetMonth <= 12) {
			calendar.getCalendar(targetMonth);
		} else {
			for(int i = 1; i <= 12; i++) {
				calendar.getCalendar(i);
				calendar.setToDefault();
				System.out.println("");
			}
		}
		
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
}

class Calendar {
	final String[] MONTHS = {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
	final String[] DAYS = {"SUN","MON","TUE","WED","THUR","FRI","SAT"};
	String[] weeks = new String[42];
	int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	int year;
	int firstDayOfYear;
	int firstDayOfMonth;
	
	Calendar(int year, int firstDayOfYear) {
		this.year = year;
		this.firstDayOfYear = firstDayOfYear;
		
		if (Year.isLeapYear(this.year))
			days[2] = 29;
	}
	
	public void getCalendar(int month) {
		System.out.println("\nMONTH: " + MONTHS[month-1]);
		this.calcCalendar(month);
		this.makeCalendar(month);
		this.printCalendar();
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
	
	public void setToDefault() {
		weeks = new String[42];
	}
}

class Year {
	public static boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
	}
}


