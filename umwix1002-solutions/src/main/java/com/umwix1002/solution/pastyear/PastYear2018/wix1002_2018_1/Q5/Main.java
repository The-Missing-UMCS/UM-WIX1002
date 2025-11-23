package com.umwix1002.solution.pastyear.PastYear2018.wix1002_2018_1.Q5;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Fruit> fruits = List.of(
            new Apple(Apple.RED, 8),
            new Apple(Apple.GREEN, 11),
            new Watermelon(Watermelon.LOCAL, 7.6),
            new Watermelon(Watermelon.IMPORTED, 4)
        );

        String fruitsString = fruits.stream()
            .map(fruit -> "  - " + fruit)
            .collect(Collectors.joining(System.lineSeparator()));
        System.out.println("The list of fruits are: \n" + fruitsString);

        String cheapestFruitString = fruits.stream()
            .min(Comparator.comparingDouble(Fruit::totalPrice))
            .map(String::valueOf)
            .orElse("No fruit found");
        System.out.println("The cheapest item is: " + cheapestFruitString);
    }
}
