package com.umwix1002.solution.lab.lab10.l10q2b;

import lombok.RequiredArgsConstructor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

@RequiredArgsConstructor
public abstract class AbstractCipher implements MessageEncoder {
    public static final String ENCODE = "encode";
    public static final String DECODE = "decode";

    protected final String inputFileName;
    protected final String outputFileName;

    @Override
    public abstract String encode(String plainText);

    @Override
    public abstract String decode(String cipherText);

    public void convertTextToFile(String type) {
        try (PrintWriter writer = new PrintWriter(outputFileName)) {
            if (type.equals(ENCODE)) {
                writer.print(encode(readTextFromFile()));
            } else if (type.equals(DECODE)) {
                writer.print(decode(readTextFromFile()));
            }
            System.out.println("Successful");
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private String readTextFromFile() throws Exception {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
