package com.umwix1002.solution.pastyear.PastYear2017.wix1002_2017_1.Q3;

import java.util.Random;

public class Tester {
    public static void main(String[] args) {
        // 1. 生成字符串
        // 2. 使用冒泡排序
        System.out.println((char) 65); // 65 ? A
    }

    private static String generate() {
        Random random = new Random();
        // 生成大写字母
        String generated = "";

        // 1. 大写字母
        for(int i = 0; i < 6; i++) {
            char base = random.nextBoolean() ? 'A' : 'a';
            char character = (char) (random.nextInt(26) + base);
            generated += character;
        }

        // length = 2
        return generated;
    }

    public static void bubbleSort(char[] characters, int flag) {
        for (int i = 0; i < characters.length; i++) {
            boolean isSwap = false;
            for (int j = 0; j < characters.length - i - 1; j++) {
                if (flag * characters[j] > flag * characters[j + 1]) {
                    char temp = characters[j];
                    characters[j] = characters[j + 1];
                    characters[j + 1] = temp;
                    isSwap = true;
                }
            }
            if (!isSwap) {
                break;
            }
        }
    }
}
