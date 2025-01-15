package com.umwix1002.solution.lab.Lab7.L7Q6;

import com.umwix1002.solution.lab.Lab7.Generator;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

// Credit to: https://gitlab.com/fop2022/group05/-/blob/main/22004835/lab%207/L7Q6.java

public class L7Q6A {
    public static void main(String[] args) {
        String[][] productArr = loadDataMatrix(Generator.PRODUCT_FILE);
        String[][] orderArr = loadDataMatrix(Generator.ORDER_FILE);
        showOrder(productArr, orderArr);
    }

    public static int findIndex(String orderId, String[][] productArr) {
        for (int i = 0; i < productArr.length; i++)
            if (productArr[i][0].equals(orderId))
                return i;
        return -1;
    }

    @SneakyThrows
    public static String[][] loadDataMatrix(String fromFile) {
        // Initialize a matrix. The matrix may expand later.
        String[][] matrix = new String[3][3];

        try (Scanner scanner = new Scanner(new FileInputStream(fromFile))) {

            for (int i = 0; scanner.hasNextLine(); i++) {
                if (i == matrix.length) {
                    // Expand the matrix by 1 when reaches it's limit.
                    matrix = Arrays.copyOf(matrix, i + 1);
                    i--;
                    continue;
                }

                matrix[i] = scanner.nextLine().split(",");
            }

        }
        return matrix;
    }

    public static void showOrder(String[][] productMatrix, String[][] orderMatrix) {
        // Header
        System.out.printf(" %-15s%-25s%-10s%15s%15s\n",
            "ProductID", "ProductName", "Quantity", "PricePerUnit", "Total");

        for (String[] matrix : orderMatrix) {
            int index = findIndex(matrix[0], productMatrix);

            if (index > 0) {
                // For the sake of readability
                String[] product = productMatrix[index];
                int count = Integer.parseInt(matrix[2]);
                double price = Double.parseDouble(product[2]);

                // Print order list
                System.out.printf(" %-15s%-25s%-10s%15s%15.2f\n",
                    product[0], product[1], count, product[2], price * count);
            }
        }
    }
}