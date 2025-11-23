package com.umwix1002.solution.pastyear.PastYear2020.Q3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class FrequencyTable {
    private final File file;
    private int[] freq;

    public FrequencyTable(String file) {
        this.file = new File(file);
        this.freq = new int[5];
        load();
    }

    private void load() {
        try (Scanner scanner = new Scanner(file)) {
            scanner.tokens()
                .mapToInt(Integer::parseInt)
                .map(i -> i / 2 - 1)
                .filter(i -> i >= 0 && i < freq.length)
                .forEach(i -> freq[i]++);
        } catch (IOException ex) {
            freq = new int[5];
        }
    }

    public void print() {
        System.out.println("Frequency Distribution Table");
        IntStream.range(0, freq.length)
            .forEach(i -> System.out.printf("%d : %d%n", (i + 1) * 2, freq[i]));

        System.out.println("The mode of the data set is: " + findMode());
    }

    public int findMode() {
        return (IntStream.range(0, freq.length)
            .reduce((i, j) -> freq[i] > freq[j] ? i : j)
            .orElse(-1) + 1) * 2;
    }
}

