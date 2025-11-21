package com.umwix1002.solution.lab.lab07.l7q6;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

import static com.umwix1002.solution.Properties.*;

// Credit to: https://gitlab.com/fop2022/group05/-/blob/main/22004835/lab%207/L7Q6.java

public class l7q6c {

    public static void main(String[] args) throws Exception {
        String productFile = chainDir(LAB7, IO_FILES, "product.txt");
        String orderFile = chainDir(LAB7, IO_FILES, "order.txt");

        String[][] products = loadDataMatrix(productFile);
        String[][] orders = loadDataMatrix(orderFile);

        showOrder(products, orders);
    }

    private static String[][] loadDataMatrix(String fromFile) throws Exception {
        // Initialize a matrix. The matrix may expand later.
        String[][] matrix = new String[3][3];

        try (Scanner scanner = new Scanner(new FileInputStream(fromFile))) {
            for (int i = 0; scanner.hasNextLine(); i++) {
                if (i == matrix.length) {
                    // Expand the matrix when reaches it's limit.
                    matrix = Arrays.copyOf(matrix, i * 2);
                }
                matrix[i] = scanner.nextLine().split(",");
            }
        }

        return matrix;
    }

    private static void showOrder(String[][] productMatrix, String[][] orderMatrix) {
        // Header
        System.out.printf(" %-15s%-25s%-10s%15s%15s%n",
            "ProductID", "ProductName", "Quantity", "PricePerUnit", "Total");

        for (String[] order : orderMatrix) {
            String orderProductId = order[0];

            int index = findIndex(orderProductId, productMatrix);

            boolean found = index != -1;

            if (found) {
                // For the sake of readability
                String[] product = productMatrix[index];
                String productId = product[0];
                String productName = product[1];
                double price = Double.parseDouble(product[2]);
                int unit = Integer.parseInt(order[2]);

                // Print order list
                System.out.printf(" %-15s%-25s%-10s%15s%15.2f%n",
                    productId, productName, unit, price, price * unit);
            }
        }
    }

    private static int findIndex(String orderId, String[][] productArr) {
        for (int i = 0; i < productArr.length; i++) {
            if (productArr[i][0].equals(orderId)) {
                return i;
            }
        }
        return -1;
    }

}