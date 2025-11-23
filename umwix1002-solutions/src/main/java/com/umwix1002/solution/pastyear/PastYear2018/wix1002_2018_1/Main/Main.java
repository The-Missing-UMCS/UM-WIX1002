package com.umwix1002.solution.pastyear.PastYear2018.wix1002_2018_1.Main;

public class Main {
    public static void main(String[] args) {
        Apple redApple = new Apple("Red Apple", "RED", 8);
        Apple greenApple = new Apple("Green Apple", "GREEN", 11);
        Watermelon localWatermelon = new Watermelon("Local Watermelon", "LOCAL", 7.6);
        Watermelon importedWatermelon = new Watermelon("Imported Watermelon", "IMPORTED", 4);

        Fruit[] fruits = new Fruit[] {redApple, greenApple, localWatermelon, importedWatermelon};

        Fruit cheapestFruit = fruits[0];
        for(Fruit fruit : fruits) {
            if(fruit.totalPrice() < cheapestFruit.totalPrice()) {
                cheapestFruit = fruit;
            }
            System.out.println(fruit);
        }
        System.out.println(cheapestFruit);
    }
}
