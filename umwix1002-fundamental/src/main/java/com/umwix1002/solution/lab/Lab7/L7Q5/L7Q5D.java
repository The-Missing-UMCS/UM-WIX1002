package com.umwix1002.solution.lab.Lab7.L7Q5;

import com.umwix1002.solution.lab.Lab7.Generator;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Collections;

import java.util.ArrayList;

public class L7Q5D {

    @SneakyThrows
    public static void main(String[] args) {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(Generator.PERSON_FILE))) {
            final int N = input.readInt();

            ArrayList<Person> personList = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                personList.add(new Person(input.readUTF(), input.readInt(), input.readChar()));
            }

            Collections.sort(personList);

            for (Person person : personList) {
                System.out.printf(" %-13s %3d %3s \n", person.name(), person.age(), person.gender());
            }
        }
    }
}





