package com.umwix1002.solution.lab.Lab7.L7Q5;

import com.umwix1002.solution.lab.Lab7.Generator;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.LinkedHashMap;

import java.util.Arrays;

public class L7Q5E {

    @SneakyThrows
    public static void main(String[] args) {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(Generator.PERSON_FILE))) {
            LinkedHashMap<String, Integer> nameAndAge = new LinkedHashMap<>();
            LinkedHashMap<String, Character> nameAndGender = new LinkedHashMap<>();

            final int N = input.readInt();

            String[] names = new String[N];

            for (int i = 0; i < N; i++) {
                names[i] = input.readUTF();
                nameAndAge.put(names[i], input.readInt());
                nameAndGender.put(names[i], input.readChar());
            }

            input.close();

            Arrays.sort(names);

            for (String name : names) {
                System.out.printf("Name: %-12s, Age: %-2d, Gender: %1s\n", name, nameAndAge.get(name), nameAndGender.get(name));
            }
        }
    }
}
