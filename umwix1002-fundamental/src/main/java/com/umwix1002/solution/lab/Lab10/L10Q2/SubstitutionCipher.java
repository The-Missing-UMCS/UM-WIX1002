package com.umwix1002.solution.lab.Lab10.L10Q2;

import java.util.function.Function;

public class SubstitutionCipher extends AbstractCipher {
    private static final int LOWER_Z_ASCII = 122;
    private static final int UPPER_Z_ASCII = 90;
    private static final int LOWER_A_ASCII = 97;
    private static final int UPPER_A_ASCII = 65;

    private final int shiftKey;

    public SubstitutionCipher(String inputFileName, String outputFileName, int shiftKey) {
        super(inputFileName, outputFileName);
        this.shiftKey = shiftKey;
    }

    @Override
    public String encode(String plainText) {
        return process(plainText, (ch) -> encode(ch, Character.isLowerCase(ch) ? LOWER_A_ASCII : UPPER_A_ASCII));
    }

    @Override
    public String decode(String cipherText) {
        return process(cipherText, (ch) -> decode(ch, Character.isLowerCase(ch) ? LOWER_Z_ASCII : UPPER_Z_ASCII));
    }

    private String process(String content, Function<Character, Character> func) {
        StringBuilder sb = new StringBuilder();
        for (char ch : content.toCharArray()) {
            sb.append(Character.isLowerCase(ch) ? func.apply(ch) : ch);
        }
        return sb.toString();
    }

    private char encode(char ch, int startKey) {
        return (char) (((int) ch + shiftKey - startKey) % 26 + startKey - ((int) ch + shiftKey - startKey) / 26);
    }

    private char decode(char ch, int endKey) {
        return (char) (endKey - (endKey - (int) ch + shiftKey) % 26);
    }
}
