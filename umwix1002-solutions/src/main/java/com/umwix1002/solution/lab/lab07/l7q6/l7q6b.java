package com.umwix1002.solution.lab.lab07.l7q6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.umwix1002.solution.Properties.*;

public class l7q6b {

    public static void main(String[] args) throws IOException {
        String productFile = chainDir(LAB7, IO_FILES, "product.txt");
        String orderFile = chainDir(LAB7, IO_FILES, "order.txt");

        var productMap = Files.readAllLines(Path.of(productFile))
            .stream()
            .map(l7q6b::mapLineToProduct)
            .filter(Objects::nonNull)
            .collect(Collectors.toUnmodifiableMap(Product::id, Function.identity()));

        System.out.printf(" %-15s%-25s%-10s%15s%15s%n",
            "ProductID", "ProductName", "Quantity", "PricePerUnit", "Total");

        var orders = Files.readAllLines(Path.of(orderFile))
            .stream()
            .map(l7q6b::mapLineToOrder)
            .filter(Objects::nonNull)
            .toList();

        orders.forEach(order -> {
            Product product = productMap.get(order.productId());
            if (Objects.nonNull(product)) {
                System.out.printf(" %-15s%-25s%-10d%15.2f%15.2f%n",
                    product.id(), product.name(), order.unit(), product.price(),
                    product.price() * order.unit()
                );
            }
        });
    }

    private static Product mapLineToProduct(String line) {
        String[] parts = line.split(",");
        return parts.length == 3
               ? new Product(parts[0], parts[1], Double.parseDouble(parts[2]))
               : null;
    }

    private static Order mapLineToOrder(String line) {
        String[] parts = line.split(",");
        return parts.length == 3
               ? new Order(parts[0], parts[1], Integer.parseInt(parts[2]))
               : null;
    }

    record Order(
        String productId,
        String productName,
        int unit
    ) {

    }

    record Product(
        String id,
        String name,
        double price
    ) {

    }
}
