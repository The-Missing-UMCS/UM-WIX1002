package com.umwix1002.solution.lab.lab10.l10q3;

import com.umwix1002.solution.lab.lab10.l10q2.MessageCipher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

import static com.umwix1002.solution.lab.Properties.*;
import static com.umwix1002.solution.lab.Properties.IO_FILES;

/**
 * @author Ng Zhi Yang
 */
public class Main {
    private static final String ENCODE_FROM = chainDir(LAB10, IO_FILES, "l10q3_encode_from");
    private static final String ENCODE_TO = chainDir(LAB10, IO_FILES, "l10q3_encode_to");
    private static final String DECODE_FROM = chainDir(LAB10, IO_FILES, "l10q3_decode_from");
    private static final String DECODE_TO = chainDir(LAB10, IO_FILES, "l10q3_decode_to");
    
    public static void main(String[] args) throws Exception {
        MessageCipher shuffleCipher = new ShuffleCipher();

        try (
            BufferedReader br = new BufferedReader(new FileReader(ENCODE_FROM));
            PrintWriter pw = new PrintWriter(ENCODE_TO)
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                String encodedLine = shuffleCipher.encode(line);
                pw.println(encodedLine);
            }
            System.out.println("Encoding completed successfully.");
        }

        try (
            BufferedReader br = new BufferedReader(new FileReader(DECODE_FROM));
            PrintWriter pw = new PrintWriter(DECODE_TO)
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                String decodedLine = shuffleCipher.decode(line);
                pw.println(decodedLine);
            }
            System.out.println("Decoding completed successfully.");
        }
    }
}
