package com.umwix1002.solution.lab.lab09.l9q2.l9q2b;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Gender {
    MALE("MALE", 'M'),
    FEMALE("FEMALE", 'F'),
    ;

    private final String code;
    private final char character;
}
