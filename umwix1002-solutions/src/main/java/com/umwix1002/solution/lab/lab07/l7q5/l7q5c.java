package com.umwix1002.solution.lab.lab07.l7q5;

import org.jetbrains.annotations.NotNull;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;

import static com.umwix1002.solution.Properties.*;

public class l7q5c {

    public static void main(String[] args) throws Exception {
        String file = chainDir(LAB7, IO_FILES, "person.dat");

        try (
            FileInputStream inputStream = new FileInputStream(file);
            ObjectInputStream input = new ObjectInputStream(inputStream)
        ) {
            Person[] personList = new Person[input.readInt()];

            for (int i = 0; i < personList.length; i++) {
                personList[i] = new Person(input.readUTF(), input.readInt(), input.readChar());
            }

            Arrays.sort(personList);

            for (Person person : personList) {
                System.out.printf(" %-13s %3d %3s %n",
                    person.name(), person.age(), person.getGender());
            }
        }
    }

    record Person(
        String name,
        int age,
        char gender
    ) implements Comparable<Person> {

        public String getGender() {
            return 'M' == gender ? "Male" : "Female";
        }

        @Override
        public int compareTo(@NotNull Person o) {
            return name.compareTo(o.name());
        }
    }
}
