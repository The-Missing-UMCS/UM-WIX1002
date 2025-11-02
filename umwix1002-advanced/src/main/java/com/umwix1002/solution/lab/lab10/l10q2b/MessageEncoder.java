package com.umwix1002.solution.lab.lab10.l10q2b;

public interface MessageEncoder {
    String encode(String plainText);

    String decode(String cipherText);
}
