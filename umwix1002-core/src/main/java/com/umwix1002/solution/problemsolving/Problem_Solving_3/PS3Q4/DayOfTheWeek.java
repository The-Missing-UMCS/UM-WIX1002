package com.umwix1002.solution.problemsolving.Problem_Solving_3.PS3Q4;

public class DayOfTheWeek {
    // Day of the week in congruence
    public static final String[] DAY_OF_WEEK = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

    // Add value = 0 at index = 0 to avoid IndexOutOfBoundException
    int[] dayOfMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int h, q, m, y, j, k;

    DayOfTheWeek(int dayOfMonth, int month, int year) {
        this.q = dayOfMonth;
        this.m = month;
        this.y = year;

        if (this.m == 1 || this.m == 2) { // January and February are counted as 13 and 14 of the previous year
            this.m += 12;
            this.y--;
        }

        this.k = this.y % 100;
        this.j = this.y / 100;

        this.h = (q + (13 * (this.m + 1) / 5) + k + (k / 4) + (j / 4) + 5 * j) % 7;

        if (this.m == 13 || this.m == 14) { // Restore the value of m and y
            this.m -= 12;
            this.y++;
        }
    }

    private boolean isLeapYear() {
        return ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0);
    }

    public boolean isValidDate() {
        if (isLeapYear()) {
            dayOfMonth[2] = 29;
        }
        return this.q <= dayOfMonth[m];
    }

    public int getDayOfMonth() {
        return this.q;
    }

    public int getMonth() {
        return this.m;
    }

    public int getYear() {
        return this.y;
    }

    public String getDayOfWeek() {
        return DAY_OF_WEEK[this.h];
    }
}
