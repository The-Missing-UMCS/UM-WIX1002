package com.umwix1002.solution.lab.lab05;

import java.util.BitSet;
import java.util.Random;

public class l5q2c {

    public static void main(String[] args) {
        Random random = new Random();
        int min = 1, max = 20, range = max - min + 1;

        BitSet bitSet = new BitSet();
        while (bitSet.cardinality() < 10) {
            int value = random.nextInt(range) + min;
            bitSet.set(value);
        }

        for (int i = bitSet.nextSetBit(0); i >= 0; i = bitSet.nextSetBit(i + 1)) {
            System.out.print(i + " ");
            if (i == Integer.MAX_VALUE) {
                break;
            }
        }
    }

}
