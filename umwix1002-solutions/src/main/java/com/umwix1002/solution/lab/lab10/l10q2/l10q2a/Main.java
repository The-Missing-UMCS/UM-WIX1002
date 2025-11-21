package com.umwix1002.solution.lab.lab10.l10q2.l10q2a;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.function.Function;

import static com.umwix1002.solution.Properties.*;

/**
 * @author Ng Zhi Yang
 */
public class Main {

    private static final String ENCODE_FROM = chainDir(LAB10, IO_FILES, "l10q2_encode_from.txt");
    private static final String ENCODE_TO = chainDir(LAB10, IO_FILES, "l10q2_encode_to.txt");
    private static final String DECODE_FROM = chainDir(LAB10, IO_FILES, "l10q2_decode_from.txt");
    private static final String DECODE_TO = chainDir(LAB10, IO_FILES, "l10q2_decode_to.txt");

    public static void main(String[] args) throws Exception {
        MessageCipher substitutionCipher = new SubstitutionCipher();
        process(ENCODE_FROM, ENCODE_TO, substitutionCipher::encode,
            "Encoding completed successfully.");
        process(DECODE_FROM, DECODE_TO, substitutionCipher::decode,
            "Decoding completed successfully.");
    }

    private static void process(String from,
                                String to,
                                Function<String, String> func,
                                String message) throws Exception {
        try (
            BufferedReader br = new BufferedReader(new FileReader(from));
            PrintWriter pw = new PrintWriter(to)
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                String encodedLine = func.apply(line);
                pw.println(encodedLine);
            }
            System.out.println(message);
        }
    }
}
