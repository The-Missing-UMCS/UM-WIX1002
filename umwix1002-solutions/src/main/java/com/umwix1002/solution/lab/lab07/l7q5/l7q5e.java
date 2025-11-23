package com.umwix1002.solution.lab.lab07.l7q5;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.umwix1002.solution.Properties.*;

public class l7q5e {

    public static void main(String[] args) throws Exception {
        String file = chainDir(LAB7, IO_FILES, "person.dat");

        try (
            InputStream inputStream = new FileInputStream(file);
            ObjectInputStream input = new ObjectInputStream(inputStream)
        ) {
            Map<String, Integer> nameAndAge = new LinkedHashMap<>();
            Map<String, Character> nameAndGender = new LinkedHashMap<>();

            final int N = input.readInt();

            String[] names = new String[N];

            for (int i = 0; i < N; i++) {
                names[i] = input.readUTF();
                nameAndAge.put(names[i], input.readInt());
                nameAndGender.put(names[i], input.readChar());
            }

            Arrays.sort(names);

            for (String name : names) {
                System.out.printf("Name: %-12s, Age: %-2d, Gender: %1s%n",
                    name, nameAndAge.get(name), nameAndGender.get(name));
            }
        }
    }
}
