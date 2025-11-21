package com.umwix1002.solution.lab.lab08.l8q6;

/**
 * @author Ng Zhi Yang
 */
public class Main {

    public static void main(String[] args) {
        BurgerStall stallOne = new BurgerStall("A001");
        BurgerStall stallTwo = new BurgerStall("A002");

        stallOne.sold(100);
        System.out.printf("""
                %s total Sales = %d
                All sales = %d
                """,
            stallOne, stallOne.getTotalSold(),
            BurgerStall.getAllSales()
        );

        stallTwo.sold(230);
        System.out.printf("""
                %s total Sales = %d
                All sales = %d
                """,
            stallTwo, stallTwo.getTotalSold(),
            BurgerStall.getAllSales()
        );
    }
}
