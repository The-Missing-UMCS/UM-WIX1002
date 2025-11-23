package com.umwix1002.solution.pastyear.PastYear2019.wix1002_2019_1.Q5;

public class Main {

    public static void main(String[] args) {
        double total = 0;
        // create the object
        Delivery a = new Delivery("Ali", "Ahmad", 4.4);
        Delivery b = new Delivery("Ah Chong", "Fatimah", 63.1);
        SpecialDelivery c = new SpecialDelivery("FSKTM, UM", "FK, UM", 32.5, true, false);
        SpecialDelivery d = new SpecialDelivery("Ang", "Liew", 19.0, true, true);

        // show the shipping for each delivery
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());
        System.out.println(d.toString());

        // calculate and show the grand total
        total += a.totalCost();
        total += b.totalCost();
        total += c.totalCost();
        total += d.totalCost();
        System.out.println("The total shipping cost is RM " + total);


    }
}
