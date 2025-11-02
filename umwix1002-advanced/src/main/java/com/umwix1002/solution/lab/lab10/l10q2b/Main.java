package com.umwix1002.solution.lab.lab10.l10q2b;

public class Main {
    public static final String ROOT = "umwix1002-advanced/src/main/java/com/umwix1002/solution/lab/Lab10/io_files/";

    public static void main(String[] args) {
        String encodeInputFile = ROOT + "l10q2_encode_from.txt";
        String encodeOutputFile = ROOT + "l10q2_encode_to.txt";
        String decodeInputFile = ROOT + "l10q2_decode_from.txt";
        String decodeOutputFile = ROOT + "l10q2_decode_to.txt";
        int shiftKey = 3;

        SubstitutionCipher sc1 = new SubstitutionCipher(encodeInputFile, encodeOutputFile, shiftKey);
        sc1.convertTextToFile(AbstractCipher.ENCODE);

        SubstitutionCipher sc2 = new SubstitutionCipher(decodeInputFile, decodeOutputFile, shiftKey);
        sc2.convertTextToFile(AbstractCipher.DECODE);
    }
}