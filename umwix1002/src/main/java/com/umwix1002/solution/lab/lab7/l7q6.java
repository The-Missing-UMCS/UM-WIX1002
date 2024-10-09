package com.umwix1002.solution.lab.lab7;

import com.umwix1002.solution.lab.CommonConstant;
import com.umwix1002.solution.lab.Properties;
import com.umwix1002.solution.lab.lab7.helper.Product;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ng Zhi Yang
 */
public class l7q6 {
    public static void main(String[] args) throws IOException {
        Map<String, Product> productList = new HashMap<>();
        List<String> productLines = Files.readAllLines(Path.of(Properties.PROJECT_ROUTE + "/lab7/io_files/product.txt"));
        for (String line : productLines) {
            String[] info = line.split(CommonConstant.COMMA);
            productList.put(info[0], new Product(info[0], info[1], Double.parseDouble(info[2])));
        }
        
        System.out.printf(" %-15s%-25s%-10s%15s%15s\n", "ProductID", "ProductName", "Quantity", "PricePerUnit", "Total");

        List<String> orderLines = Files.readAllLines(Path.of(Properties.PROJECT_ROUTE + "/lab7/io_files/order.txt"));
        for (String line : orderLines) {
            String[] info = line.split(CommonConstant.COMMA);
            int unit = Integer.parseInt(info[2]);
            Product product = productList.get(info[0]);

            if (product != null) {
                System.out.printf(" %-15s%-25s%-10d%15.2f%15.2f\n",
                    product.getId(), product.getName(), unit,
                    product.getPrice(), product.getPrice() * unit);
            }
        }

    }
}
