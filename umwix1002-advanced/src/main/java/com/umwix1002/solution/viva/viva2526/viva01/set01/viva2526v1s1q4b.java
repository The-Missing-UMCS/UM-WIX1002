package com.umwix1002.solution.viva.viva2526.viva01.set01;

import java.util.Scanner;

public class viva2526v1s1q4b {

    public static void main(String[] args) {
        String input = """
            satayisverysedap
            3
            """;
        try (Scanner scanner = new Scanner(input)) {
            String word = scanner.next();
            int length = scanner.nextInt();

            String firstWhisper = word.substring(0, length);
            String lastEcho = word.substring(0, length);
            String coreValue = word.substring(0, length);
            int coreValueWeight = coreValue.chars().sum();

            for (int i = 1; i < word.length() - 3; i++) {
                String nextGem = word.substring(i, i + 3);

                firstWhisper = nextGem.compareTo(firstWhisper) < 0 ? nextGem : firstWhisper;
                lastEcho = nextGem.compareTo(lastEcho) > 0 ? nextGem : lastEcho;

                int nextGemWeight = nextGem.chars().sum();
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
