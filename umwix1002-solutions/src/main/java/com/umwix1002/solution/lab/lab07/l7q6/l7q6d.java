package com.umwix1002.solution.lab.lab07.l7q6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import static com.umwix1002.solution.Properties.*;

public class l7q6d {

    public static void main(String[] args) throws Exception {
        Map<String, Product> products = new HashMap<>();

        String productFile = chainDir(LAB7, IO_FILES, "product.txt");
        String orderFile = chainDir(LAB7, IO_FILES, "order.txt");

        try (
            BufferedReader productReader = new BufferedReader(new FileReader(productFile));
            BufferedReader orderReader = new BufferedReader(new FileReader(orderFile));
        ) {
            String line;

            // 1. Read product lines
            while ((line = productReader.readLine()) != null) {
                String[] info = line.split(",");

                String productId = info[0];
                String productName = info[1];
                double productPrice = Double.parseDouble(info[2]);
                products.put(productId, new Product(productId, productName, productPrice));
            }

            System.out.printf(" %-15s%-25s%-10s%15s%15s%n",
                "ProductID", "ProductName", "Quantity", "PricePerUnit", "Total");

            // 2. Read order lines
            while ((line = orderReader.readLine()) != null) {
                String[] info = line.split(",");

                String orderProductId = info[0];
                int orderUnit = Integer.parseInt(info[2]);
                Product product = products.get(orderProductId);

                if (product != null) {
                    System.out.printf(" %-15s%-25s%-10d%15.2f%15.2f%n",
                        product.id(), product.name(), orderUnit,
                        product.price(), product.price() * orderUnit);
                }
            }
        }
    }

    record Product(
        String id,
        String name,
        double price
    ) {

    }
}
