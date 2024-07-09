package wix1002_2018_1.Q5;

public class Main {
    public static void main(String[] args) {
        Fruit[] fruits = {
                new Apple(Apple.RED, 8),
                new Apple(Apple.GREEN, 11),
                new Watermelon(Watermelon.LOCAL, 7.6),
                new Watermelon(Watermelon.IMPORTED, 4)
        };

        Fruit cheapestFruit = fruits[0];
        for (Fruit fruit : fruits) {
            System.out.println(fruit);
            if (fruit.totalPrice() < cheapestFruit.totalPrice()) {
                cheapestFruit = fruit;
            }
        }
        System.out.println("The cheapest item is\n" + cheapestFruit);

    }

}
