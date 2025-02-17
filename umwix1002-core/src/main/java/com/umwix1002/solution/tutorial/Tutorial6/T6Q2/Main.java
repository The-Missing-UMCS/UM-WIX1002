package com.umwix1002.solution.tutorial.Tutorial6.T6Q2;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        try {
            displayOrder(-1, 2, 3, 4, 5);
        } catch (InvalidKeyException e) {
            System.out.println(e.getMessage());
        }

    }

    public static int[] displayOrder(int key, int... args) throws InvalidKeyException {
        if (!(key == 1 || key == -1)) {
            throw new InvalidKeyException();
        }

        int tmp = 0;
        for (int i = 0; i < args.length; i++) {
            for (int j = 0; j < args.length - i - 1; j++) {
                if ((args[j] - args[j + 1]) * key > 0) {
                    tmp = args[j];
                    args[j] = args[j + 1];
                    args[j + 1] = tmp;
                }
            }
        }

        IntStream.of(args).forEach(x -> System.out.print(x + " "));
        return args;
    }
}
