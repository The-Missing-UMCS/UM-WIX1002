package com.umwix1002.solution.lab.lab07;

import com.umwix1002.solution.lab.lab07.helper.Gender;
import com.umwix1002.solution.lab.lab07.helper.Person;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.umwix1002.solution.lab.Properties.*;
import static com.umwix1002.solution.lab.constants.CommonConstant.ZERO;

/**
 * @author Ng Zhi Yang
 */
public class l7q5 {
    private static final String FILE = chainDir(LAB7, IO_FILES, "person.dat");
    
    public static void main(String[] args) throws IOException {
        List<Person> personList = new ArrayList<>();
        try (var input = Files.newInputStream(Path.of(FILE));
            var objectInput = new ObjectInputStream(input)) {
            final int n = objectInput.readInt();
            
            for (int i = ZERO; i < n; i++) {
                String name = objectInput.readUTF();
                int age = objectInput.readInt();
                char gender = objectInput.readChar();
                personList.add(new Person(name, age, Gender.getByCode(gender)));
            }
        }

        personList.sort(Comparator.comparing(Person::getName));
        personList.forEach(person ->
            System.out.printf(" %-13s %3d %3s \n", person.getName(), person.getAge(), person.getGender())
        );

    }
}

