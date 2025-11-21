package com.umwix1002.solution.pastyear.PastYear2020.Q3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                String input = sc.nextLine();

                if ("quit".equals(input))
                    break;

                if (!(containsStartGene(input) && containsEndGene(input))) {
                    System.out.println("No gene.");
                    continue;
                }

                var genes = getGenes(input);

                if (genes.isEmpty()) {
                    System.out.println("No gene is found");
                } else {
                    genes.forEach(System.out::println);
                }
            }
        }
    }

    public static ArrayList<String> getGenes(String sequence) {
        ArrayList<String> genes = new ArrayList<>();
        int startIndex = sequence.indexOf("ATG");
        int length = sequence.length();

        while (startIndex != -1 && startIndex < length - 6) {
            StringBuilder gene = new StringBuilder();

            for (int i = startIndex + 3; i <= length - 3; i += 3) {
                String codon = sequence.substring(i, i + 3);
                if (containsEndGene(codon) && isValidGene(gene.toString())) {
                    break;
                }
                gene.append(codon);
            }

            if (isValidGene(gene.toString())) {
                genes.add(gene.toString());
            }

            startIndex = sequence.indexOf("ATG", startIndex + 3);
        }
        return genes;
    }

    public static boolean isValidGene(String sequence) {
        return !sequence.isEmpty() && sequence.length() % 3 == 0 &&
            !containsStartGene(sequence) && !containsEndGene(sequence);
    }

    public static boolean containsEndGene(String sequence) {
        return sequence.contains("TAG") || sequence.contains("TAA") || sequence.contains("TGA");
    }

    public static boolean containsStartGene(String sequence) {
        return sequence.contains("ATG");
    }

}