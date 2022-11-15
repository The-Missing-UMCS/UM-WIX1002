package Lab4;
// Java Program to Generate Desired Calendar
// Without calendar.get() function or
// Inputting the Year and the Month
  
// Importing required classes
import java.util.Scanner;
  
// Main class
public class GFG {
  
    // Main driver method
    public static void main(String a[])
    {
  
        // Reading input by creating object of Scanner class
        Scanner sc = new Scanner(System.in);
  
        // Display message only
        System.out.print("Enter the year : ");
  
        // Reading integer input value
        int yy = sc.nextInt();
  
        // Display message only
        System.out.print("Enter month : ");
  
        // Reading integer input value
        int mm = sc.nextInt();
  
        int d = 1;
        int m = 1;
        int y = 1;
        int dy = 1;
  
        // Storing data and months as input
        String day[] = { "SUN", "MON", "TUE", "WED",
                         "THU", "FRI", "SAT" };
        String month[]
            = { "JANUARY", "FEBRUARY", "MARCH",
                "APRIL",   "MAY",      "JUNE",
                "JULY",    "AUGUST",   "SEPTEMBER",
                "OCTOBER", "NOVEMBER", "DECEMBER" };
  
        // Custom array as input
        int ar[] = { 31, 29, 31, 30, 31, 30,
                     31, 31, 30, 31, 30, 31 };
  
        // Till condition holds true
        /*
        while (true) {
  
            if (d == 1 && m == mm && y == yy) {
                break;
            }
  
           
            dy++;
            d++;
  
            if (d > ar[m - 1]) {
                m++;
                d = 1;
            }
  
            if (m > 12) {
                m = 1;
                y++;
            }
  
            if (dy == 7) {
                dy = 0;
            }
        }
        */
  
        int c = dy;
  
        if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0) {
            ar[1] = 29;
        }
        else {
            ar[1] = 28;
        }
  
        // Print the desired month of input year
        System.out.println("MONTH:" + month[mm - 1]);
  
        for (int k = 0; k < 7; k++) {
            System.out.print("   " + day[k]);
        }
  
        System.out.println();
  
        for (int j = 1; j <= (ar[mm - 1] + dy); j++) {
            if (j > 6) {
                dy = dy % 6;
            }
        }
  
        int spaces = dy;
        if (spaces < 0)
            spaces = 6;
  
        // Printing the calendar
        for (int i = 0; i < spaces; i++)
            System.out.print("      ");
        for (int i = 1; i <= ar[mm - 1]; i++) {
            System.out.printf(" %4d ", i);
  
            if (((i + spaces) % 7 == 0)
                || (i == ar[mm - 1]))
                System.out.println();
        }
    }
}