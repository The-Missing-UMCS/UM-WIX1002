package com.umwix1002.solution.pastyear.PastYear2022.Q2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import static com.umwix1002.solution.Properties.PAST_YEAR;

public class Main {
    private static final String[] LABELS = {"Gold", "Silver", "Bronze"};
    private static final String FILE = PAST_YEAR + "PastYear2022/Q2/diving.txt";
    private static final int ATTEMPTS = 3;
    private static final int JUDGES = 7;

    public static void main(String[] args) {
        List<Diving> divingList = readDivingDataFromFile();

        displayDivingList(divingList);
        displayTopDivers(divingList, 3);
    }

    private static List<Diving> readDivingDataFromFile() {
        try (Scanner scanner = new Scanner(new FileInputStream(FILE))) {
            return parseDivingData(scanner);
        } catch (IOException ex) {
            System.err.println("Error reading file: " + ex.getMessage());
            return Collections.emptyList();
        }
    }

    private static List<Diving> parseDivingData(Scanner scanner) {
        List<Diving> divingList = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String name = scanner.nextLine();
            String country = scanner.nextLine();
            double[][] scores = new double[ATTEMPTS][JUDGES];
            double[] difficulty = new double[ATTEMPTS];

            for (int attempt = 0; attempt < ATTEMPTS; attempt++) {
                String[] line = scanner.nextLine().split(" ");
                for (int judge = 0; judge < JUDGES; judge++) {
                    scores[attempt][judge] = Double.parseDouble(line[judge]);
                }
                difficulty[attempt] = Double.parseDouble(line[7]);
            }

            divingList.add(new Diving(name, country, scores, difficulty));
        }

        return divingList;
    }

    private static void displayDivingList(List<Diving> divingList) {
        divingList.forEach(System.out::println);
    }

    private static void displayTopDivers(List<Diving> divingList, int topCount) {
        List<Diving> sortedDivingList = new ArrayList<>(divingList);
        sortedDivingList.sort(Comparator.comparingDouble(Diving::getFinalScore).reversed());

        sortedDivingList.stream()
            .limit(topCount)
            .forEachOrdered(diver -> {
                String label = LABELS[sortedDivingList.indexOf(diver)];
                System.out.printf("%s : %s (%s)%n", label, diver.name(), diver.country());
            });
    }
}