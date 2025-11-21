package com.umwix1002.solution.pastyear.PastYear2025.py25q4;

import java.util.Arrays;

public class StringManipulator {

    private final String[] texts;

    public StringManipulator(String[] texts) {
        this.texts = texts;
    }

    public void clean() {
        for (int i = 0; i < texts.length; i++) {
            String line = texts[i];
            if (line == null) {
                continue;
            }
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < line.length(); j++) {
                char character = line.charAt(j);
                if (Character.isLetter(character)) {
                    builder.append(character);
                }
            }
            texts[i] = builder.toString();
        }
    }

    public void reverseTexts() {
        for (int i = 0; i < texts.length; i++) {
            String line = texts[i];
            if (line == null) {
                continue;
            }
            texts[i] = new StringBuilder(line).reverse().toString();
        }
    }

    public void rearrange() {
        Arrays.sort(texts);
    }

    public void display(String header) {
        System.out.println(header);
        for (String text : texts) {
            System.out.println(text);
        }
        System.out.println();
    }

    public String[] get() {
        return texts;
    }
}
