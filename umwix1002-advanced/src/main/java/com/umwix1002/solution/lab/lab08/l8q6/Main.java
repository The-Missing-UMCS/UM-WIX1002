package com.umwix1002.solution.lab.lab08.l8q6;

/**
 * @author Ng Zhi Yang
 */
public class Main {
    public static void main(String[] args) {
        BurgerStall stallOne = new BurgerStall("A001");
        BurgerStall stallTwo = new BurgerStall("A002");
        
        stallOne.sold(100);
        System.out.println(stallOne + " total Sales = " + stallOne.getTotalSold());
        System.out.println("All sales = " + BurgerStall.getAllSales());
        
        stallTwo.sold(230);
        System.out.println(stallTwo + " total Sales = " + stallTwo.getTotalSold());
        System.out.println("All sales = " + BurgerStall.getAllSales());
    }
}
