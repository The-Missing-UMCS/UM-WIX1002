package com.umwix1002.solution.pastyear.PastYear2017.wix1002_2017_2.Q4;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Date[] dates = new Date[] {
                new Date(25, 3, 2017),
                new Date(29, 2, 2100),
                new Date(19, 1, 2017),
                new Date(31, 9, 2015),
                new Date(31, 5, 2017),
                new Date(29, 2, 2016)
        };
        for (Date date : dates) {
            Optional<DayOfTheWeek> o = DayOfTheWeek.getDayOfTheWeek(date.d, date.m, date.y);
            System.out.printf("%s is %s\n", date, o.map(dayOfTheWeek -> "on " + dayOfTheWeek).orElse("invalid Input"));
        }
    }

    static class Date {
        int d, m, y;

        Date(int d, int m, int y) {
            this.d = d;
            this.m = m;
            this.y = y;
        }

        @Override
        public String toString() {
            return String.format("%d/%d/%d", d, m, y);
        }
    }
}
