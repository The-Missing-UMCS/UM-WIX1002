package com.umwix1002.solution.viva.viva2526.viva01.set01;

import java.util.Scanner;

public class viva2526v1s1q4a {

    public static void main(String[] args) {
        String input = """
            satayisverysedap
            3
            """;
        try (Scanner scanner = new Scanner(input)) {
            String word = scanner.next();
            int length = scanner.nextInt();

            // 1. Get the initial firstWhisper
            String firstWhisper = "";
            for (int i = 0; i < length; i++) {
                firstWhisper += word.charAt(i);
            }

            // 2. Get the initial lastEcho
            String lastEcho = "";
            for (int i = 0; i < length; i++) {
                lastEcho += word.charAt(i);
            }

            // 3. Get the coreValue and coreValueWeight
            String coreValue = "";
            for (int i = 0; i < length; i++) {
                coreValue += word.charAt(i);
            }
            int coreValueWeight = 0;
            for (int i = 0; i < length; i++) {
                coreValueWeight += word.charAt(i);
            }

            // 4. Iterate through all substrings to calculate the values
            for (int i = 1; i < word.length() - 3; i++) {
                // 1. Get the nextGem
                String nextGem = "";
                for (int j = 0; j < length; j++) {
                    nextGem += word.charAt(i + j);
                }

                // 2.
                // Compare nextGem with firstWhisper
                // If nextGem is lexicographically smaller, then update the firstWhisper
                for (int j = 0; j < length; j++) {
                    if (nextGem.charAt(j) != firstWhisper.charAt(j)) {
                        if (nextGem.charAt(j) < firstWhisper.charAt(j)) {
                            firstWhisper = nextGem;
                        }
                        break;
                    }
                }

                // 3.
                // Compare nextGem with lastEcho
                // If nextGem is lexicographically larger, then update the lastEcho
                for (int j = 0; j < length; j++) {
                    if (nextGem.charAt(j) != lastEcho.charAt(j)) {
                        if (nextGem.charAt(j) > lastEcho.charAt(j)) {
                            lastEcho = nextGem;
                        }
                        break;
                    }
                }

                // 4.
                // Calculate the weight of nextGem
                // If nextGem has higher weight than coreValue, update the coreValue
                int nextGemWeight = 0;
                for (int j = 0; j < length; j++) {
                    nextGemWeight += nextGem.charAt(j);
                }
                if (nextGemWeight > coreValueWeight) {
                    coreValue = nextGem;
                    coreValueWeight = nextGemWeight;
                }
            }

            // 5. Print the result
            System.out.println(firstWhisper);
            System.out.println(lastEcho);
            System.out.println(coreValue);
        }
    }
}
