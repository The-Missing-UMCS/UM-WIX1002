package com.umwix1002.solution.lab.lab07;

import com.umwix1002.solution.lab.lab07.helper.Product;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.umwix1002.solution.lab.Properties.*;
import static com.umwix1002.solution.lab.constants.CommonConstant.*;

/**
 * @author Ng Zhi Yang
 */
public class l7q6 {
    private static final String INPUT_FILE = chainDir(LAB7, IO_FILES, "product.txt");
    private static final String OUTPUT_FILE = chainDir(LAB7, IO_FILES, "order.txt");

    // 1. throw new IllegalArgumentException() -> 程序员主动声明的，告诉用户他们做错了一些东西
    // 2. throws IOException -> try/catch, throws Exception
    // 3. extends OOP - inheritance Children extends Parent, Cat extends Animal`
    public static void main(String[] args) throws IOException {
        Map<String, Product> productMap = new HashMap<>();
        
        List<String> productLines = Files.readAllLines(Path.of(INPUT_FILE));
        for (String line : productLines) {
            String[] info = line.split(COMMA);
            productMap.put(info[ZERO], new Product(info[ZERO], info[ONE], Double.parseDouble(info[TWO])));
        }
        System.out.printf(" %-15s%-25s%-10s%15s%15s\n", "ProductID", "ProductName", "Quantity", "PricePerUnit", "Total");

        List<String> orderLines = Files.readAllLines(Path.of(OUTPUT_FILE));
        
        orderLines.forEach(line -> {
            String[] info = line.split(COMMA);
            int unit = Integer.parseInt(info[TWO]);
            Product product = productMap.get(info[ZERO]);

            if (Objects.nonNull(product)) {
                System.out.printf(" %-15s%-25s%-10d%15.2f%15.2f\n",
                    product.getId(), product.getName(), unit, product.getPrice(), product.getPrice() * unit);
            }
        });

    }
}
