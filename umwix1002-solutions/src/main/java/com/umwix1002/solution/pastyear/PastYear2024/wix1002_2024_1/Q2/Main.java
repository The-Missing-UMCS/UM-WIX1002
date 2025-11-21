package com.umwix1002.solution.pastyear.PastYear2024.wix1002_2024_1.Q2;


import com.umwix1002.solution.pastyear.PastYear2024.wix1002_2024_1.Q2.Q2a.Book;
import com.umwix1002.solution.pastyear.PastYear2024.wix1002_2024_1.Q2.Q2b.InvalidAgeException;
import com.umwix1002.solution.pastyear.PastYear2024.wix1002_2024_1.Q2.Q2c.Guitar;
import com.umwix1002.solution.pastyear.PastYear2024.wix1002_2024_1.Q2.Q2c.Piano;
import com.umwix1002.solution.pastyear.PastYear2024.wix1002_2024_1.Q2.Q2c.Playable;

public class Main {
    public static void main(String[] args) {
        // Q2a
        System.out.println(new Book("Book 1", "Unknown", 2024));

        // Q2b
        try {
            checkAge(14);
        } catch (InvalidAgeException e) {
            System.err.println(e.getMessage());
        }

        // Q2c
        Playable[] instruments = new Playable[] {
                new Guitar(), new Piano()
        };
        for (Playable instrument : instruments)
            instrument.play();
    }

    public static void checkAge(int age) throws InvalidAgeException {
        final int AGE_THRESHOLD = 18;
        final String ERROR_MESSAGE = "The age given (%d) is lower than %d. The age must be greater or equal to %d.";
        if (age < 18) {
            throw new InvalidAgeException(String.format(ERROR_MESSAGE, age, AGE_THRESHOLD, AGE_THRESHOLD));
        }
    }
}
