package com.umwix1002.solution.lab.lab10.l10q3.l10q3b;


import com.umwix1002.solution.lab.lab10.l10q2.l10q2b.AbstractCipher;

import java.util.function.Function;

public class ShuffleCipher extends AbstractCipher {

    private final int shuffleCount;

    ShuffleCipher(String inputFileName, String outputFileName, int count) {
        super(inputFileName, outputFileName);
        this.shuffleCount = count;
    }

    @Override
    public String encode(String plainText) {
        return process(plainText, this::shuffle);
    }

    @Override
    public String decode(String cipherText) {
        return process(cipherText, this::unShuffle);
    }

    private String process(String content, Function<String, String> func) {
        String result = content;
        for (int i = 0; i < this.shuffleCount; i++) {
            result = func.apply(result);
        }
        return result;
    }

    public String shuffle(String content) {
        StringBuilder sb = new StringBuilder();
        int mid = content.length() / 2;

        String left = content.substring(0, mid);
        String right = content.substring(mid);

        for (int i = 0; i < mid; i++) {
            sb.append(left.charAt(i)).append(right.charAt(i));
        }

        sb.append((right.length() > left.length()) ? right.charAt(mid) : "");

        return sb.toString();
    }

    public String unShuffle(String str) {
        StringBuilder sb = new StringBuilder();

        int length = (str.length() / 2) * 2;

        //abc123
        //a1b2dc3

        // a - 0, b = 2, c = 4
        // a b c 1 2 3

        for (int i = 0; i < length; i += 2) {
            sb.append(str.charAt(i));
        }

        for (int i = 1; i < length; i += 2) {
            sb.append(str.charAt(i));
        }

        sb.append((str.length() % 2 == 1) ? str.charAt(str.length() - 1) : "");

        return sb.toString();
    }

}