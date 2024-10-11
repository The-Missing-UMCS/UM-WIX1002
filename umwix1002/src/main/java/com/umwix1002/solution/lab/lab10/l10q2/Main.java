package com.umwix1002.solution.lab.lab10.l10q2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

import static com.umwix1002.solution.lab.Properties.*;

/**
 * @author Ng Zhi Yang
 */
public class Main {
    private static final String ENCODE_FROM = chainDir(LAB10, IO_FILES, "l10q2_encode_from.txt");
    private static final String ENCODE_TO = chainDir(LAB10, IO_FILES, "l10q2_encode_to.txt");
    private static final String DECODE_FROM = chainDir(LAB10, IO_FILES, "l10q2_decode_from.txt");
    private static final String DECODE_TO = chainDir(LAB10, IO_FILES, "l10q2_decode_to.txt");
    
    public static void main(String[] args) throws Exception {
        MessageEncoder substitutionCipher = new SubstitutionCipher();
        
        try (
            BufferedReader br = new BufferedReader(new FileReader(ENCODE_FROM));
            PrintWriter pw = new PrintWriter(ENCODE_TO)
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                String encodedLine = substitutionCipher.encode(line);
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
                String decodedLine = substitutionCipher.decode(line);
                pw.println(decodedLine);
            }
            System.out.println("Decoding completed successfully.");
        }
    }
}
