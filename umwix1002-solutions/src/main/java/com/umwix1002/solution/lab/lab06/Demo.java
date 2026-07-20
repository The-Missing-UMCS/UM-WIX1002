package com.umwix1002.solution.lab.lab06;

import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {
        sayHello(2);
    }

    public static void sayHello(int n) {
        if (n <= 0) {
            return;
        }
        System.out.println("Hello World");
        sayHello(n - 1);
    }

    public static int[] sort(int[] array) {
        int[] newArray = new int[array.length];
        System.arraycopy(array, 0, newArray, 0, array.length);
        Arrays.sort(newArray);
        return newArray;
    }


}
