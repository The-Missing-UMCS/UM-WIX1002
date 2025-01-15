package com.umwix1002.solution.pastyear.PastYear2017.wix1002_2017_2.Q4;

import java.util.Optional;

public class DayOfTheWeek {
    private static final int[] M = { 0, 13, 14, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
    private static final String[] H = { "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" };
    private static int[] D = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    private int h, q, m, y, J, K;

    public DayOfTheWeek(int q, int m, int y) {
        this.q = q;
        this.m = m;
        this.y = y;
        init();
    }

    void init() {
        this.m = M[m];
        this.y -= this.m > 12 ? 1 : 0;
        this.J = y / 100;
        this.K = y % 100;
        this.h = (q + 13 * (m + 1) / 5 + K + K / 4 + J / 4 + 5 * J) % 7;
    }

    public String getDayOfTheWeek() {
        return H[h];
    }

    @Override
    public String toString() {
        return getDayOfTheWeek();
    }

    public static Optional<DayOfTheWeek> getDayOfTheWeek(int d, int m, int y) {
        if (!isValidInput(d, m, y))
            return Optional.empty();
        return Optional.of(new DayOfTheWeek(d, m, y));
    }

    static boolean isLeapYear(int y) {
        return y % 400 == 0 || y % 4 == 0 && y % 100 != 0;
    }

    static boolean isValidInput(int d, int m, int y) {
        return d >= 1 && d <= (isLeapYear(y) && m == 2 ? D[m] + 1 : D[m]);
    }
}
