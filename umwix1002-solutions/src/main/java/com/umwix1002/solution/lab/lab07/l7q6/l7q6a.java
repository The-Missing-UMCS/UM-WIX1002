package com.umwix1002.solution.lab.lab07.l7q6;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static com.umwix1002.solution.Properties.*;

public class l7q6a {

    public static void main(String[] args) throws IOException {
        String productFile = chainDir(LAB7, IO_FILES, "product.txt");
        String orderFile = chainDir(LAB7, IO_FILES, "order.txt");

        int initialSize = 10;

        // 1. Get product information
        String[] productId = new String[initialSize];
        String[] productName = new String[initialSize];
        double[] productPrice = new double[initialSize];

        try (Scanner scanner = new Scanner(new File(productFile))) {
            for (int index = 0; scanner.hasNextLine(); index++) {
                if (index == productId.length) {
                    productId = upsize(productId);
                    productName = upsize(productName);
                    productPrice = upsize(productPrice);
                }
                String[] parts = scanner.nextLine().split(",");
                productId[index] = parts[0];
                productName[index] = parts[1];
                productPrice[index] = Double.parseDouble(parts[2]);
            }
        }

        // 2. Get order information
        String[] orderProductId = new String[initialSize];
        String[] orderProductName = new String[initialSize];
        int[] orderUnit = new int[initialSize];

        try (Scanner scanner = new Scanner(new File(orderFile))) {
            for (int index = 0; scanner.hasNextLine(); index++) {
                if (index == productId.length) {
                    orderProductId = upsize(orderProductId);
                    orderProductName = upsize(orderProductName);
                    orderUnit = upsize(orderUnit);
                }
                String[] parts = scanner.nextLine().split(",");
                orderProductId[index] = parts[0];
                orderProductName[index] = parts[1];
                orderUnit[index] = Integer.parseInt(parts[2]);
            }
        }

        System.out.printf(" %-15s%-25s%10s%15s%15s%n",
            "ProductID", "ProductName", "Quantity", "PricePerUnit", "Total");

        for (int i = 0; i < orderProductId.length; i++) {
            // No more
            if (orderProductId[i] == null) {
                break;
            }

            String targetProductId = orderProductId[i];
            String targetProductName = orderProductName[i];
            int unit = orderUnit[i];

            double targetProductPrice = -1;

            for (int j = 0; j < productId.length; j++) {
                if (targetProductId.equals(productId[j])) {
                    targetProductPrice = productPrice[j];
                }
            }

            // Target product it not found
            if (targetProductPrice == -1) {
                continue;
            }

            System.out.printf(" %-15s%-25s%10d%15.2f%15.2f%n",
                targetProductId, targetProductName, unit, targetProductPrice,
                targetProductPrice * unit
            );
        }
    }

    private static String[] upsize(String[] array) {
        String[] result = new String[array.length * 2];
        System.arraycopy(array, 0, result, 0, array.length);
        return result;
    }

    private static double[] upsize(double[] array) {
        double[] result = new double[array.length * 2];
        System.arraycopy(array, 0, result, 0, array.length);
        return result;
    }

    private static int[] upsize(int[] array) {
        int[] result = new int[array.length * 2];
        System.arraycopy(array, 0, result, 0, array.length);
        return result;
    }
}
