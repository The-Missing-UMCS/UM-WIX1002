package com.umwix1002.solution.viva.viva2526.viva01.set01;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class viva2526v1s1q4c {

    public static void main(String[] args) {
        String input = """
            satayisverysedap
            3
            """;
        try (Scanner scanner = new Scanner(input)) {
            String word = scanner.next();
            int length = scanner.nextInt();

            List<String> gems = IntStream.range(0, word.length() - 2)
                .mapToObj(i -> word.substring(i, i + length))
                .toList();

            String firstWhisper = gems.stream()
                .min(String::compareTo)
                .orElse("");

            String lastEcho = gems.stream()
                .max(String::compareTo)
                .orElse("");

            String coreValue = gems.stream()
                .max(Comparator.comparingInt(s -> s.chars().sum()))
                .orElse("");

            System.out.println(firstWhisper);
            System.out.println(lastEcho);
            System.out.println(coreValue);
        }
    }
}
