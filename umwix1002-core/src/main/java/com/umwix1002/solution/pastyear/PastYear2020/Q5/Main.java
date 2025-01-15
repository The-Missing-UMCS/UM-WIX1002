package com.umwix1002.solution.pastyear.PastYear2020.Q5;

import com.umwix1002.solution.pastyear.PastYear2020.Q5.domain.Delivery;
import com.umwix1002.solution.pastyear.PastYear2020.Q5.domain.SpecialDelivery;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Delivery> deliveries = List.of(
            new Delivery("Ali", "Ahmad", 4.4),
            new Delivery("Ah Chong", "Fatimah", 63.1),
            new SpecialDelivery("FSKTM, UM", "FK, UM", 32.5, true, false),
            new SpecialDelivery("Ang", "Liew", 19.0, true, true)
        );

        deliveries.forEach(System.out::println);

        double total = deliveries.stream()
            .mapToDouble(Delivery::calculateTotalCost)
            .sum();

        System.out.printf("The total shipping cost is RM %.2f%n", total);
    }
}
