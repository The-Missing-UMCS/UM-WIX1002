package com.umwix1002.solution.lab.lab09.l9q2.l9q2a;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
public class Profile {
    protected final String name;
    protected final char gender;
    protected final String dob;

    protected void showDetails() {
        // optional to implement
    }
}
