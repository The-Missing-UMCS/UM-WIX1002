package com.umwix1002.solution.viva.Viva_2324.Viva3_Tues.Q1;

public class Main {
    public static void main(String[] args) {
        String[] testcases = new String[] {
                "PTM", "PTMMTP", "BPTMBPTM", "PT", "PTMQ", "PTMQH", "BPTMQH", "PTMQH", "BPDTMGQH",
                "PTMQH", "PTMQH", "12PTHQGM", "12PTQHMG", "12PTMGQH", "PTMQBPTMQBPTMQ", "DTBP123QHMG",
                "BTDP", "TP", "TBP", "BDT", "DTP", "ABCD", "D"
        };

        for (String input : testcases) {
            System.out.printf("%-15s : %s\n", input, Aran.isValid(input));
        }

        Aran a1 = new Aran();
        Aran a2 = new Aran(5);
        System.out.println(a1);
        System.out.println(a2);
    }
}
