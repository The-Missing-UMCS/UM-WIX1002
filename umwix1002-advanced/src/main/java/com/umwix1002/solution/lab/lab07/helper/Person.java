package com.umwix1002.solution.lab.lab07.helper;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Ng Zhi Yang
 */
@Data
@AllArgsConstructor
public class Person {
    private String name;
    private Integer age;
    private Gender gender;
}
