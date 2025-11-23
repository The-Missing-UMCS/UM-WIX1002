package com.umwix1002.solution.lab.lab10.l10q4.l10q4a;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        Repository repository = new Repository();
        Presenter presenter = new Presenter();

        LocalDateTime[][] appointments = getAppointments();

        for (LocalDateTime[] slot : appointments) {
            LocalDateTime start = slot[0];
            LocalDateTime end = slot[1];

            boolean success = repository.makeAppointment(start, end);

            System.out.print(message(start, end, success));
        }

        repository.doneAppointment(2);
        presenter.present(repository.getAppointments());
    }

    private static LocalDateTime[] @NotNull [] getAppointments() {
        return new LocalDateTime[][]{
            {
                LocalDateTime.of(2022, 12, 16, 17, 0),
                LocalDateTime.of(2022, 12, 16, 19, 0)
            },
            {
                LocalDateTime.of(2022, 12, 16, 12, 0),
                LocalDateTime.of(2022, 12, 16, 13, 0)
            },
            {
                LocalDateTime.of(2022, 12, 17, 12, 0),
                LocalDateTime.of(2022, 12, 17, 13, 0)
            },
            {
                LocalDateTime.of(2022, 12, 16, 11, 0),
                LocalDateTime.of(2022, 12, 16, 12, 0)
            },
            {
                LocalDateTime.of(2022, 12, 16, 16, 0),
                LocalDateTime.of(2022, 12, 16, 18, 0)
            },
            {
                LocalDateTime.of(2023, 1, 1, 11, 0),
                LocalDateTime.of(2023, 1, 1, 12, 0)
            }
        };
    }

    private static String message(LocalDateTime start,
                                  LocalDateTime end,
                                  boolean isSuccess) {
        return String.format(
            " ==> %2d-%2d-%d -->  %2d:%02d ~ %2d:%02d  --> Appointment %s.%n",
            start.getDayOfMonth(),
            start.getMonthValue(),
            start.getYear(),
            start.getHour(),
            start.getMinute(),
            end.getHour(),
            end.getMinute(),
            isSuccess ? "Success" : "Failed"
        );
    }

}
