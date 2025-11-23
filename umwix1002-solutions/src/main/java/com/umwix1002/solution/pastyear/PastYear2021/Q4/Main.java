package com.umwix1002.solution.pastyear.PastYear2021.Q4;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String file = "umwix1002-core/src/main/java/com/umwix1002/solution/pastyear/PastYear2021/Q4/data.dat";

        int[] data = readFile(file);

        List<Eleven> rules = List.of(
//            new DivideF1(data),
            new DivideF1B(data)
//            new DivideF2(data)
        );

        rules.stream()
            .map(Eleven::divide)
            .forEach(System.out::println);
    }

    private static int[] readFile(String fileName) {
        List<Integer> values = new ArrayList<>();

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            while (true) {
                values.add(inputStream.readInt());
            }
        } catch (EOFException ignored) {
            // End of file reached, normal termination of loop
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return values.stream().mapToInt(Integer::intValue).toArray();
    }
}
