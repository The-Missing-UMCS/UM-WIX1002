package com.umwix1002.solution.lab.lab07.l7q5;

import org.jetbrains.annotations.NotNull;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.umwix1002.solution.Properties.*;

public class l7q5d {

    public static void main(String[] args) throws Exception {
        String file = chainDir(LAB7, IO_FILES, "person.dat");

        try (
            InputStream inputStream = new FileInputStream(file);
            ObjectInputStream input = new ObjectInputStream(inputStream)
        ) {
            final int N = input.readInt();

            List<Person> personList = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                personList.add(new Person(input.readUTF(), input.readInt(), input.readChar()));
            }

            Collections.sort(personList);

            for (Person person : personList) {
                System.out.printf(" %-13s %3d %3s %n",
                    person.name(), person.age(), person.gender());
            }
        }
    }

    record Person(
        String name,
        int age,
        char gender
    ) implements Comparable<Person> {

        @Override
        public int compareTo(@NotNull Person o) {
            return name.compareTo(o.name);
        }
    }
}





