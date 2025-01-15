package com.umwix1002.solution.lab.lab7.helper;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author Ng Zhi Yang
 */

@Getter
@AllArgsConstructor
public enum Gender {
    MALE("MALE", 'M'),
    FEMALE("FEMALE", 'F');
    
    private final String name;
    private final Character code;
    
    public static Gender getByCode(Character code) {
        return Arrays.stream(Gender.values())
            .filter(gender -> gender.getCode().equals(code))
            .findFirst()
            .orElse(null);
    }
}
