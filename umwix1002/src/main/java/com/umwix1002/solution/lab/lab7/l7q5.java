package com.umwix1002.solution.lab.lab7;

import com.umwix1002.solution.lab.Properties;
import com.umwix1002.solution.lab.lab7.helper.Gender;
import com.umwix1002.solution.lab.lab7.helper.Person;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class l7q5 {
    public static void main(String[] args) throws IOException {
        List<Person> personList = new ArrayList<>();

        try (var input = Files.newInputStream(Path.of(Properties.PROJECT_ROUTE + "/lab7/io_files/person.dat"));
            var objectInput = new ObjectInputStream(input)) {
            final int N = objectInput.readInt();

            for (int i = 0; i < N; i++) {
                String name = objectInput.readUTF();
                int age = objectInput.readInt();
                char gender = objectInput.readChar();
                personList.add(new Person(name, age, Gender.getByShortName(gender)));
            }
        }

        personList.sort(Comparator.comparing(Person::getName));
        personList.forEach(person ->
            System.out.printf(" %-13s %3d %3s \n", person.getName(), person.getAge(), person.getGender())
        );

    }
}

