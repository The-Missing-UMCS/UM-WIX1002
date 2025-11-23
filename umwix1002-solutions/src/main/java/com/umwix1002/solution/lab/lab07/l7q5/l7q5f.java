package com.umwix1002.solution.lab.lab07.l7q5;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.umwix1002.solution.Properties.*;

public class l7q5f {

    private static final String FILE = chainDir(LAB7, IO_FILES, "person.dat");

    public static void main(String[] args) throws IOException {
        List<Person> personList = new ArrayList<>();
        try (
            InputStream input = Files.newInputStream(Path.of(FILE));
            ObjectInputStream objectInput = new ObjectInputStream(input)
        ) {
            final int n = objectInput.readInt();

            for (int i = 0; i < n; i++) {
                String name = objectInput.readUTF();
                int age = objectInput.readInt();
                char gender = objectInput.readChar();
                personList.add(new Person(name, age, gender));
            }
        }

        personList.sort(Comparator.comparing(Person::name));
        personList.forEach(person -> System.out.printf(" %-13s %3d %3s %n",
            person.name(), person.age(), person.getGender())
        );
    }

    record Person(
        String name,
        int age,
        char gender
    ) {

        public String getGender() {
            return 'M' == gender ? "Male" : "Female";
        }
    }
}

