package com.umwix1002.solution.lab.Lab10.L10Q2;

public interface MessageEncoder {
    String encode(String plainText);

    String decode(String cipherText);
}
