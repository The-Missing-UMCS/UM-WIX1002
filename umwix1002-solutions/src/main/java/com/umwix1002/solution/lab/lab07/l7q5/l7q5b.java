package com.umwix1002.solution.lab.lab07.l7q5;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;

import static com.umwix1002.solution.Properties.*;

public class l7q5b {

    public static void main(String[] args) throws Exception {
        String file = chainDir(LAB7, IO_FILES, "person.dat");

        try (
            InputStream inputStream = new FileInputStream(file);
            ObjectInputStream input = new ObjectInputStream(inputStream)
        ) {
            final int N = input.readInt();
            String[][] personList = new String[N][3];

            for (int i = 0; i < N; i++) {
                personList[i][0] = input.readUTF();
                personList[i][1] = Integer.toString(input.readInt());
                personList[i][2] = Character.toString(input.readChar());
            }

            sortMatrixByName(personList);

            for (String[] person : personList) {
                System.out.printf(" %-13s %3s %3s %n", person[0], person[1], person[2]);
            }
        }
    }

    public static void sortMatrixByName(String[][] personList) {
        for (int i = 0; i < personList.length; i++) {
            boolean isSorted = false;
            for (int j = 0; j < personList.length - 1 - i; j++) {
                if (personList[j][0].compareTo(personList[j + 1][0]) > 0) {
                    String[] tmp = personList[j];
                    personList[j] = personList[j + 1];
                    personList[j + 1] = tmp;
                    isSorted = true;
                }
            }
            if (!isSorted) {
                break;
            }
        }
    }
}
