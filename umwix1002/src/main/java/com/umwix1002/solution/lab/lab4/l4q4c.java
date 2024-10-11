package com.umwix1002.solution.lab.lab4;

import com.umwix1002.solution.lab.CommonConstant;
import org.jetbrains.annotations.NotNull;

import java.time.DayOfWeek;
import java.time.Month;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Ng Zhi Yang
 */
public class l4q4c {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the year: ");
            int year = scanner.nextInt();
            displayAtYearMonth(year, 10);
            displayAtYearMonth(year, 8);
        }
    }
    
    public static void displayAtYearMonth(int year, int month) {
        displayAtYearMonth(YearMonth.of(year, month));
    }

    /**
     * Displays the calendar for a given year and month.
     * This method uses the java.time API introduced in Java 8 to generate the output.
     * It is intended for learning the Java time API.
     * The output resembles the following:
     *
     * <pre>
     * JULY 2024
     *  MON TUE WED THU FRI SAT SUN
     *        1   2   3   4   5   6
     *    7   8   9  10  11  12  13
     *   14  15  16  17  18  19  20
     *   21  22  23  24  25  26  27
     *   28  29  30  31
     * </pre>
     *
     * @param yearMonth the YearMonth to display
     * @see java.time.YearMonth
     * @see java.time.DayOfWeek
     * @see java.time.Month
     * @see CommonConstant
     */

    public static void displayAtYearMonth(@NotNull YearMonth yearMonth) {
        final String pattern = "%4s";

        // It's often better to hard-code values directly, like this:
        // String[] daysOfWeek = {"Mon", "Tue", ...}.
        // This example, however, demonstrates how to use the Stream API to achieve the desired output.
        String[] daysOfWeek = Arrays.stream(DayOfWeek.values())
            .map(day -> day.name().substring(0, 3))
            .map(day -> String.format(pattern, day))
            .toArray(String[]::new);
        
        String header = String.join(CommonConstant.BLANK, daysOfWeek);
        
        Month monthEnum = yearMonth.getMonth();
        System.out.println(monthEnum.name() + CommonConstant.SPACE + yearMonth.getYear());
        System.out.println(header);
        int firstDayOfWeek = yearMonth.atDay(CommonConstant.ONE).getDayOfWeek().getValue() - CommonConstant.ONE;
        for (int i = 0; i < firstDayOfWeek; i++) {
            System.out.printf(pattern, CommonConstant.BLANK);
        }
        for (int i = CommonConstant.ONE; i <= 31; i++) {
            System.out.printf(pattern, i);
            boolean needToNewLine = (i + firstDayOfWeek) % 7 == CommonConstant.ZERO;
            if (needToNewLine) {
                System.out.println();
            }
        }
        System.out.println(CommonConstant.LINE_BREAK);
    }
}
